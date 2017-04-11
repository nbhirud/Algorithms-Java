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
//Class MyQueue is an implementation of queue 
class MyQueue {

    private Link last;
    private Link first;

    public MyQueue() {
        first = null;
        last = null;

    }

    boolean isEmpty() {
        return first == null;
    }

    void add(int data) {
        Link element = new Link(data);
        if (last != null) {
            last.next = element;
        }
        element.next = null;
        last = element;
        if (first == null) {
            first = element;
        }

    }

    int remove() {
        if (first == null) {
            return -1;
        }
        int data = first.data;
        first = first.next;
        return data;
    }
}
