package cn.wukai.javalearn.reflectlearn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<Person> clazz = Person.class;
		Method method = clazz.getMethod("say");
		method.invoke(new Student());
		
		Class<Student> stu = Student.class;
		Method m = stu.getMethod("getSum", int.class,String.class);
		Method score = stu.getDeclaredMethod("getScore", int.class);
		m.invoke(new Student(), 2,"student");
		score.setAccessible(true);
		score.invoke(new Student(), 20);
	}
	
}

class Person{
	
	
	public void say() {
		System.out.println("Person say");
	}
	
}

class Student extends Person{
	
	private int getScore(int score) {
		System.out.println(score);
		return score;
	}
	
	public void getSum(int sum,String s) {
		System.out.println(s);
		System.out.println("----");
		System.out.println("sum = " + sum);
	}
	
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("Student say");
	}
	
}
