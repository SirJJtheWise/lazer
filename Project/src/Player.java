import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player implements Runnable {
	// Methode die den Player bewegt
	private int highscore;
	static int xkoordinate, ykoordinate, max_xkoordinate, max_ykoordinate;
	// private byte herzen;
	// public int level, aktuelles_level;
	Spielplan plan;
	// private char alteposition;
	Lazers laser;

	public void run() {
		while (true) {
			try {

				move();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Player(Spielplan Plan, Lazers laser) {
		// highscore = HIGHSCORE;
		// herzen = (byte) LEBEN;
		// level = SCHWIERIGKEIT;
		this.laser = laser;
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

	public synchronized void move() throws IOException {

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
						} else {
							plan.print();
						}

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

		} while (true);
	}

	private boolean außerhalb_des_feldes() {
		if (ykoordinate < 0 || ykoordinate >= max_ykoordinate || xkoordinate < 0 || xkoordinate >= max_xkoordinate) {
			return true;
		}
		return false;
	}

//	public int getHerzen() {
//	return herzen;
//}
//
////public char[][] setPlayer(char[][] spielfeld) throws IOException {
//
//	 {
//		spielfeld[xkoordinate][ykoordinate] = alteposition;
//		alteposition = spielfeld[xkoordinate][ykoordinate];
//		spielfeld[xkoordinate][ykoordinate] = 'P';
//	}
//
//}	

//	public void setHerzen(byte herzen) {
//	this.herzen = herzen;
//}

//	public boolean treffer() {
//		// Gibt zurück ob er tot ist, wobei false = tot und true = lebend
//		if (herzen == 1) {
//			return false;
//		}
//		--herzen;
//		return true;
//	}

	// Methode die Input abfragt

//	private char input() {
//
//		/*
//		 * // Enter data using BufferReader BufferedReader reader = new
//		 * BufferedReader(new InputStreamReader(System.in));
//		 *
//		 * // Reading data using readLine String name = reader.readLine();
//		 *
//		 * return name;
//		 */
//
//		return 'g';
//	}

//	private boolean gewonnen() {
//		if (level == aktuelles_level && herzen > 0) {
//			return true;
//		}
//		return false;
//	}
//
//	public boolean nichtzuende() {
//		if (aktuelles_level <= level && herzen > 0) {
//			return true;
//		}
//		return false;
//	}

}
