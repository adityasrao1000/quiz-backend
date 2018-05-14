package api.quiz;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import static config.Variables.*;

@Controller
@RequestMapping("/getquizsection")
public class GetQuizSection {
		
	JSONArray jsonArray;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{name}",  method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getSections(@PathVariable("name") String name) { 
    	
    	jsonArray =  new JSONArray();
    	
    	try {
	    	File file = new File(quizfolder+"/"+name);
	    	
	    	//retain only JSON file types and filter out directories
	    	String[] directories = file.list(new FilenameFilter() {
	    	  @Override
	    	  public boolean accept(File current, String name) {
	    		String fileName = new File(current, name).getName();
	    	    return new File(current, name).isFile() && fileName.substring(fileName.lastIndexOf(".")+1).equals("json");
	    	  }
	    	});
	    	
	    	//converts the array into list and strip out .json
	    	List<String> dirs = Arrays.asList(directories).stream()
	    			            .map(p -> p = p.substring(0, p.lastIndexOf(".")))
	    			            .filter(p -> !p.equals("menu"))
	    			            .collect(Collectors.toList()); // collecting as list;
	    	
	    	//adds the list content into the JSONArray
	        dirs.forEach(val -> jsonArray.add(val));
	        System.out.println(jsonArray.toJSONString());
    	}catch(Exception e) {
    		System.out.println(e);
    	}
		return new ResponseEntity<String>(jsonArray.toJSONString(), HttpStatus.OK);
	}
    
}
