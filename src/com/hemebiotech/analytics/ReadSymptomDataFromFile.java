package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadSymptomDataFromFile implements ISymptomReader {
	
	private String filepath;
	List<Integer> occurrences = new ArrayList<Integer>();
	List<String> symptoms = new ArrayList<String>();
	Map<String,Integer> result1 = new TreeMap<String,Integer>();
	
	ArrayList<String> result = new ArrayList<String>();
	
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
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
	


	@Override
	public void valueOfSymptoms() {

		for(String s : result) {
			if (symptoms.contains(s))
			{
				int n = symptoms.indexOf(s);
                
				occurrences.set(n, occurrences.get(n)+1);				
			}
			else
			{
				symptoms.add(s);
				occurrences.add(1);
			}
		}
		
		for(int i = 0; i < symptoms.size(); i++)
		{
 
		result1.put(symptoms.get(i) ,occurrences.get(i));
		   
	}
		}

	@Override
	public void fileResultOut() {
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("result1.out"));
			
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
