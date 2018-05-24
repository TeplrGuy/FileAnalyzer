import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream inputStream = null;
		Scanner sc = null;
		int count =0,  max = 0, current = 0;

	    String currentKey =  null;
	    
		ArrayList<String> list = new ArrayList<String>();
		
		try {
		    inputStream = new FileInputStream(new File("C:\\Users\\Gil\\Desktop\\2014-09-03.log"));
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
			     String line = sc.nextLine();
			   
			  // Question 3
			     if( line.contains("FROM") ) {
			    	   char symbol = '"';
			    	   String[] temp = line.split("FROM" );
			     	   String[] temp0 = temp[1].split("WHERE");
			     	   String[] temp1 = temp0[0].split(Character.toString(symbol));
			     	
			     	  try {
			     		 System.out.println(temp1[1]);
			     		 list.add(temp1[1]);
			     		  
			     	  }catch (Exception e) {
			     		 System.out.println(e.getMessage());
			     	  }
			     	 
			     	  count = count +1;
			     }

			  }
		 
			if (sc.ioException() != null) {
			    throw sc.ioException();  // suppress exceptions
			}
			   
			Set<String> unique = new HashSet<String>(list);
			for (String key : unique) {
	             current = Collections.frequency(list, key);
	             if(max < current){
	                max = current;
	                currentKey = key;
	              }
	            
	        }
			System.out.println("The table "  + currentKey + " happens " + max + " times");
			
			
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
	}

}
