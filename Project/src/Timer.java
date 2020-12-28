import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Timer {
	public static void main(String[] args) throws IOException {
		long endTime = System.currentTimeMillis() + 5000L; // 5 secs
		while (System.currentTimeMillis() < endTime) {
			// Enter data using BufferReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Reading data using readLine
			String name = reader.readLine();

			// Printing the read dline
			System.out.println(name);
		}
	}

}
