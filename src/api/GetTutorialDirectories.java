package api;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/directories")
public class GetTutorialDirectories {
		
	final static String location = "D:\\javascript";
	JSONArray jsonArray;
	
    @SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getDirectories() {  
    	
    	jsonArray =  new JSONArray();
    	try {
	    	File file = new File(location);
	    	String[] directories = file.list(new FilenameFilter() {
	    	  @Override
	    	  public boolean accept(File current, String name) {
	    	    return new File(current, name).isDirectory();
	    	  }
	    	});
	    	
	    	List<String> dirs = Arrays.asList(directories);
	        dirs.forEach(val -> jsonArray.add(val));
	        System.out.println(jsonArray.toJSONString());
    	}catch(Exception e) {
    		System.out.println(e);
    	}
		return new ResponseEntity<String>(jsonArray.toJSONString(), HttpStatus.OK);				
	}
}