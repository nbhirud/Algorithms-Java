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
//LCS class which implements the LCS memorized algorithm 
public class LCS {  

    private String s1 = new String();
    private String s2 = new String();
    private int[][][] c;
    private int len1;
    private int len2;
    private int lcslength = 0;
    private String lcsString = "";

    public LCS(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.len1 = s1.length();
        this.len2 = s2.length();
        this.c = new int[len1 + 1][len2 + 1][2];
        //this.b = new int[l1][l2]; 
    }

    public int[][][] getMatrix() {
        return c;
    }

    public void printMatrix() {
        System.out.println("c[][][0]");
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(c[i][j][0]);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("c[][][1]");
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(c[i][j][1]);
            }
            System.out.println("");
        }
    }

    public void memoized_lcs() {
        for (int i = 0; i <= len1; i++) {                //                  ……………………………(1) 
            for (int j = 0; j <= len2; j++) {
                c[i][j][0] = 0;
                c[i][j][1] = 3;
                //System.out.println("memoized_lcs"+i+", "+j); 
                if ((i != 0) && (j != 0)) {
                    lookup_lcs(i, j);
                }
            }
        }
        this.lcslength = c[len1][len2][0];
        generateLCSString();
    }

    private void lookup_lcs(int i, int j) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            c[i][j][0] = c[i - 1][j - 1][0] + 1;                    //          ……………………………(3)  	 
            c[i][j][1] = 0; //diagonal arrow 
        } else {
            c[i][j][0] = c[i - 1][j - 1][0];     //………………………….(2)
            c[i][j][1] = 3; //none 
        }

        if (c[i - 1][j][0] >= c[i][j][0]) {
            c[i][j][0] = c[i - 1][j][0];
            c[i][j][1] = 1; //up arrow                                     …………………………….(5)  
        }

        if (c[i][j - 1][0] >= c[i][j][0]) {
            c[i][j][0] = c[i][j - 1][0];
            c[i][j][1] = 2; //left arrow                                   ………………………………(4)  
        }
        //System.out.println("lookup_lcs"+i+", "+j); 
    }

    private void generateLCSString() {    //……………………………..(6)
        int i = len1;
        int j = len2;
        while (i > 0 && j > 0) {
            if (c[i][j][1] == 0) {
                i--;
                j--;
                lcsString = s1.charAt(i) + lcsString;
            } else if (c[i][j][1] == 1) {
                i--;
            } else if (c[i][j][1] == 2) {
                j--;
            }
            //System.out.println("generate_lcs_string"+i+", "+j); 
        }
    }

    public int getLCSLength() {
        return lcslength;
    }

    public String getlcsString() {
        return lcsString;
    }

}
