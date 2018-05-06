package api;

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

@Controller
@RequestMapping("/gettutorial")
public class GetTutorialSection {
		

    @RequestMapping(value = "/{name}/{section}",  method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> findOne(@PathVariable("param") String id, @RequestBody String json) {  
    	try{    
            getFile(json,id);
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
    
    public static void getFile(String json, String id) throws IOException, ParseException {
    	
    	JSONParser parser = new JSONParser();
    	JSONArray json1 = (JSONArray) parser.parse(json);
        FileOutputStream fout=new FileOutputStream("D:\\"+id+"\\test.json");  
        fout.write(json1.toString().getBytes());  
        if(fout!=null) {
          fout.close(); 
        }
        System.out.println("success...");    
       
    }
}
