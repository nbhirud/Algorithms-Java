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
public class MergeSorter {

    int[] data;

    MergeSorter(int[] d) {
        data = d;
    }

    public int[] sort() {
        sorter(0, data.length - 1); // 0 to 15 //16-1
        return data;
    }

    private void sorter(int low, int high) {
        System.out.println("sorter. low = " + low + ", high = " + high);
        if (low == high) {
            return;
        } else { //if(j-i > 1){
            int mid = (low + high) / 2; //7
            sorter(low, mid); // (0, 7)
            sorter(mid + 1, high); //(8, 15)
            merge(low, mid, high); //(0, 7, 15)
        }
    }

    private void merge(int low, int mid, int high) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("sorter. low = " + low + ", mid = " + mid + ", high = " + high);
        int[] n = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        //while (k < (high - low)) {
        while ((i<=mid)&&(j<=high)) {
            //i = 0, j = 8; k = 0
            if ((j <= high) && (data[i] >= data[j])) {
                n[k] = data[j];
                System.out.println("j incremented" + data[j]);
                j++;
                k++;

            } else if (i <= mid) {
                n[k] = data[i];
                System.out.println("i incremented" + data[i]);
                i++;
                k++;
            }
            
        }
        
        
        while (i < mid) {
            n[k] = data[i];
            System.out.println("extra i incremented" + data[i]);
            i++;
            k++;
        }
        while (j < high) {
            n[k] = data[j];
            System.out.println("extra j incremented" + data[j]);
            j++;
            k++;
        }
        System.out.print("Writing to data[] ----------------------- ");
        for (int d = 0; d < (high - low); d++) {
            data[low + d] = n[d];
            System.out.print(n[d]+" ");
        }
        System.out.println();
    }
}
