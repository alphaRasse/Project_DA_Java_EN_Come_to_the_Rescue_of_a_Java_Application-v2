package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class ReadSymptomDataFromFile implements ISymptomReader {
	
	private String filepath;
	Map<Integer,String> result = new TreeMap<Integer,String>();
	Map<String,Integer> result1 = new TreeMap<String,Integer>();
	
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public Map<Integer, String> GetSymptoms0() {
		if(filepath!= null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
			Integer x =0;
				while(line!=null) {
					result.put(x, line);
					line=reader.readLine();
					x++;
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
		for(String res : result.values())
		{			Integer y = 0;
			for(String res1 : result.values())
			{
				if(res1.contentEquals(res)) {
					y++;
				}
			}
			result1.put(res,y);
		}
		
	}

	@Override
	public void fileResultOut() {
		try{
			PrintWriter writer = new PrintWriter(new FileWriter("result.out"));
			
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
