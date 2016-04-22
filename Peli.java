package rahapeliSimulaattori;
import java.util.Random;
import java.util.Scanner;

public class Peli {
    
    private double panos, voitot;
    public static Random arpa = new Random();
    public static Scanner lukija = new Scanner(System.in);
    
    public void setPanos(double panos) {
        this.panos = panos;
    }
    public void setVoitot(double voitot) {
        this.voitot = voitot;
    }
    public double getPanos() {
        return panos;
    }
    public double getVoitot() {
        return voitot;
    }
    
    public static double tuplaus(double voitto) {
    
        int arvo = arpa.nextInt(2);
        if (arvo < 1) {
            return 0;
        } else {
            return (voitto * 2);
        }
    }
}
