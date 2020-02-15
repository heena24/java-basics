package main.com.java.basics.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Heena Hussain
 *
 */
@Target(ElementType.FIELD) // defined at field level
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation
{
	String key() default "default";
}
