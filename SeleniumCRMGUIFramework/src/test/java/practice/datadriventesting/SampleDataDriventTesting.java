package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDriventTesting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//step 1: get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\s\\Desktop\\Commondata.properties");
		
		
		//step 2: using Properties class , load all the keys
		Properties pObj =new Properties();
		pObj.load(fis);
		
		//step 3: get the value based on key
		System.out.println(pObj.getProperty("browser"));

	}

}
