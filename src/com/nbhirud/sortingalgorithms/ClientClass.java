package com.nbhirud.sortingalgorithms;


import java.util.Random;


public class ClientClass {
	public static void main(String[] args) {
		
		//int[] a = {48, 80,19,87,94,60,3,84,29,10};
		
		final int LEN = 10;
		Random randomGenerator = new Random();
		int[] a = new int[LEN];
		for (int i = 0; i < a.length; ++i){
		      a[i] = randomGenerator.nextInt(100);
		}
		
		System.out.println("Array Length:"+a.length);
		System.out.println("Original Array:");
		for (int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
		
		//int[] A = {2,6,3,8,4,2,7,9,5,3,45,67,232,4,546,5,12,2,534,3,6,56,345,234,43,3634,5,235};
		//build_max_heap(A, A.length);
		
		Sort s = new HeapSorter(a);
		//System.out.println("Before Sort");
		//s.printData();
		s.sorter();
		System.out.println("After sort");
		s.printData();
		
	}

	

}
