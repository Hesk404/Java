package Lab2.Reflextion;

import java.lang.reflect.Field;
import java.util.StringJoiner;

public class Task9{
	public static void main(String [] args) throws Exception
	{
		System.out.println(toString(new Person("TEST", 23)));
	}
	
	public static String toString(Object o) throws Exception{
		Class<?> cl = o.getClass();
		StringJoiner joiner = new StringJoiner(",", cl.getName() + "{", "}");
		for(Field field : cl.getDeclaredFields())
		{
			field.setAccessible(true);
			joiner.add(field.getName() + "=" + field.get(o).toString());
		}
		return joiner.toString();
	}
}