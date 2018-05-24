import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class q5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream inputStream = null;
		Scanner sc = null;
		int count = 0;

		try {
			inputStream = new FileInputStream(new File("C:\\Users\\Gil\\Desktop\\2014-09-03.log"));
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				// Question 5
				if (line.contains("404") && line.contains("heroku/router")) {
					System.out.println(line);
					count = count + 1;
				}

			}
			System.out.println("404 count: " + count);

			if (sc.ioException() != null) {
				throw sc.ioException(); // suppress exceptions
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
