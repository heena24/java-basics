package main.com.java.basics.annotation;
/**
 * @author Heena Hussain
 *
 */
@TesterInfo(createdBy="IntelliJ", tags={"example"})
public class TestExample
{
	@FieldAnnotation
	private String key = "x";

	@TestAnnotation
	public void testFailCase()
	{
		throw new RuntimeException("Failed testcase");
	}

	@TestAnnotation(enabled=false)
	public void testIgnoredCase()
	{
		System.out.println("Ignored testcase");
	}

	@TestAnnotation
	public void testPassedCase()
	{
		System.out.println("Passed testcase : " + key);
	}
}
