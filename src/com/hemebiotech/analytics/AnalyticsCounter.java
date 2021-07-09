package com.hemebiotech.analytics;


public class AnalyticsCounter {

		
		
		public static void main(String args[]){
			
			ReadSymptomDataFromFile rsdff =new ReadSymptomDataFromFile("symptoms.txt");
			rsdff.GetSymptoms0();
			rsdff.valueOfSymptoms();
			rsdff.fileResultOut();
		}
}
