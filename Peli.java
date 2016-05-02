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
    public boolean jatkaminen() {
    
        System.out.println("Haluatko jatkaa? (k/e)");
        System.out.print("> ");
        switch ( lukija.next().charAt(0) ) {
            case 'k': case 'K':
                return true;
            default:
                break;
        }
        return false;
    }
    public static double tuplausCheck(double voitto) {
    
        if (voitto > 0) {
            System.out.println("Haluatko tuplata? (k/e)");
            System.out.print("> ");
            while ( lukija.next().charAt(0) == 'k' && voitto > 0) {
                voitto = tuplaus(voitto);
                System.out.println("voittosi: " + voitto);
                if (voitto > 0) {
                    System.out.println("Haluatko jatkaa tuplaamista?");
                    System.out.print("> ");
                } else {
                    return voitto;
                }
            }
            return voitto;
        } else {
            return voitto;
        }     
    }
    private static double tuplaus(double rahaMaara) {
    
        int arvo = arpa.nextInt(2);
        if (arvo < 1) {
            System.out.println("Tuplaus epäonnistui!");
            return 0;
        } else {
            System.out.println("Tuplaus onnistui!");
            return (rahaMaara * 2);
        }
    }
}
