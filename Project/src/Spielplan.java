import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Spielplan {
	public static void main(String[] args) throws InterruptedException, IOException {
		Spielplan test = new Spielplan();
		//test.startScreen();
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

	private static final String[] GAME_OVER = new String[]{"┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼" ,"███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀" ,"██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼" ,"██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀" ,"██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼" ,"███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄" ,"┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼" ,"███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼" ,"██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼" ,"██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼" ,"██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼" ,"███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄" ,"┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼" ,"┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼"};
	private static final String[] WEIRD_PERSON = new String[]{"⊂_ヽ","　 ＼＼","　　 ＼( ͡° ͜ʖ ͡°)","　　　 >　⌒ヽ","　　　/ 　 へ＼","　　 /　　/　＼＼","　　 ﾚ　ノ　　 ヽ_つ","　　/　/","　 /　/|","　(　(ヽ","　|　|、＼","　| 丿 ＼ ⌒)","　| |　　) /","ノ )　　Lﾉ","(_／"};
	private static final String[] START_SCREEN = new String[]{"                  (xXXXX|xx======---(-","                  /     |","                 /    XX|","                /xxx XXX|","               /xxx X   |","              / ________|","      __ ____/_|_|_______\\_","  ###|=||________|_________|_","      ~~   |==| __  _  __   /|~~~~~~~~~-------------_______","           |==| ||(( ||()| | |XXXXXXXX|                    >","      __   |==| ~~__~__~~__ \\|_________-------------~~~~~~~","  ###|=||~~~~~~~~|_______  |\"","      ~~ ~~~~\\~|~|       /~","              \\ ~~~~~~~~~","               \\xxx X   |","                \\xxx XXX|     Coded by","                 \\    XX|               Oli","                  \\     |                Jason","                  (xXXXX|xx======---(-    Yanis","                    ~~~~                 Daria"};

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

			str.append("   ₿   ");
			str.append(ANSI_RESET);
		} else
			str.append("       ");
	}

	public int startScreen(Scanner sc) throws InterruptedException {
		for(int i = 0; i < 50; i++) {
			str.append("\n\n");
			for (String line : START_SCREEN) {
				for(int n = 0; n < i; n++) {
					str.append("  ");
				}
				str.append(line);
				str.append("\n");
			}
			System.out.print("\033[H\033[2J");
			System.out.println(str.toString());
			str.setLength(0); // clear StringBuilder
			TimeUnit.MILLISECONDS.sleep(40);
		}
		str.append("         /\\    \\          /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\         \n" +
				"        /::\\____\\        /::\\    \\                /::\\    \\                /::\\    \\                /::\\    \\        \n" +
				"       /:::/    /       /::::\\    \\               \\:::\\    \\              /::::\\    \\              /::::\\    \\       \n" +
				"      /:::/    /       /::::::\\    \\               \\:::\\    \\            /::::::\\    \\            /::::::\\    \\      \n" +
				"     /:::/    /       /:::/\\:::\\    \\               \\:::\\    \\          /:::/\\:::\\    \\          /:::/\\:::\\    \\     \n" +
				"    /:::/    /       /:::/__\\:::\\    \\               \\:::\\    \\        /:::/__\\:::\\    \\        /:::/__\\:::\\    \\    \n" +
				"   /:::/    /       /::::\\   \\:::\\    \\               \\:::\\    \\      /::::\\   \\:::\\    \\      /::::\\   \\:::\\    \\   \n" +
				"  /:::/    /       /::::::\\   \\:::\\    \\               \\:::\\    \\    /::::::\\   \\:::\\    \\    /::::::\\   \\:::\\    \\  \n" +
				" /:::/    /       /:::/\\:::\\   \\:::\\    \\               \\:::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/\\:::\\   \\:::\\____\\ \n" +
				"/:::/____/       /:::/  \\:::\\   \\:::\\____\\_______________\\:::\\____\\/:::/__\\:::\\   \\:::\\____\\/:::/  \\:::\\   \\:::|    |\n" +
				"\\:::\\    \\       \\::/    \\:::\\  /:::/    /\\::::::::::::::::::/    /\\:::\\   \\:::\\   \\::/    /\\::/   |::::\\  /:::|____|\n" +
				" \\:::\\    \\       \\/____/ \\:::\\/:::/    /  \\::::::::::::::::/____/  \\:::\\   \\:::\\   \\/____/  \\/____|:::::\\/:::/    / \n" +
				"  \\:::\\    \\               \\::::::/    /    \\:::\\~~~~\\~~~~~~         \\:::\\   \\:::\\    \\            |:::::::::/    /  \n" +
				"   \\:::\\    \\               \\::::/    /      \\:::\\    \\               \\:::\\   \\:::\\____\\           |::|\\::::/    /   \n" +
				"    \\:::\\    \\              /:::/    /        \\:::\\    \\               \\:::\\   \\::/    /           |::| \\::/____/    \n" +
				"     \\:::\\    \\            /:::/    /          \\:::\\    \\               \\:::\\   \\/____/            |::|  ~|          \n" +
				"      \\:::\\    \\          /:::/    /            \\:::\\    \\               \\:::\\    \\                |::|   |          \n" +
				"       \\:::\\____\\        /:::/    /              \\:::\\____\\               \\:::\\____\\               \\::|   |          \n" +
				"        \\::/    /        \\::/    /                \\::/    /                \\::/    /                \\:|   |          \n" +
				"         \\/____/          \\/____/                  \\/____/                  \\/____/                  \\|___|          \n");
		str.append("Press W to move up\n");
		str.append("Press A to move left\n");
		str.append("Press S to move down\n");
		str.append("Press D to move right\n");
		str.append("Enter difficulty: easy: 0->3  medium: 3->10 hard: 10->death ");
		System.out.print("\033[H\033[2J");
		System.out.println(str.toString());
		str.setLength(0); // clear StringBuilder
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		//if (reader.ready()) {
		//String name = reader.readLine();
		if (sc.hasNextInt()) {
			//reader.close();
			return sc.nextInt();
		}
		//reader.close();
		return 0;
	}

	public void youLostALife() throws InterruptedException {
		for(int i = 0; i < 50; i++) {
			str.append("\n\n");
			for(int n = 0; n < i; n++) {
				str.append("  ");
			}
			str.append("(;´༎ຶД༎ຶ`)\n\n");
			for(int n = 0; n < i; n++) {
				str.append("  ");
			}
			str.append("YOU LOST A LIFE!\n");
			System.out.print("\033[H\033[2J");
			System.out.println(str.toString());
			str.setLength(0); // clear StringBuilder
			TimeUnit.MILLISECONDS.sleep(40);
		}
	}

	public boolean gameOver() throws InterruptedException, IOException {
		for(int i = 0; i < 50; i++) {
			str.append("\n\n");
			for (String line : GAME_OVER) {
				for(int n = 0; n < i; n++) {
					str.append("  ");
				}
				str.append(line);
				str.append("\n");
			}
			System.out.print("\033[H\033[2J");
			System.out.println(str.toString());
			str.setLength(0); // clear StringBuilder
			TimeUnit.MILLISECONDS.sleep(40);
		}

		for (String line : WEIRD_PERSON) {
			str.append("  ");
			str.append(line);
			str.append("  ");
			str.append("\n");
		}
		str.append("YOUR HIGHSCORE:\n");
		str.append(Game.HIGHSCORE);
		str.append("\n");
		str.append("HIGHEST HIGHSCORE:\n");
		str.append(Game.HIGHESTSCORE);
		str.append("\n\n");
		str.append("Press R to restart the Game");
		System.out.print("\033[H\033[2J");
		System.out.println(str.toString());
		str.setLength(0); // clear StringBuilder
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		//if (reader.ready()) {
			String name = reader.readLine();
			if (name.equals("R")) {
				reader.close();
				return true;
			}
			reader.close();
			return false;
		//}

		//return false;
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
		str.append("Current number of lasers: ");
		str.append(Game.lasers/4);
		str.append("\n");
	}

}