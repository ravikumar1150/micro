package com.demo;

public class Demo {

	    public static void main(String[] args) {
	        int[] arr = {1, 5, 2, 6, 7, 10, 0, 4};
	        
	        int[] result = new int[arr.length];

	        for (int i = 0; i < arr.length; i++) {
	            int nextGreater = -1;
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[j] > arr[i]) {
	                    nextGreater = arr[j];
	                    break;
	                }
	            }
	            result[i] = nextGreater;
	        }

	        // Print the result
	        for (int num : result) {
	            System.out.print(num + " ");
	        }
	    }
	}



