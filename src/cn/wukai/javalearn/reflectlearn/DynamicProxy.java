package cn.wukai.javalearn.reflectlearn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	public static void main(String[] args) {
		
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println(method);
				if(method.getName().equals("say")) {
					System.out.println("GOOD MORNING " + args[0]);
				}
				return null;
			}
		};
		
		Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
				new Class[] { Hello.class }, handler);
		hello.say("wukai");
		
		
		
		Hello he = new Hello() {
			
			@Override
			public void say(String name) {
				// TODO Auto-generated method stub
				System.out.println(name);
			}
		};
		
		he.say("xxxx");
	}
	
}

