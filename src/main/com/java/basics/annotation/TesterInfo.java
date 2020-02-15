package main.com.java.basics.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Heena Hussain
 *
 */
@Target(ElementType.TYPE) // defined for class
@Retention(RetentionPolicy.RUNTIME)
public @interface TesterInfo
{
	String[] tags() default "";
	String createdBy() default "Heena";
	String lastModified() default "02/15/2020";
}
