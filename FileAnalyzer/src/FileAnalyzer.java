import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileAnalyzer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream inputStream = null;
		Scanner sc = null;
		int count = 0, countServe = 0, max = 0, current = 0;

		String currentKey = null;

		ArrayList<String> list = new ArrayList<String>();

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

					// count = count +1;
				}

				// Question 2
				if (line.contains("heroku/router")) {

					String[] temp = line.split("service=");
					String[] temp0 = temp[1].split("ms");
					countServe = countServe + Integer.parseInt(temp0[0]);
					// System.out.println(temp0[0]);
					// count = count +1;
				}

				// Question 3
				if (line.contains("FROM")) {
					char symbol = '"';
					String[] temp = line.split("FROM");
					String[] temp0 = temp[1].split("WHERE");
					String[] temp1 = temp0[0].split(Character.toString(symbol));

					try {
						// System.out.println(temp1[1]);
						list.add(temp1[1]);

					} catch (Exception e) {
						// System.out.println(e.getMessage());
					}

					// count = count +1;
				}
				// Question 4
				if (line.contains("redir")) {
					// System.out.println(line);
				}
				// Question 5
				if (line.contains("404") && line.contains("heroku/router")) {
					// System.out.println(line);
					// count = count +1;
				}

			}
			System.out.println("404 count: " + count); // question 1
			// System.out.println(countServe/count); // for question 2

			if (sc.ioException() != null) {
				throw sc.ioException(); // note that Scanner suppresses exceptions
			}

			Set<String> unique = new HashSet<String>(lists);
			for (String key : unique) {
				current = Collections.frequency(lists, key);
				if (max < current) {
					max = current;
					currentKey = key;
				}
				System.out.println("The path " + currentKey + " was requested " + max + " times");
			}
			System.out.println("The table " + currentKey + " happens " + max + " times");

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
