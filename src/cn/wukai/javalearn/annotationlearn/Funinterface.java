package cn.wukai.javalearn.annotationlearn;

@FunctionalInterface
public interface Funinterface {

	static void foo() {
		System.out.println("foo");
	}
	
	default void bar() {
		System.out.println("bar");
	}
	
	default void hook() {
		System.out.println("hook");
	}
	
	void test();
	
}
