package org.fl.noodlemonitor.client.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MonitorInterceptor implements MethodInterceptor {
	
    public Object invoke(MethodInvocation invocation) throws Throwable {
        
        try {
        	return invocation.proceed();
        } finally {
        }
    }
}
