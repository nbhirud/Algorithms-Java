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
//Data: 
public class MergeSort {

    public static void main(String[] args) {
        //int[] data = {2,5,3,8,2,7,4,0,1,4,5,2,4,5,7,3};
        int[] data = {1, 3, 2, 5, 4, 9, 8, 7, 6, 10};
        MergeSorter m = new MergeSorter(data);
        int[] out = m.sort();
        for (int i : out) {
            System.out.print(i + " ");
        }
    }
}
