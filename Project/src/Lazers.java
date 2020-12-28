import javax.naming.SizeLimitExceededException;
import java.util.Random;

public class Lazers {
    char[][] spielfeld;
    long zuletzt_aufgerufen;

    long faktor;
    boolean[][] todesBereich;

    public Lazers(char[][] s) {
        spielfeld = s;
        zuletzt_aufgerufen = 500;

        todesBereich = new boolean[spielfeld.length][spielfeld[0].length];
    }


    public void activateLazers(long ZeitAktuell) {
        //faktor der spawnrate und frequenz
        faktor = ZeitAktuell;
        //wenn die letzten laser lang genug her sind
        if (ZeitAktuell >= zuletzt_aufgerufen + 500) {
            laserSchießen();
        }

    }

    private void laserSchießen() {
        int grenze = (int)(1+faktor/10);
        for (int i = 0; i < grenze; i++) {
            //horizointal oder vertikal
            int OneORTwo = getRandomNumberInRange(0, 1);
            if (OneORTwo < 0) {
                //vertical
                int Xshot = getRandomNumberInRange(0, spielfeld.length - 1);
                for (int j = 0; j < spielfeld[0].length; j++) {
                    spielfeld[Xshot][j] = 'V';
                    todesBereich[Xshot][j] = true;
                }
            } else {
                //horizontal
                int Yshot = getRandomNumberInRange(0, spielfeld[0].length - 1);
                for (int j = 0; j < spielfeld.length; j++) {
                    spielfeld[j][Yshot] = 'H';
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
        } else return false;
    }

    public void deletlazers() {
        //loösche alle todesbereich
        //lösche lazerzeichen
        for (int i = 0; i < todesBereich.length; i++) {
            for (int j = 0; j < todesBereich[0].length; j++) {
                todesBereich[i][j] = false;
                if (spielfeld[i][j] == 'V' || spielfeld[i][j] == 'H') {
                    spielfeld[i][j] = ' ';
                }
            }
        }
    }
    public static void main(String[] args){
        char[][] a=new char[5][5];
        Lazers l=new Lazers(a);
        l.activateLazers(3000);
        System.out.println(a[0][0]);
    }


}
