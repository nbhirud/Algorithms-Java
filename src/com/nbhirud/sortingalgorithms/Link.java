/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbhirud.sortingalgorithms;

/**
 *
 * @author nbhirud
 */
//Class Link is used as a base structure for Queue 
//       _____________________           _____________________  
//      |         |           |         |         |           |      
//      |   data  |    next   |-------->|   data  |    next   | 
//      |_________|___________|         |_________|___________| 
class Link { 
 	 
 	int data; 
 	Link next; 
 	 
 	public Link(int data) { 
 	 	this.next = null;  	 	this.data = data; 
 	 	 	 	 
 	} 
 
}
