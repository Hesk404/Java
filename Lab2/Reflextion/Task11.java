package Lab2.Reflextion;

import java.lang.reflect.Field;

public class Task11
{
	public static void main(String[] args) throws Exception
	{
		Class<?> cl = Class.forName("java.lang.System");
		Field f = cl.getDeclaredField("out");
		f.getType().getMethod("println", String.class).invoke(f.get(null), "Hello world!");
	}
}