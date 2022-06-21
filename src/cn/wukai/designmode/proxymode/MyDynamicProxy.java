package cn.wukai.designmode.proxymode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyDynamicProxy {

	public static void main(String[] args) {
		MyHello hello = new MyHello();
		MyInvocationHandle myHandle = new MyInvocationHandle(hello);
		
		Hello proxyHello = (Hello) Proxy.newProxyInstance(MyHello.class.getClassLoader(), MyHello.class.getInterfaces(), myHandle);
		
		proxyHello.sayHello();
	}
	
}

interface Hello{
	void sayHello();
}

class MyHello implements Hello{

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("hello everyone, my name is 5k");
	}
	
}

class MyInvocationHandle implements InvocationHandler{

	Object target;
	
	public MyInvocationHandle(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("invocation hello");
		Object result = method.invoke(target, args);
		return result;
	}
	
}
