package org.fl.noodlemonitor.client;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Random;

import org.aopalliance.intercept.MethodInvocation;
import org.fl.noodlemonitor.client.interceptor.MonitorInterceptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {
		"classpath:org/fl/noodlemonitor/client/interceptor/noodlemonitor-client-interceptor.xml"
})
public class MonitorInterceptorTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	MonitorInterceptor monitorInterceptor;
	
	@Test
	public void testMonitorInterceptor() throws Throwable {
		
		Random random = new Random();
		
		for (int i=0; i<10; i++) {
			invoke();
			Thread.sleep(random.nextInt(3000));
		}
	}
	
	private void invoke() throws Throwable {
		
		monitorInterceptor.invoke(new MethodInvocation() {

			@Override
			public Object[] getArguments() {
				return null;
			}

			@Override
			public Object proceed() throws Throwable {
				return null;
			}

			@Override
			public Object getThis() {
				return null;
			}

			@Override
			public AccessibleObject getStaticPart() {
				return null;
			}

			@Override
			public Method getMethod() {
				return Random.class.getMethods()[0];
		}});
	}
}
