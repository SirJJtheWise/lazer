import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game implements Runnable {

	// static boolean ALIVE;

	static int HIGHSCORE = 0;
	static int HIGHESTSCORE = 0;
	static int LEBEN = 3;
	static int SCHWIERIGKEIT;
	Spielplan spiel;
	static int lasers;

	public Game(Spielplan spiel) {
		super();
		this.spiel = spiel;
	}

	public void run() {

		System.out.println("Press W to move up\n");
		System.out.println("Press A to move left\n");
		System.out.println("Press S to move downw\n");
		System.out.println("Press D to move right\n");

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
		while (true) {
			lasers = 8;
			while (LEBEN > 0) {
				lasers++;
				laser.deletlazers();
				c.deleteCoin();
				c.generateCoin();
				laser.laserSchießen(lasers / 4);
				spiel.printIndicator();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}

				Player.setSleep(true);

				spiel.print();
				if (laser.isInDeath(Player.getX(), Player.getY())) {
					LEBEN--;
					System.out.println("SIE HABEN EIN LEBEN VERLOERN");
					// ANIMATION??
					HIGHSCORE -= 5000;
					try {
						spiel.youLostALife();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}

				HIGHSCORE += 1000 * lasers / 8;

			}
			thread.stop();
			System.out.println("GAME" + "\nOver");
			if (HIGHESTSCORE < HIGHSCORE)
				HIGHESTSCORE = HIGHSCORE;
			try {
				if (spiel.gameOver()) {

				} else {
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LEBEN = 3;
			HIGHSCORE = 3;

			// if(HIGHSCORE>HIGHESTSCORE)
		}

	}

	public static void main(String[] args) {

		Spielplan plan = new Spielplan();
		Game game = new Game(plan);
		Thread thread1 = new Thread(game);

		thread1.start();

	}

}
