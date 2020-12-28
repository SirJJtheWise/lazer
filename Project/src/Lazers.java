import java.util.Random;

public class Lazers { char [][] spielfeld;long zuletzt_aufgerufen;long faktor;
                        boolean todesBereich[][];

        public Lazers(char[][] s,int schwierigkeit){
            spielfeld=s;
            zuletzt_aufgerufen=0;

            todesBereich =new boolean[spielfeld.length][spielfeld[0].length];
        }


        public void activateLazers(long ZeitAktuell){
            faktor=ZeitAktuell;
            faktor=100+faktor;
            if(ZeitAktuell>=zuletzt_aufgerufen+faktor){
                laserSchießen();
            }

        }
        private void laserSchießen(){
            int grenze=(int)faktor;
            for(int i=0;i<grenze;i++){
                int OneORTwo= getRandomNumberInRange(0,1);
                if(OneORTwo<0){
                    int Xshot=getRandomNumberInRange(0,spielfeld.length-1);
                    for(int j=0;j<spielfeld[0].length;j++){
                        spielfeld[Xshot][j]='V';
                        todesBereich[Xshot][j]=true;
                    }
                }
                else{
                    int Yshot=getRandomNumberInRange(0,spielfeld[0].length-1);
                    for(int j=0;j<spielfeld.length;j++){
                        spielfeld[j][Yshot]='H';
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
    public boolean isInDeath(int x,int y){
            if(todesBereich[x][y]==true){
            return true;
            }
            else return false;
    }
    public void deletlazers(){

            for(int i=0;i< todesBereich.length;i++){
                for(int j=0;j< todesBereich[0].length;j++){
                    todesBereich[i][j]=false;
                    if(spielfeld[i][j]=='V'||spielfeld[i][j]=='H'){
                        spielfeld[i][j]=' ';
                    }
                }
            }
        }

}
