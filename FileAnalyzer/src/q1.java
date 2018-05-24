import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q1 {

	public static void main(String[] args) throws IOException {

		FileInputStream inputStream = null;
		Scanner sc = null;

		int max = 0, current = 0;
		String currentKey = null;

		ArrayList<String> lists = new ArrayList<String>();
		try {
			inputStream = new FileInputStream(new File("C:\\Users\\Gil\\Desktop\\2014-09-03.log"));
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				// Question 1
				if (line.contains("404") && line.contains("app/web")) {
					char symbol = '"';
					String[] temp = line.split("path=");

					try {
						String[] temp0 = temp[1].split(Character.toString(symbol));
						String[] temp1 = temp0[0].split(" ");
						System.out.println(temp1[0]);
						lists.add(temp1[0]);

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}

			if (sc.ioException() != null) {
				throw sc.ioException(); // suppress exceptions
			}

			Set<String> unique = new HashSet<String>(lists);
			for (String temp : unique) {
				current = Collections.frequency(lists, temp);
				if (max < current) {
					max = current;
					currentKey = temp;
				}
				System.out.println("The path " + currentKey + " was requested " + max + " times");
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
