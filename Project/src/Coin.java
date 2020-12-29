import java.math.*;

public class Coin {
	char[][] Feld;

	public static void main(String[] args) {
		char[][] b = { { 'a', 'b' }, { 'a', 'b' } };
		Coin a = new Coin(b);
		a.generateCoin();
		for (int i = 0; i < a.Feld.length; i++) {
			for (int j = 0; j < a.Feld[i].length; j++) {
				System.out.println(b[i][j]);
			}
		}

	}

	public Coin(char[][] feld) {
		// TODO Auto-generated constructor stub
		Feld = feld;
	}

	public void generateCoin() {
		int coinFeld = (int) (16 * Math.random());

	}

	public void deleteCoin() {

	}
}
