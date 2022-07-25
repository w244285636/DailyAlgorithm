package cn.wukai.javalearn.annotationlearn.example;

public class UserAnnotation {

	@Before
	public void init() {
		System.out.println("this is before method");
	}
	
	@Before
	public void log() {
		System.out.println("before core we will print log");
	}
	
	@MyCore
	public void core() {
		System.out.println("this is my core method");
	}
	
	@After
	public void end() {
		System.out.println("after core we will end method");
	}
	
	@After
	public void destory() {
		System.out.println("this is my after method");
	}
}
