package api.tutorial;

import java.io.FileInputStream;
import java.util.StringJoiner;

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
@RequestMapping("/gettutorial")
public class GetTutorial {

	// declare objects and variables
	JSONArray jsonArray;
	StringJoiner resourceUrl;

	@RequestMapping(value = "/{tutorial}/{section}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getDirectories(@PathVariable("tutorial") String tutorial,
			@PathVariable("section") String section) {

		// initialize objects and variables
		jsonArray = new JSONArray();
		StringBuffer file = new StringBuffer("");
		resourceUrl = new StringJoiner("\\");

		resourceUrl.add(basefolder);
		resourceUrl.add(tutorial);
		resourceUrl.add(section + ".json");
		try (FileInputStream fin = new FileInputStream(resourceUrl.toString())) {
			int i = 0;
			while ((i = fin.read()) != -1) {
				file.append((char) i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>(file.toString(), HttpStatus.OK);
	}
}