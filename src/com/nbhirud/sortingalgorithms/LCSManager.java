package com.nbhirud.sortingalgorithms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nbhirud
 */
//Main Class which invokes the LCS memorized method and prints result. 
public class LCSManager {  
 
 	public static void main(String[] args) { 
 	 	LCS newLCS = new LCS(args[0], args[1]); 
 	 	//LCS newLCS = new LCS("spanking","amputation"); 
 	 	newLCS.memoized_lcs(); 
 	 	 
 	 	System.out.println("The Length of LCS is: "+newLCS.getLCSLength()); 
 	 	System.out.println("The LCS string is: "+newLCS.getlcsString()); 
 	 	System.out.println("Below is the LCS matrix: ");  	 	newLCS.printMatrix(); 
 	} 
 
} 
