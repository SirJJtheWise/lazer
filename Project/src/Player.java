import java.io.BufferedReader;
import java.util.Scanner;

public class Player {
	// Methode die den Player bewegt
	private String name;
	private int highscore;
	private static int xkoordinate, ykoordinate, xneu, yneu, max_xkoordinate, max_ykoordinate;
	private byte herzen;
	Scanner myObj;

	public static void main(String[] args) {
		char[][] a = { { 'a', 'a' }, { 'b', 'c' } };
		Player p = new Player("Kevin", a);
		Spielplan test = new Spielplan();

		p.move(a);

		test.print();

	}

	public Player(String name, char[][] spielfeld) {
		this.name = name;
		max_xkoordinate = spielfeld[0].length;
		max_ykoordinate = spielfeld[1].length;
		xkoordinate = (int) (Math.random() * max_xkoordinate);
		ykoordinate = (int) (Math.random() * max_ykoordinate);
	}

	public static int getX() {
		return xkoordinate;
	}

	public static int getY() {
		return ykoordinate;
	}

	public void move(char[][] feld) {
		long startTime = System.currentTimeMillis();
		Scanner myObj = new Scanner(System.in);
		String name = "x";
		while (5000 > (long) System.currentTimeMillis() - startTime) {
			if (myObj.hasNext()) {
				name = myObj.nextLine();
				if (name != null) {
					myObj.close();
					break;
				}
			}
		}
		if (name == null)
			return;
		char eingabe = name.charAt(0);

		xneu = xkoordinate;
		yneu = ykoordinate;

		switch (eingabe) {
		case 'w' -> {
			++yneu;
			if (xneu < 0 || xneu >= feld.length || yneu < 0 || yneu >= feld[0].length)
				return;
			feld[xkoordinate][yneu] = 'p';

		}
		case 'a' -> {
			--xneu;
			if (xneu < 0 || xneu >= feld.length || yneu < 0 || yneu >= feld[0].length)
				return;
			feld[xneu][yneu] = 'p';

		}
		case 'd' -> {
			++xneu;
			if (xneu < 0 || xneu >= feld.length || yneu < 0 || yneu >= feld[0].length)
				return;
			feld[xneu][yneu] = 'p';
		}
		case 's' -> {
			--yneu;
			if (xneu < 0 || xneu >= feld.length || yneu < 0 || yneu >= feld[0].length)
				return;
			feld[xneu][yneu] = 'p';
		}
		default -> {
			return;
		}
		}

	}

//	private boolean außerhalb_des_feldes() {
//		if (ykoordinate - 1 < 0 || ykoordinate + 1 >= max_ykoordinate || xkoordinate - 1 < 0
//				|| xkoordinate + 1 >= max_xkoordinate) {
//			return true;
//		}
//		return false;
//	}

	public boolean treffer() {
		// Gibt zurück ob er tot ist, wobei false = tot und true = lebend
		if (herzen == 1) {
			return false;
		}
		--herzen;
		return true;
	}

	// Methode die Input abfragt

	private char input() {
		/*
		 * // Enter data using BufferReader BufferedReader reader = new
		 * BufferedReader(new InputStreamReader(System.in));
		 *
		 * // Reading data using readLine String name = reader.readLine();
		 *
		 * return name;
		 */
		return 0;
	}

}
