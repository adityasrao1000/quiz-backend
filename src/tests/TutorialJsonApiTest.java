package tests;

import static config.Variables.basefolder;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Test;

import api.tutorial.TutorialJsonApi;


public class TutorialJsonApiTest {
	
	
    public File res = new File(basefolder+"\\"+"javascript"+"\\"+"overview"+".json");
    boolean exists = res.exists();
    
	@Test(expected = ParseException.class)
    public void testException() throws IOException, ParseException {	
	   TutorialJsonApi.streamFile("[{\"test:\"\"done\"]","javascript","overview");  
    }
	@Test
    public void success() throws IOException, ParseException {	
	   TutorialJsonApi.streamFile("[{\"code:\"\"fun() {}\"}]","javascript","test");  
    }
    @Test
    public void isFile()
    {
    	assertTrue(res.isFile());
    }
    
    @Test
    public void fileExists()
    {
    	assertTrue(exists);
    }
    @After 
    public void close() {
    	res = null;
    }
}