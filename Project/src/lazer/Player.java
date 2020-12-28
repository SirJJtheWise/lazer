package lazer;

impport 

public class Player {
	// Methode die den Player bewegt
	private String name;
	private int highscore;
	private int xkoordinate, ykoordinate, max_xkoordinate, max_ykoordinate;
	private byte herzen;

	public Player(String name, char[][] spielfeld) {
		this.name = name;
		max_xkoordinate = spielfeld[0].length;
		max_ykoordinate = spielfeld[1].length;
		xkoordinate = (int) (Math.random() * max_xkoordinate);
		ykoordinate = (int) (Math.random() * max_ykoordinate);
	}

	public void move() {
		char eingabe = input();
		if (außerhalb_des_feldes()) {
			return;
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
	}

}
