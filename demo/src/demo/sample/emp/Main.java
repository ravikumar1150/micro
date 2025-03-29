package demo.sample.emp;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	
	public static void main(String [] args) {
		
		String str = "ravikumar";
		
		int start=0;
		int maxLength =0;
		String substring =null;
		
		Map<Character,Integer> map = new LinkedHashMap<>();
		
		for(int i=0;i<str.length();i++) {
			
			char c = str.charAt(i);
			
			
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				
				i = map.get(c);
				map.clear();
				start=i;
			}
			
			if(maxLength < map.size()) {
				
				maxLength=map.size();
			}
			
			 substring = str.substring(start,i+1);
			
		}
		
		
		
		  System.out.println(substring);       
		
	
	}


}
