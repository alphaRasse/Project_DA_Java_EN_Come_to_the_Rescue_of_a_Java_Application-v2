package com.hemebiotech.analytics;


public class AnalyticsCounter {

		
		
		public static void main(String args[]){
			
			ReadSymptomDataFromFile rsdff =new ReadSymptomDataFromFile("symptoms.txt");
			rsdff.GetSymptoms();
			rsdff.valueOfSymptoms();
			rsdff.fileResultOut();
		}
}
