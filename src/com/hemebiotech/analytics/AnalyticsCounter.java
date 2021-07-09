package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {

	
		private static int headacheCount = 0;	
		private static int rashCount = 0;		
		private static int pupilCount = 0;		
		
		public static void main(String args[]){
			try {
			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			String line = reader.readLine();

			int i = 0;	
			
			while (line != null) {
				i++;	
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headacheCount++;
					System.out.println("number of headaches: " + headacheCount);
				}
				else if (line.equals("rash")) {
					rashCount++;
				}
				else if (line.contains("pupils")) {
					pupilCount++;
				}

				line = reader.readLine();
				
				
			}reader.close();
			}catch (FileNotFoundException e) {
				
				System.err.printf(" file not found !");
			} catch(IOException e) {
				System.out.println("a problem occurred when the tomporary drive was closed");
			}
			try {
			FileWriter writer = new FileWriter ("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		}catch(IOException e) {
			System.out.println("a problem occurred when closing PrintWriter");
		}
		}

}
