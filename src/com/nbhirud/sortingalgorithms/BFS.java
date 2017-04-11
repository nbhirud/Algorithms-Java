/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbhirud.sortingalgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nbhirud
 */
//This class implements the BFS Algorithm for undirected graphs 
public class BFS {

    public static void main(String args[]) {
        int[][] adjacencyMatrix = null;

        //Queue is a user defined data structure 
        MyQueue queue = new MyQueue();
        Scanner scan = new Scanner(System.in);

        //Taking input from console. 
        System.out.println("Enter the number of nodes: ");
        int numberOfNodes = scan.nextInt();
        adjacencyMatrix = new int[numberOfNodes + 1][numberOfNodes + 1];

        //Accepting the adjacency matrix 
        System.out.println("Enter the adjecency matrix");
        for (int i = 1; i < numberOfNodes + 1; i++) {
            for (int j = 1; j < numberOfNodes + 1; j++) {
                adjacencyMatrix[i][j] = scan.nextInt();
            }
        }

        System.out.println("Please enter the source node: ");
        int source = scan.nextInt();
        scan.close();

        //Logic for BFS  	 
        int visited[] = new int[numberOfNodes + 1];
        int BFSTree[] = new int[numberOfNodes];    //……………………….. (1)
        queue.add(source);
        visited[source] = 1;
        BFSTree[0] = source;
        int x = 1;
        while (!queue.isEmpty()) {   //………………………….(2)
            int i = queue.remove();
            for (int j = 1; j <= numberOfNodes; j++) {
                if (adjacencyMatrix[i][j] == 1 && visited[j] != 1) {  //………………….(3)
                    visited[j] = 1;
                    BFSTree[x++] = j;
                    queue.add(j);
                    if (x == numberOfNodes) { // It means all nodes are visited        ………..(4)  	 	 	 	 	 	queue= new MyQueue(); // empty queue. 
                    }
                }
            }

        }

        //Printing the BFS result if the graph is complete  	 	
        if (Arrays.toString(BFSTree).indexOf('0') == -1) {
            System.out.println("\nBFS: " + Arrays.toString(BFSTree));
        } else {
            System.out.println("\nThe graph entered is not connected");
            System.out.println("Node " + BFSTree[Arrays.toString(BFSTree).indexOf('0') - 1] + " is disconnected");

        }

    }

}
