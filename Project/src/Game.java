import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game implements Runnable {

	// static boolean ALIVE;

	static int HIGHSCORE = 0;
	static int LEBEN = 3;
	static int SCHWIERIGKEIT;
	Spielplan spiel;

	public Game(Spielplan spiel) {
		super();
		this.spiel = spiel;
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Schwierigkeit eingeben");
		if (sc.hasNextInt()) {
			SCHWIERIGKEIT = sc.nextInt();
		}

		Thread thread = new Thread(new Player(spiel));
		thread.start();

		Lazers laser = new Lazers(spiel.FELD);
		spiel.print();

		while (LEBEN >= 0) {
			laser.deletlazers();

			laser.laserSchießen();
			spiel.print();
			try {
				Thread.sleep(6000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			if (laser.isInDeath(Player.getX(), Player.getY())) {
				LEBEN--;
				System.out.println("SIE HABEN EIN LEBEN VERLOERN");
				// ANIMATION??
			}
			HIGHSCORE += 1000;
		}
		thread.stop();
		System.out.println("GAME" + "\nOver");
//			player.setPlayer(FELD);
//			Lasers.vorwarnung();
//			Bomben.vorwarnung();
//			Coin.spawn();
//			print();
//			Player.move();
//			Lasers();
//			Bomben();
//			print();

	}

	public static void main(String[] args) {

		Spielplan plan = new Spielplan();
		Game game = new Game(plan);
		Thread thread1 = new Thread(game);

		thread1.start();

	}

}
