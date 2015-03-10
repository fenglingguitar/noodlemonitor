package org.fl.noodlemonitor.client.interceptor;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.fl.noodle.common.connect.expand.monitor.PerformanceMonitor;
import org.fl.noodle.common.connect.expand.monitor.constent.ModuleType;
import org.fl.noodle.common.connect.expand.monitor.constent.MonitorType;
import org.fl.noodlemonitor.client.util.NetServiceTools;

public class MonitorInterceptor implements MethodInterceptor {
	
	private PerformanceMonitor performanceMonitor;
	private String hostIp;
	
	public MonitorInterceptor() throws UnknownHostException {
		this.hostIp = InetAddress.getLocalHost().getHostAddress();
	}
	
    public Object invoke(MethodInvocation invocation) throws Throwable {
        
    	String invokerKey = NetServiceTools.getInvokerKey(invocation.getMethod());
    	
    	performanceMonitor.before(invokerKey, MonitorType.CONNECT.getCode(), ModuleType.SERVER.getCode(), 1);
    	
        try {
        	return invocation.proceed();
        } catch(Throwable e) {        	
            performanceMonitor.after("", invokerKey, MonitorType.CONNECT.getCode(), ModuleType.SERVER.getCode(), 1, 200, false);
        } finally {
            performanceMonitor.after("", invokerKey, MonitorType.CONNECT.getCode(), ModuleType.SERVER.getCode(), 1, 200, true);
        }
		return null;        
    }

	public void setPerformanceMonitor(PerformanceMonitor performanceMonitor) {
		this.performanceMonitor = performanceMonitor;
	}
}
