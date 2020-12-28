public class Player {
	// Methode die den Player bewegt
	// private String name;
	private int highscore;
	private static int xkoordinate, ykoordinate, max_xkoordinate, max_ykoordinate;
	private byte herzen;
	public int level, aktuelles_level;

	private char alteposition;

	public Player(char[][] spielfeld, int HIGHSCORE, int LEBEN, int SCHWIERIGKEIT) {
		// this.name = name;
		highscore = HIGHSCORE;
		herzen = (byte) LEBEN;
		level = SCHWIERIGKEIT;
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

	public int getHerzen() {
		return herzen;
	}

	public char[][] setPlayer(char[][] spielfeld) {

		if (move() == true) {
			spielfeld[xkoordinate][ykoordinate] = alteposition;
			alteposition = spielfeld[xkoordinate][ykoordinate];
			spielfeld[xkoordinate][ykoordinate] = 'P';
		}

		return spielfeld;
	}

	public boolean move() {
		char eingabe = input();

		// Überprüfung ob Eingabe erfolgte, falls nicht false returnen sodass die
		// Position nicht verändert wird
		/*
		 * if (eingabe == '') { return false; }
		 */

		if (außerhalb_des_feldes()) {
			return false;
			// Kann theoretisch noch ausgeben, dass man sich außerhalb des Feldes befindet
		}
		switch (eingabe) {
		case 'w':
			++ykoordinate;
		case 'a':
			--xkoordinate;
		case 'd':
			++xkoordinate;
		case 's':
			++ykoordinate;
		}
		return true;

	}

	private boolean außerhalb_des_feldes() {
		if (ykoordinate - 1 < 0 || ykoordinate + 1 >= max_ykoordinate || xkoordinate - 1 < 0
				|| xkoordinate + 1 >= max_xkoordinate) {
			return true;
		}
		return false;
	}

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

		return 'e';
	}

	private boolean gewonnen() {
		if (level == aktuelles_level && herzen > 0) {
			return true;
		}
		return false;
	}

	public boolean nichtzuende() {
		if (aktuelles_level <= level && herzen > 0) {
			return true;
		}
		return false;
	}

}
