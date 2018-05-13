package tests;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import api.tutorial.QuizJsonApi;


public class QuizJsonApiTest {
	
	
	@Test(expected = ParseException.class)
    public void testException() throws IOException, ParseException {	
	   QuizJsonApi.streamFile("[{\"test:\"\"done\"]","javascript","overview");  
    }
}