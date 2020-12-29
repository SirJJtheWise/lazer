import javax.naming.SizeLimitExceededException;
import java.util.Random;

public class Lazers {
	char[][] spielfeld;
	long zuletzt_aufgerufen;

	long faktor;
	boolean[][] todesBereich;

	public Lazers(char[][] s) {
		spielfeld = s;
		zuletzt_aufgerufen = 0;
		faktor = 2;
		todesBereich = new boolean[spielfeld.length][spielfeld[0].length];
	}

	public void activateLazers(long ZeitAktuell) {
		// faktor der spawnrate und frequenz
		// @JAsomn!!! faktor = (ZeitAktuell / 1000 + 1);
		// wenn die letzten laser lang genug her sind
		// @JAson!!!!!!if (ZeitAktuell >= zuletzt_aufgerufen + 500) {
		laserSchießen();
		// @Jason!!!! }

	}

	void laserSchießen() {
		int grenze = (int) (faktor);
		for (int i = 0; i < grenze; i++) {
			// horizointal oder vertikal
			int OneORTwo = getRandomNumberInRange(0, 1);
			if (OneORTwo > 0) {
				// vertical
				int Xshot = getRandomNumberInRange(0, spielfeld.length - 1);
				for (int j = 0; j < spielfeld[0].length; j++) {
					spielfeld[Xshot][j] = 'v';
					todesBereich[Xshot][j] = true;
				}
			} else {
				// horizontal
				int Yshot = getRandomNumberInRange(0, spielfeld[0].length - 1);
				for (int j = 0; j < spielfeld.length; j++) {
					spielfeld[j][Yshot] = 'h';
					todesBereich[j][Yshot] = true;

				}
			}
		}
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public boolean isInDeath(int x, int y) {
		if (todesBereich[x][y] == true) {
			return true;
		} else
			return false;
	}

	public void deletlazers() {
		// loösche alle todesbereich
		// lösche lazerzeichen
		for (int i = 0; i < todesBereich.length; i++) {
			for (int j = 0; j < todesBereich[0].length; j++) {
				todesBereich[i][j] = false;
				if (spielfeld[i][j] == 'v' || spielfeld[i][j] == 'h') {
					spielfeld[i][j] = ' ';
				}
			}
		}
	}

//	public static void main(String[] args) {
//		char[][] a = new char[16][16];
//
//		Game g = new Game();
//		g.FELD = a;
//		Spielplan p = new Spielplan();
//		Lazers l = new Lazers(a);
//		l.activateLazers(30000);
//		p.print();
//		System.out.println(a[4][4]);
//	}

}
