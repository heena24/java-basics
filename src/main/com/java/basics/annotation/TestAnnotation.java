package main.com.java.basics.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Heena Hussain
 *
 */
@Target(ElementType.METHOD) // can be used on Method only
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation
{
	public boolean enabled() default true;
}
