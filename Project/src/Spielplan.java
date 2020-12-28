import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spielplan {
	public static void main(String[] args) {
		Spielplan test = new Spielplan();
		test.print();
	}
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	private int widht;
	private int height;
	private int[] currPos;
	private int[] lazerCoords;

	public Spielplan() {
		this.widht = 5;
		this.height = 5;
	}

	public void print() {
		StringBuilder str = new StringBuilder();
		currPos = new int[]{1, 1};
		lazerCoords = new int[]{2, 3};
		str.append("Welcome to Lazer!\n");
		str.append("Be fast and set your next position\n");
		str.append("Your current position: ");
		str.append(currPos[0]);
		str.append(", ");
		str.append(currPos[1]);
		str.append("\n");
		str.append("Number of Lazers active: ");
		str.append(1);
		str.append("\n");
		for (int w = 0; w < widht; w++) {
			if (lazerCoords != null && w == lazerCoords[0]) {
				str.append("--");
				str.append(ANSI_RED);
				str.append("---");
				str.append(ANSI_RESET);
				str.append("-");
			} else str.append("------");
		}
		str.append("\n");
		for (int h = 0; h < height ; h++) {
			for (int n = 0; n < 2; n++) {
				for (int w = 0; w < widht; w++) {
					if (lazerCoords != null && h == lazerCoords[1]) {
						str.append(ANSI_RED);
						str.append("|");
						str.append(ANSI_RESET);
					} else str.append("|");
					if (w == currPos[0] && h == currPos[1]){
						str.append(ANSI_YELLOW);
						str.append("  x  ");
						str.append(ANSI_RESET);
					} else if (lazerCoords != null && w == lazerCoords[0]) {
						str.append(ANSI_RED);
						str.append(" ||| ");
						str.append(ANSI_RESET);
					} else if (lazerCoords != null && h == lazerCoords[1]) {
						str.append(ANSI_RED);
						str.append(" --- ");
						str.append(ANSI_RESET);
					}
					else str.append("     ");
				}
				str.append("|\n");
			}
			for (int w = 0; w < widht; w++) {
				str.append("------");
			}
			str.append("\n");
		}
		System.out.println(str.toString());
	}

}
