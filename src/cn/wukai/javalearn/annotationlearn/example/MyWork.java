package cn.wukai.javalearn.annotationlearn.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyWork {

	public static void main(String[] args) throws Exception{
		Class<UserAnnotation> clazz = UserAnnotation.class;
		Object obj = clazz.getDeclaredConstructor().newInstance();
		List<Method> beforeList = new ArrayList<Method>();
		List<Method> coreList = new ArrayList<Method>();
		List<Method> afterList = new ArrayList<Method>();
		
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(Before.class)) {
				beforeList.add(method);
			}
			
			if(method.isAnnotationPresent(MyCore.class)) {
				coreList.add(method);
			}
			
			if(method.isAnnotationPresent(After.class)) {
				afterList.add(method);
			}
			
		}
		
		for (Method method : coreList) {
			for (Method before : beforeList) {
				before.invoke(obj);
			}
			
			method.invoke(obj);
			
			for (Method after : afterList) {
				after.invoke(obj);
			}
		}
		//Object obj1 = clazz.
	}
	
}
