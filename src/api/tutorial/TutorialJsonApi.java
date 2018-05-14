package api.tutorial;

import java.io.FileOutputStream;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import static config.Variables.*;

@Controller
@RequestMapping("/tutorial")
public class TutorialJsonApi {
		

    @RequestMapping(value = "/{tutorial}/{section}",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> findOne(@PathVariable("tutorial") String tutorial,@PathVariable("section") String section, @RequestBody String json) {  
    	
    	try{    
            streamFile(json,tutorial,section);
        }
    	catch(ParseException e){
    		System.out.println(e);
    		return new ResponseEntity<String>("malformed json", HttpStatus.NOT_ACCEPTABLE);
    	}
    	catch(IOException e){
    		System.out.println(e);
    		return new ResponseEntity<String>("failure", HttpStatus.INTERNAL_SERVER_ERROR);
    	}  
    	catch(Exception e){
    		System.out.println(e);
    		return new ResponseEntity<String>("failure", HttpStatus.INTERNAL_SERVER_ERROR);
    	}   
		return new ResponseEntity<String>("success", HttpStatus.OK);				
	}
    
    public static void streamFile(String json, String tutorial, String section) throws IOException, ParseException {
    	
    	JSONParser parser = new JSONParser();
    	JSONArray json1 = (JSONArray) parser.parse(json);
        FileOutputStream fout=new FileOutputStream(basefolder+"\\"+tutorial+"\\"+section+".json");  
        fout.write(json1.toString().getBytes());  
        
        //close resource stream
        if(fout!=null) {
          fout.close(); 
        }         
    }
}