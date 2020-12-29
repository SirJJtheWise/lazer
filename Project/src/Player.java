import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
	// Methode die den Player bewegt
	private int highscore;
	static int xkoordinate, ykoordinate, max_xkoordinate, max_ykoordinate;
	private byte herzen;
	public int level, aktuelles_level;
	Spielplan plan;
	private char alteposition;

	public static void main(String[] args) throws IOException {

		Spielplan plan = new Spielplan();
		Player p = new Player(0, 3, 1, plan);

		p.move();

	}

	public void setHerzen(byte herzen) {
		this.herzen = herzen;
	}

	public Player(int HIGHSCORE, int LEBEN, int SCHWIERIGKEIT, Spielplan Plan) {
		highscore = HIGHSCORE;
		herzen = (byte) LEBEN;
		level = SCHWIERIGKEIT;
		plan = Plan;
		max_xkoordinate = 16;
		max_ykoordinate = 16;
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

	public char[][] setPlayer(char[][] spielfeld) throws IOException {

		if (move() == true) {
			spielfeld[xkoordinate][ykoordinate] = alteposition;
			alteposition = spielfeld[xkoordinate][ykoordinate];
			spielfeld[xkoordinate][ykoordinate] = 'P';
		}

		return spielfeld;
	}

	public boolean move() throws IOException {

		String name = "";
		long endTime = System.currentTimeMillis() + 5000l;

		do {
			// Enter data using BufferReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Reading data using readLine
			if (reader.ready()) {
				name = reader.readLine();
				if (!name.equals("")) {
					char eingabe = name.charAt(0);
					switch (eingabe) {
					case 'w' -> {
						ykoordinate++;
						if (außerhalb_des_feldes()) {
							ykoordinate--;
						} else
							plan.print();
					}

					case 'a' -> {
						xkoordinate--;
						if (außerhalb_des_feldes()) {
							xkoordinate++;
						} else
							plan.print();
					}

					case 'd' -> {
						xkoordinate++;
						if (außerhalb_des_feldes()) {
							xkoordinate--;
						} else
							plan.print();
					}

					case 's' -> {
						ykoordinate--;
						if (außerhalb_des_feldes()) {
							ykoordinate--;
						} else {
							plan.print();
						}
					}
					}
				}

			}

			// Printing the read line

		} while (System.currentTimeMillis() < endTime);

		return true;

	}

	private boolean außerhalb_des_feldes() {
		if (ykoordinate < 0 || ykoordinate >= max_ykoordinate || xkoordinate < 0 || xkoordinate >= max_xkoordinate) {
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

		return 'g';
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
