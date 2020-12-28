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

	public Spielplan() {
		this.widht = 5;
		this.height = 5;
	}

	public void print() {
		StringBuilder str = new StringBuilder();
		//char[][] field = Game.FELD;
		char[][] field = {{0,0,0,'h',0},{0,0,0,'h',0},{'v','v','v','v','v'},{0,0,0,'h',0},{0,0,0,'h',0}};
		currPos = new int[]{Player.getX(), Player.getY()};
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
		for (int w = 0; w < field.length; w++) {
			str.append("------");
		}
		str.append("\n");
		for (int h = 0; h < field[0].length ; h++) {
			for (int n = 0; n < 2; n++) {
				for (int w = 0; w < field.length; w++) {
					fieldOutput(w,h,field,str,false);
				}
				str.append("|\n");
			}
			for (int w = 0; w < field.length; w++) {
				str.append("------");
			}
			str.append("\n");
		}
		System.out.println(str.toString());
	}

	public void printIndicator() {
		StringBuilder str = new StringBuilder();
		//char[][] field = Game.FELD;
		char[][] field = {{0,0,0,'h',0},{0,0,0,'h',0},{'v','v','v','v','v'},{0,0,0,'h',0},{0,0,0,'h',0}};
		currPos = new int[]{Player.getX(), Player.getY()};
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
		for (int w = 0; w < field.length; w++) {
			str.append("------");
		}
		str.append("\n");
		for (int h = 0; h < field[0].length ; h++) {
			for (int n = 0; n < 2; n++) {
				for (int w = 0; w < field.length; w++) {
					fieldOutput(w,h,field,str,true);
				}
				str.append("|\n");
			}
			for (int w = 0; w < field.length; w++) {
				str.append("------");
			}
			str.append("\n");
		}
		System.out.println(str.toString());
	}

	private void fieldOutput(int w,int h,char[][] field, StringBuilder str,boolean indicator) {
		str.append("|");
		if (w == currPos[0] && h == currPos[1]){
			str.append(ANSI_YELLOW);
			str.append("  x  ");
			str.append(ANSI_RESET);
		} else if (field[w][h] == 'v') {
			str.append(ANSI_RED);
			if (indicator) str.append("  |  ");
			else str.append(" ||| ");
			str.append(ANSI_RESET);
		} else if (field[w][h] == 'h') {
			str.append(ANSI_RED);
			if (indicator) str.append("  -  ");
			else str.append(" --- ");
			str.append(ANSI_RESET);
		} else str.append("     ");
	}

}