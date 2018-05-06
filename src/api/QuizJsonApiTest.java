package api;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Test;


public class QuizJsonApiTest {
	
	@Test(expected = ParseException.class)
    public void testException() throws IOException, ParseException {	
	   QuizJsonApi.streamFile("[{\"test:\"\"done\"]","javascript","overview");  
    }

}
