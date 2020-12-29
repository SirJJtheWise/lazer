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

		System.out.println("Press W to move up\n");
		System.out.println("Press A to move left\n");
		System.out.println("Press W to move downw\n");
		System.out.println("Press W to move right\n");

		Scanner sc = new Scanner(System.in);
		System.out.println("Schwierigkeit eingeben");
		if (sc.hasNextInt()) {
			SCHWIERIGKEIT = sc.nextInt();
		}
		Lazers laser = new Lazers(spiel.field);
		Coin c = new Coin(spiel.field);
		Thread thread = new Thread(new Player(spiel, laser, c));

		spiel.print();
		thread.start();

		int laserZaehler = 8;
		while (LEBEN >= 0) {
			laserZaehler++;
			laser.deletlazers();
			c.deleteCoin();

			c.generateCoin();
			laser.laserSchießen(laserZaehler / 4);
			spiel.print();

			try {
				Thread.sleep(6000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			// laser.schie0en
			if (laser.isInDeath(Player.getX(), Player.getY())) {
				LEBEN--;
				System.out.println("SIE HABEN EIN LEBEN VERLOERN");
				// ANIMATION??
				HIGHSCORE -= 5000;
			}
			// print
			HIGHSCORE += 1000 * laserZaehler / 8;
		}
		thread.stop();
		System.out.println("GAME" + "\nOver");

	}

	public static void main(String[] args) {

		Spielplan plan = new Spielplan();
		Game game = new Game(plan);
		Thread thread1 = new Thread(game);

		thread1.start();

	}

}
