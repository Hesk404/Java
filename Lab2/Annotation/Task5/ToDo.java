package Lab2.Annotation.Task5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface ToDo
{
	String message();
}