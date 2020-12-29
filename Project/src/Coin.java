import java.math.*;

public class Coin {
	char[][] Feld;
	int[] letzterCoin = new int[2];

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
		int xCoin = (int) (12 * Math.random());
		int yCoin = (int) (12 * Math.random());

		Feld[xCoin][yCoin] = 'c';
		letzterCoin[0] = xCoin;
		letzterCoin[1] = yCoin;

	}

	public synchronized void deleteCoin() {
		Feld[letzterCoin[0]][letzterCoin[1]] = ' ';
	}
}
