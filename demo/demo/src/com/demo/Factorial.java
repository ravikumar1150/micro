package com.demo;

public class Factorial {
	static void factorial(int n) {
        
		
	long startTime = System.currentTimeMillis();
		for(int i=1;i*i<=n;i++) {
			
			if(n%i==0) {
				
		         System.out.print(i+" ");
		         
		         if(i !=n/i ) {
		        	 
		        	 System.out.print((n/i)+" ");
		         }
				
			}
					
		}

		System.out.println();
		long endTime = System.currentTimeMillis();
																													
		System.out.println(startTime-endTime);
																																			
		
	}
	public static void main(String[] args) {
		
		
		factorial(12);
		
		
	}
		
		
	
		
	
}
