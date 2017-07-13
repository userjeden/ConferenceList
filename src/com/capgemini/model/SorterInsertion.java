package com.capgemini.model;

import java.util.List;

public class SorterInsertion {
	
	/**
	 * A type-of insertion sort algorithm. 
	 * The time complexity: worst case O(n*n) / best case O(n)
	 * Hence implemented with LinkedList, the time complexity is slightly reduced 
	 * as compared to ArrayList, while the elements are moved to their position 
	 * directly, not through a chain of swaps which is typical for ArrayList.
	 * 
	 * Collections.sort uses MergeSort
	 * Arrays.sort uses QuickSort/MergeSort ?
	 */
	public void sortByNames(List<Person> persons){
		
		int listSize = persons.size();
		for(int readIndex = 1; readIndex < listSize; readIndex++){
			
			int flag = 0;
			int insertionIndex = readIndex;
			String name = persons.get(readIndex).getFirstName();
			while((insertionIndex > 0) 
					&& (name.compareTo(persons.get(insertionIndex-1).getFirstName()) <= 0)){
				insertionIndex--;
				flag = 1;
			}
			
			if(flag == 1){
				persons.add(insertionIndex, persons.remove(readIndex));
			}
			
		}
	}

}
