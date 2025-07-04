package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;

import java.util.*;

import org.testng.annotations.DataProvider;
public class LoginDataProvider {
 
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir") + "\\testData\\loginData.json");
		FileReader fileReader = null;
		TestData testData = null;
		try {
			fileReader = new FileReader(file);
			testData = gson.fromJson(fileReader, TestData.class);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(User user: testData.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
 
}
