package main.com.java.basics.stream;
import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.google.common.io.CharStreams;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
/**
 * @author Heena Hussain
 *
 */
public class ConvertInputStreamToString
{
	public static void main(String[] args) throws IOException
	{
		// CONVERTING WITH GUAVA
		String originalString = randomAlphabetic(8);
		InputStream inputStream = new ByteArrayInputStream(originalString.getBytes());

//		ByteSource source = new ByteSource()
//		{
//			@Override public InputStream openStream() throws IOException
//			{
//				return inputStream;
//			}
//		};
//
//		String output = source.asCharSource(Charsets.UTF_8).read();
//		System.out.println(originalString + " + " + output);

		//Closing the stream
		String text = null;
		try(final Reader reader = new InputStreamReader(inputStream))
		{
			text = CharStreams.toString(reader);
		}

		System.out.println("String: " + text);

		// USING JAVA
		InputStream javaInputStream = new ByteArrayInputStream(originalString.getBytes());
		StringBuilder builder = new StringBuilder();

		try(Reader reader = new InputStreamReader(javaInputStream))
		{
			int c =0;
			while((c = reader.read()) != -1)
			{
				builder.append((char)c);
			}
		}

		System.out.println("builder: " +builder.toString());
	}
}
