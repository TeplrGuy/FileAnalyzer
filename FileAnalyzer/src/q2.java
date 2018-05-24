import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class q2 {

	public static void main(String[] args) throws IOException {

		FileInputStream inputStream = null;
		Scanner sc = null;

		int countServe = 0, count = 0;

		try {
			inputStream = new FileInputStream(new File("C:\\Users\\Gil\\Desktop\\2014-09-03.log"));
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				// Question 2
				if (line.contains("heroku/router")) {

					String[] temp = line.split("service=");
					String[] temp0 = temp[1].split("ms");
					countServe = countServe + Integer.parseInt(temp0[0]);
					System.out.println(temp0[0]);
					count = count + 1;
				}
			}
			System.out.println("Average time is " + countServe / count + " ms"); // for question 2
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
