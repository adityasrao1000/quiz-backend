package api.quiz;

import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import static config.Variables.*;

import java.io.FileInputStream;

@Controller
@RequestMapping("/getquiz")
public class GetQuiz {
		
	
	JSONArray jsonArray;

	@RequestMapping(value = "/{tutorial}/{section}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getDirectories(@PathVariable("tutorial") String tutorial, @PathVariable("section") String section) {  
    	
		jsonArray = new JSONArray();
    	StringBuffer file= new StringBuffer("");

    	try {
	    	FileInputStream fin=new FileInputStream(quizfolder+"/"+tutorial+"/"+section+".json");    
	    	int i=0;    
            while((i=fin.read())!=-1){    
             file.append((char)i);    
            }    
            fin.close();
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	System.out.println("quiz");
		return new ResponseEntity<String>(file.toString(), HttpStatus.OK);				
	}
}