package test;

import java.lang.reflect.Method;

public class TestReflect{

	public static void main(String[] args)throws Exception{
		Class<?> clz = Class.forName("test.Person");
		Object o = clz.newInstance();
		Method m = clz.getMethod("say", String.class);
		for (int i = 0; i < 16; i++) {
			m.invoke(o, i+"");
		}
	}
}
