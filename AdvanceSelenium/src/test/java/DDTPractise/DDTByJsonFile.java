package DDTPractise;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTByJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader file = new FileReader("C:\\Users\\prash\\eclipse-workspace\\AdvanceSelenium\\src\\test\\resources\\JsonData.json");
		Object javaObj = parser.parse(file);
		
		JSONObject obj= (JSONObject)javaObj;
		String name = obj.get("name").toString();
		String id = obj.get("id").toString(); // we are converting to toString coz wen we use for sendKeys(), 
		//it accepts only string.
		Object id1 = obj.get("id");
		String branch = obj.get("Branch").toString();
		String age = obj.get("Age").toString();
		String isStudent = obj.get("isStudent").toString();
		Object isStudent1 = obj.get("isStudent");
		Object backlogs = obj.get("backlogs"); // null we can't convert to string
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(id1);
		System.out.println(branch);
		System.out.println(age);
		System.out.println(isStudent);
		System.out.println(isStudent1);
		System.out.println(backlogs);
		

	}

}
