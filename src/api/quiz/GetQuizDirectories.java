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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import static config.Variables.*;

@Controller
@RequestMapping("/quizdirectories")
public class GetQuizDirectories {

	JSONArray jsonArray;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getDirectories() {
		jsonArray = new JSONArray();

		/* filter out only directories */
		File file = new File(quizfolder);
		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});

		List<String> dirs = Arrays.asList(directories).stream().collect(Collectors.toList()); // collecting as list;

		// add all the directories to the JSONArray Object
		dirs.forEach(val -> jsonArray.add(val));

		return new ResponseEntity<String>(jsonArray.toJSONString(), HttpStatus.OK);
	}
}