import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class q4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream inputStream = null;
		Scanner sc = null;

		try {
		    inputStream = new FileInputStream(new File("C:\\Users\\Gil\\Desktop\\2014-09-03.log"));
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
			     String line = sc.nextLine();
			  
			     // Question 4
			     if( line.contains("redir")) {
			    	  System.out.println(line);
			     } 


			  }
		   
			if (sc.ioException() != null) {
			    throw sc.ioException();  //suppress exceptions
			}
			
			
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
