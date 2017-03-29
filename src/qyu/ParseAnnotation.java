package qyu;

import java.lang.reflect.Method;

class ParseAnnotation {
	public static void main(String[] args) {
		System.out.println("hahah");
		try {
			Class c = Class.forName("qyu.Test");
			System.out.println(c.isAnnotationPresent(Fuck.class));
			
//			boolean isExist = c.isAnnotationPresent(Description.class);
			Method md = c.getMethod("eyeColor", null);
			boolean isExist = md.isAnnotationPresent(Description.class);
			if (isExist) {
				Description d = (Description) md.getAnnotation(Description.class);
				System.out.println("desc = " + d.desc());
				System.out.println("author = " + d.author());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
