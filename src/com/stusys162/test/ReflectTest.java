package com.stusys162.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class ReflectTest {
	@Test
	public void testAdmin() {
		// 反射
		String clsname = "com.stusys162.pojo.Admininfo";
		try {
			Class cls = Class.forName(clsname);
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				String modify = Modifier.toString(field.getModifiers());
				String typename = field.getClass().getName();
				String name = field.getName();
				System.out.println(modify + " " + typename + " " + name);
			}
			Constructor[] constructors = cls.getConstructors();
			for (Constructor constructor : constructors) {
				String modify = Modifier.toString(constructor.getModifiers());
				String name = constructor.getName();
				System.out.println(modify + " void " + name + "(");
				Class[] parameterTypes = constructor.getParameterTypes();
				for (Class ptype : parameterTypes) {
					System.out.println(ptype.getName() + ",");
				}
				System.out.println(")");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testReflect() {
		String clsname = "com.stusys162.pojo.Admininfo";
		try {
			Class cls = Class.forName(clsname);
			Constructor constructor = cls.getConstructor(String.class, String.class, String.class);
			Object admin = constructor.newInstance("zhangsan", "123456", "张三");
			System.out.println(admin);
			Method method = cls.getMethod("setAdminid", int.class);
			method.invoke(admin, 10);
			System.out.println(admin);
			Field field = cls.getDeclaredField("adminid");
			field.setAccessible(true);
			field.setInt(admin, 20);
			System.out.println(admin);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
