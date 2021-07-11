package com.hemebiotech.analytics;

import java.util.List;


public interface ISymptomReader {

	
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	public List<String> GetSymptoms() ;
	
	
	/**
	 * @return this method returns the list by number of occurrences per symptom
	 */
	public void valueOfSymptoms() ;
	
	
	/**
	 * this method allows us to create the result.out file 
	 * and write the symptoms and their occurrences in alphabetical order.
	 */
	public void fileResultOut() ;
}
