package tests;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import api.tutorial.TutorialJsonApi;


public class TutorialJsonApiTest {
	
	
	@Test(expected = ParseException.class)
    public void testException() throws IOException, ParseException {	
	   TutorialJsonApi.streamFile("[{\"test:\"\"done\"]","javascript","overview");  
    }
}