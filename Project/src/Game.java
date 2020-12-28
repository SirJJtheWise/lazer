import java.util.Scanner;

public class Game {

	// static boolean ALIVE;
	static char[][] FELD = new char[16][16];
	static int HIGHSCORE = 0;
	static int LEBEN = 3;
	static int schwierigkeit;

	public static void main(String[] args) {
//		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Schwierigkeit eingeben");
		String schwierigkeit_in_string = myObj.nextLine();

		schwierigkeit = Integer.parseInt(schwierigkeit_in_string);

//		Lasers laser = new Laser(FELD, schwierigkeit);
//		Player player = new Player(FELD, HIGHSCORE, LEBEN, schwierigkeit);
//		Spielfeld spielfeld =new Spielfeld(FELD);
//

//		while (player.nichtzuende()) {
//			player.setPlayer(FELD);
//			Lasers.vorwarnung();
//			Bomben.vorwarnung();
//			Coin.spawn();
//			print();
//			Player.move();
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
