import java.util.Random;

public class Lazers { char [][] spielfeld;long zuletzt_aufgerufen;long faktor;long swierig;
                        boolean todesBereich[][];

        public Lazers(char[][] s,long zeit,int schwierigkeit){
            spielfeld=s;
            zuletzt_aufgerufen=0;
            swierig=schwierigkeit;
            todesBereich =new boolean[spielfeld.length][spielfeld[0].length];
        }


        public void activateLazers(long ZeitAktuell){
            faktor=swierig*ZeitAktuell;
            faktor=100+faktor;
            if(ZeitAktuell>=zuletzt_aufgerufen+faktor){
                laserSchießen();
            }
            else {
                for(int i=0;i< todesBereich.length;i++){
                    for(int j=0;j< todesBereich[0].length;j++){
                        todesBereich[i][j]=false;
                    }
                }
            }
        }
        private void laserSchießen(){
            int grenze=(int)faktor;
            for(int i=0;i<grenze;i++){
                int OneORTwo= getRandomNumberInRange(0,1);
                if(OneORTwo<0){
                    int Xshot=getRandomNumberInRange(0,spielfeld.length-1);
                    for(int j=0;j<spielfeld[0].length;j++){
                        spielfeld[Xshot][j]='L';
                        todesBereich[Xshot][j]=true;
                    }
                }
                else{
                    int Yshot=getRandomNumberInRange(0,spielfeld[0].length-1);
                    for(int j=0;j<spielfeld.length;j++){
                        spielfeld[j][Yshot]='L';
                        todesBereich[j][Yshot]=true;

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
}
