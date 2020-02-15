package main.com.java.basics.annotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
/**
 * @author Heena Hussain
 * Example to read the annotation
 */
public class RunTest
{
	public static void main(String[] args)
	{
		Class testExampleClass = TestExample.class;

		Annotation[] annotations = testExampleClass.getAnnotations();

		TesterInfo testerInfo = null;

		for(Annotation annotation : annotations)
		{
			if(annotation instanceof TesterInfo)
			{
				testerInfo = (TesterInfo) annotation;
				break;
			}
		}

		if(testerInfo != null)
		{
			System.out.println("createdBy : " + testerInfo.createdBy());
			System.out.println("tags : " + Arrays.toString(testerInfo.tags()));
			System.out.println("lastModified: " + testerInfo.lastModified());
		}

		Method[] methods = testExampleClass.getDeclaredMethods(); //Provide only direct annotations
		for(Method method : methods)
		{
			if(method.isAnnotationPresent(TestAnnotation.class))
			{
				TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
				if(testAnnotation.enabled())
				{
					try
					{
						method.invoke(testExampleClass.newInstance());
						System.out.println("Executing test: " + method.getName());
					} catch(Exception ex)
					{
						System.out.println("Failed test: " + method.getName());
					}
				} else
				{
					System.out.println("Ignored test: " + method.getName());
				}
			}
		}

		Field[] fields = testExampleClass.getDeclaredFields(); // to get all fields defined in this calls only - excludes base class fields
		for(Field field : fields)
		{
			Annotation[] fieldAnnotations  = field.getAnnotations(); // Provided all annotations
			for(Annotation annotation : fieldAnnotations)
			{
				if( annotation instanceof FieldAnnotation)
				{
					System.out.println("Field annotation " + field.getName() + " : " + ((FieldAnnotation) annotation).key());
				}
			}
		}

	}
}
