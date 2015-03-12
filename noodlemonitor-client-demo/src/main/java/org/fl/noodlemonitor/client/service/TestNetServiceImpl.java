package org.fl.noodlemonitor.client.service;

import java.util.Random;

public class TestNetServiceImpl implements TestNetService {

	@Override
	public TestObject sendObject(TestObject testObject) throws Exception {
		System.out.println("sendObject...");
		Thread.sleep((new Random()).nextInt(1000));
		return testObject;
	}
}
