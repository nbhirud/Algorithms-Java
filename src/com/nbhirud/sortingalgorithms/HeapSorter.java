package com.nbhirud.sortingalgorithms;


public class HeapSorter implements Sort {
	private int[] A;
	
	//Constructor
	public HeapSorter(int[] a) {
		//this.A = a;
		A=new int[a.length+1];
		//System.out.println("Length of A: "+A.length);
		A[0] = 0;
		for (int i = 1; i<= a.length; i++) {
			A[i] = a[i-1];
		}
	}
	
	
	@Override
	public void sorter() {
		Heapsort();
		//build_max_heap(A.length - 1);
		

	}

	


	@Override
	public void printData() {
		for(int i=1; i < A.length; i++) {
			System.out.println(A[i]);
		}		
	}
	
	public int getLength() {
		return A.length;
	}
	
	private void Heapsort() {
		int len = A.length -1;
		build_max_heap(len);
		int temp;
		for (int i=len; i>1; i--) {
			//exchange A[1} and A[i}
			temp = A[1];
			A[1]= A[i];
			A[i]= temp;
			max_heapify(1, i-1);
		}
		
	}
	
	public void build_max_heap(int len) {
		//int len = A.length - 1;
		for (int i = len/2; i >= 1; i--) {
			max_heapify(i, len);
			
		}
	}

	private void max_heapify(int i, int n) {
		int l = 2*i;
		int r = 2*i+1;
		int largest, temp = -1;
		if ((l<=n) && (A[l] > A[i])) {
			largest = l;
		}
		else {
			largest = i;
		}
		
		if ((r <= n) && (A[r] > A[largest])) {
			largest = r;
		}
		
		if (largest != i) {
			//swap A[i] and A[largest]
			temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;			
			max_heapify(largest, n);
		}
		
	}
	
}
