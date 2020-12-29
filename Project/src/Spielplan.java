import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spielplan {
	public static void main(String[] args) {
		Spielplan test = new Spielplan();
		test.print();
		System.out.print("\033[H\033[2J");
		System.out.println("test123");
		System.out.print("\033[H\033[2J");
		test.printIndicator();
	}

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_WHITE = "\u001B[37m";

	private int[] currPos;
	volatile static char[][] field = new char[12][12];
	private StringBuilder str;

	public Spielplan() {
		str = new StringBuilder();
	}

	public synchronized void print() {
		// char[][] field =
		// {{0,0,0,'h',0},{0,0,0,'h',0},{'v','v','v','v','v'},{0,0,0,'h',0},{0,0,0,'h',0}};
		currPos = new int[] { Player.getX(), Player.getY() };
		printHead();
		for (int w = 0; w < field.length; w++) {
			str.append("--------");
		}
		str.append("\n");
		for (int h = 0; h < field[0].length; h++) {
			for (int n = 0; n < 3; n++) {
				for (int w = 0; w < field.length; w++) {
					fieldOutput(w, h, false, n);
				}
				str.append("|\n");
			}
			for (int w = 0; w < field.length; w++) {
				str.append("--------");
			}
			str.append("\n");
		}
		System.out.print("\033[H\033[2J");
		System.out.println(str.toString());
		str.setLength(0); // clear StringBuilder
	}

	public synchronized void printIndicator() {
		// char[][] field =
		// {{0,0,0,'h',0},{0,0,0,'h',0},{'v','v','v','v','v'},{0,0,0,'h',0},{0,0,0,'h',0}};
		currPos = new int[] { Player.getX(), Player.getY() };
		printHead();
		for (int w = 0; w < field.length; w++) {
			str.append("--------");
		}
		str.append("\n");
		for (int h = 0; h < field[0].length; h++) {
			for (int n = 0; n < 3; n++) {
				for (int w = 0; w < field.length; w++) {
					fieldOutput(w, h, true, n);
				}
				str.append("|\n");
			}
			for (int w = 0; w < field.length; w++) {
				str.append("--------");
			}
			str.append("\n");
		}
		System.out.print("\033[H\033[2J");
		System.out.println(str.toString());
		str.setLength(0); // clear StringBuilder
	}

	private void fieldOutput(int w, int h, boolean indicator, int n) {
		str.append("|");
		if (w == currPos[0] && h == currPos[1]) {
			str.append(ANSI_CYAN);
			if (n == 1)
				str.append("(ง'̀-'́)ง");
			else
				str.append("       ");
			str.append(ANSI_RESET);
		} else if (field[w][h] == 'v') {
			if (indicator) {
				str.append(ANSI_PURPLE);
				str.append("   |   ");
			} else {
				str.append(ANSI_RED);
				str.append("  |||  ");
			}
			str.append(ANSI_RESET);
		} else if (field[w][h] == 'h') {
			if (indicator) {
				str.append(ANSI_PURPLE);
				str.append("   -   ");
			} else {
				str.append(ANSI_RED);
				str.append("  ---  ");
			}
			str.append(ANSI_RESET);
		} else if (field[w][h] == 'c') {
			str.append(ANSI_YELLOW);

			str.append("̅$̅(̲̅5̲̅)̅$");
			str.append(ANSI_RESET);
		} else
			str.append("       ");
	}

	private void printHead() {
		str.append("Welcome to Lazer!\n");
		str.append("Be fast and set your next position\n");
		str.append("Your highscore: ");
		str.append(Game.HIGHSCORE);
		str.append("\n");
		str.append("Your lives: ");
		for (int i = 1; i <= Game.LEBEN; i++)
			str.append("\u001B[33m♥ \u001B[0m");
		str.append("\n");
	}

}