package org.fl.noodlemonitor.client.demo;

import org.fl.noodlemonitor.client.service.TestNetService;
import org.fl.noodlemonitor.client.service.TestObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientDemo {

public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext applicationContext
				= new ClassPathXmlApplicationContext(
						"classpath:org/fl/noodlemonitor/client/demo/noodlemonitor-client-demo.xml");
		
		TestNetService testNetService = (TestNetService) applicationContext.getBean("testNetService");
		
		for (int i=0; i<1000; i++) {			
			testNetService.sendObject(TestObject.getInstence());
		}

		applicationContext.destroy();
    }
}
