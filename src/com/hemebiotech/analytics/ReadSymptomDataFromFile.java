package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadSymptomDataFromFile implements ISymptomReader {
	
	private String filepath;
	ArrayList<String> result = new ArrayList<String>();
	Map<String,Integer> result1= new TreeMap<String,Integer>();
	
	
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * the Getsymptoms() method allows the program to read external files and save them in an ArrayList
	 */
	@Override
	public List<String> GetSymptoms() {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				
				
			} catch (FileNotFoundException e) {
				
				System.err.printf("the %s file does not exist!",filepath);
			} catch(IOException e) {
				System.out.println("a problem occurred when the tomporary drive was closed");
			}
			 
								}	
		return result;
	}
	


	/**
	 * valueofsymptoms() allows the program to count the number of times n symptom is repeated
	 */
	@Override
	public void valueOfSymptoms() {

		for(String s : result) {
			result1.put(s, Collections.frequency(result, s));
		}
		}

	
	/**
	 * The fileResultOut() method allows the program to create and write a file named result.out
	 */
	@Override
	public void fileResultOut() {
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("result2.out"));
			
			for(Map.Entry<String, Integer> m : result1.entrySet()) {
				if(m.getKey() != null) {
					String symptom = m.getKey();
					int value = m.getValue();
						writer.println(symptom+" = "+value);
				}
			}
		       	writer.close();
		}catch(IOException e) {
			System.out.println("a problem occurred when closing PrintWriter");
			}
		
		
	}

}
