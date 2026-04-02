package practice.datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws Throwable, IOException, ParseException {
		
		//step1:parse JSon Physical file in to Java Object using JSonParse Class

		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("C:\\Users\\s\\Desktop\\data\\appCommanData.json"));
		
		//step2:Convert java object in to JSonObject using down casting
		JSONObject map=(JSONObject)obj;
		
		//step3:get the data from the json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
		
	}

}
