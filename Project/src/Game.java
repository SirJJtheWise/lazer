import java.util.Scanner;

public class Game {
<<<<<<< HEAD
	static boolean ALIVE;
	static char[][] FELD = new char[16][16];
	static int HIGHSCORE = 0;
	static int LEBEN = 3;

	public static void main(String[] args) {
//		Lasers laser = new Laser(FELD,Schwierigkeit);
//		Player player = new Player(FELD);
//		Spielfeld spielfeld =new Spielfeld(FELD);
//

		System.out.println("Schwierigkeit eingeben");

//		while (ALIVE) {
//			Lasers.vorwarnung();
//			Bomben.vorwarnung();
//			Coin.spawn();
//			print();
//			Player.movement();
//			Lasers();
//			Bomben();
//			print();
//
//		}
	}

	public static void print() {
		// print FELD
		for (int i = 0; i < FELD.length; i++) {
			for (int j = 0; j < FELD[0].length; j++) {
				System.out.print(FELD[i][j]);
			}
		}
		System.out.println("\n " + HIGHSCORE);
	}

}
