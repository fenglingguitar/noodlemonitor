package org.fl.noodlemonitor.console.web.persistence;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.fl.noodle.common.monitor.performance.persistence.PerformancePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildTree {

	private final static Logger logger = LoggerFactory.getLogger(BuildTree.class);
	
	public static ConcurrentMap<String, Set<String>> ipMap = new ConcurrentHashMap<String, Set<String>>();
	public static ConcurrentMap<String, Set<String>> methodMap = new ConcurrentHashMap<String, Set<String>>();
	
	private PerformancePersistence performancePersistence;
	
	private long intervalTime = 60000;
	
	public void start() {
		
		Thread buildTreeRunnable = new Thread(new BuildTreeRunnable());
		buildTreeRunnable.setDaemon(true);
		buildTreeRunnable.setName("BuildTreeRunnable");
		buildTreeRunnable.start();
	}
	
	class BuildTreeRunnable implements Runnable {

		@Override
		public void run() {
			
			while (true) {
				
				Set<String> keysSet = null;
				
				try {
					keysSet = performancePersistence.getKeys();
				} catch (Exception e) {
					if (logger.isErrorEnabled()) {
						logger.error("BuildTreeRunnable -> redisPerformancePersistence.getKeys -> Exception:{}", e.getMessage());
					}
				}
				
				if (keysSet != null) {
					for (String key : keysSet) {
						String[] keyArray = key.split("-");
						if (keyArray.length < 7) {
							if (logger.isErrorEnabled()) {
								logger.error("BuildTreeRunnable -> key.split -> keyArray.length < 7");
							}
							continue;
						}
						
						String methodName = keyArray[1];
						String ip = keyArray[6];
						
						int divisionIndex = methodName.indexOf(".");
						if (divisionIndex == 0) {
							if (logger.isErrorEnabled()) {
								logger.error("BuildTreeRunnable -> methodName.indexOf -> divisionIndex == 0");
							}
							continue;
						}
						
						String serviceName = methodName.substring(0, divisionIndex);
						
						Set<String> ipSet = ipMap.get(serviceName);
						if (ipSet == null) {
							ipSet = new CopyOnWriteArraySet<String>();
							Set<String> ipSetBack = ipMap.putIfAbsent(serviceName, ipSet);
							if (ipSetBack != null) {
								ipSet = ipSetBack;
							}
						}
						ipSet.add(ip);
						
						Set<String> methodSet = methodMap.get(serviceName);
						if (methodSet == null) {
							methodSet = new CopyOnWriteArraySet<String>();
							Set<String> methodSetBack = methodMap.putIfAbsent(serviceName, methodSet);
							if (methodSetBack != null) {
								methodSet = methodSetBack;
							}
						}
						methodSet.add(methodName);
					}
				}
				
				try {
					Thread.sleep(intervalTime);
				} catch (InterruptedException e) {
					if (logger.isErrorEnabled()) {						
						logger.error("HeartBeatAliveTasksScan -> run -> HeartBeatAliveTasksScan InterruptedException, Exception: " + e);
					}
				}
			}
		}
	}
	
	public void setPerformancePersistence(PerformancePersistence performancePersistence) {
		this.performancePersistence = performancePersistence;
	}

	public void setIntervalTime(long intervalTime) {
		this.intervalTime = intervalTime;
	}
}
