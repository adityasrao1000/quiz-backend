package api.quiz;

import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/getquiz")
public class GetQuiz {
		
	final static String location = "D:\\javascript\\quiz";
	JSONArray jsonArray;
	
	@RequestMapping(value = "/{category}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getDirectories(@PathVariable("category") String category, @PathVariable("name") String name) {  
    	jsonArray = new JSONArray();
    	
		return new ResponseEntity<String>("", HttpStatus.OK);				
	}
}