package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

public class CSVReaderUtility {


 	public static Iterator<User> readCSVFile(String fileName) {
 		File csvFile = new File(System.getProperty("user.dir")+ "\\testData\\" + fileName);
 		CSVReader csvReader = null;
 		FileReader fileReader = null;
 		String[] line;
 		List<User> userList = null;
		User user = null;

		try {
		fileReader = new FileReader(csvFile);
		csvReader = new CSVReader(fileReader);
		csvReader.readNext();
		
		userList = new ArrayList<User>();
		while((line = csvReader.readNext()) != null) {
			 user = new User(line[0], line[1]);
			 userList.add(user);
		 }
		
		
		}catch(CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
