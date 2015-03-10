package org.fl.noodlemonitor.client.util;

import java.lang.reflect.Method;

public final class NetServiceTools {
	
	public static String getInvokerKey(Method method) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(method.getDeclaringClass().getName());
		stringBuilder.append(".");
		stringBuilder.append(method.getName());
		
		stringBuilder.append("(");
		
		Class<?>[] parameters = method.getParameterTypes();
		
		int i = 0;
		for (Class<?> parameter : parameters) {
			stringBuilder.append(parameter.getSimpleName());
			if (++i < parameters.length) {
				stringBuilder.append(",");
			}
		}
		stringBuilder.append(")");
		
		return stringBuilder.toString();
	}
}
