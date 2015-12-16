package org.fl.noodlemonitor.client.interceptor;

import java.net.UnknownHostException;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.fl.noodle.common.connect.expand.monitor.PerformanceMonitor;
import org.fl.noodle.common.connect.expand.monitor.constent.ModuleType;
import org.fl.noodle.common.connect.expand.monitor.constent.MonitorType;
import org.fl.noodle.common.util.net.NetAddressUtil;
import org.fl.noodlemonitor.client.util.NetServiceTools;

public class MonitorInterceptor implements MethodInterceptor {
	
	private PerformanceMonitor performanceMonitor;
	private String hostIp;
	private long threshold = 200;
	
	public MonitorInterceptor() throws UnknownHostException {
		this.hostIp = NetAddressUtil.getLocalIp();
	}
	
    public Object invoke(MethodInvocation invocation) throws Throwable {
        
    	String invokerKey = NetServiceTools.getInvokerKey(invocation.getMethod());
    	
    	performanceMonitor.before(invokerKey, MonitorType.CONNECT.getCode(), ModuleType.SERVER.getCode(), hostIp);
    	
    	Object result = null;
    	
        try {
        	result = invocation.proceed();
        } catch(Throwable e) {        	
            performanceMonitor.after("", invokerKey, MonitorType.CONNECT.getCode(), ModuleType.SERVER.getCode(), hostIp, threshold, false);
            throw e;
        } 
        
        performanceMonitor.after("", invokerKey, MonitorType.CONNECT.getCode(), ModuleType.SERVER.getCode(), hostIp, threshold, true);

        return result;        
    }

	public void setPerformanceMonitor(PerformanceMonitor performanceMonitor) {
		this.performanceMonitor = performanceMonitor;
	}
	
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public void setThreshold(long threshold) {
		this.threshold = threshold;
	}
}
