public class PunkteSystem {
    private long punkte;
    public PunkteSystem(){
        punkte=0;
    }
    public void changePoints(int Zeit){
        punkte=Zeit/100;
    }
    public long getPunkte(){
        return punkte;
    }
}
