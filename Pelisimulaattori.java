package rahapeliSimulaattori;
import java.util.Scanner;

public class Pelisimulaattori {

    private static Scanner lukija = new Scanner(System.in);
    private static Pelaaja pelaaja;
    private static Tahti tahti;
    private static Ventti ventti;
    private static Keno keno;
    
    public static void main(String[] args) {
    
        String valinta;
        alusta();
        do {
            valinta = valitsePeli(); 
            pelaaja.setRahaMaara( pelaa(valinta) );
        } while (valinta != "lopeta");          
    }
    
    public static void alusta() {
        
        tahti = new Tahti();
        ventti = new Ventti();
        keno = new Keno();
        
        System.out.println("Tervetuloa hyväntahdonpeleihin!");
        System.out.println("===============================");
        
        luoPelaaja();
    }
    
    public static void luoPelaaja() {
    
        System.out.println("Hei! Kuka olet?");
        System.out.print("Olen ");
        String nimi = lukija.nextLine();
        
        System.out.println("Kuinka vanha olet?");
        System.out.print("Olen ");
        int ika = lukija.nextInt();
        
        System.out.println("Paljonko haluat syytää rahaa?");
        System.out.print("Sijoitan ");
        double rahaMaara = lukija.nextDouble();
        
        pelaaja = new Pelaaja(rahaMaara, nimi, ika);
    }
    
    public static String valitsePeli() {
    
        System.out.println("Valitse peli");
        System.out.println("1: Tähti, 2: Ventti, 3: Keno");
        System.out.print("> ");
        int valinta;
        String peliValinta = "";
        
        valinta = lukija.nextInt();
        switch (valinta) {
    
            case 1:
                peliValinta = "tahti";
                break;
            case 2:
                peliValinta = "ventti";
                break;
            case 3:
                peliValinta = "keno";
                break;
            default:
                peliValinta = "lopeta";
                break;
        }
        return peliValinta;
    }
    
    public static double pelaa(String peli) {
    
        double saldo = pelaaja.getRahaMaara();
        
        switch (peli) {
        
            case "tahti":
                saldo = tahti.pelaa( pelaaja.getRahaMaara(), 0.50 );
                break;
            case "ventti":
                saldo = ventti.pelaa( pelaaja.getRahaMaara(), 0.50 );
                break;
            case "keno":
                saldo = keno.pelaa( pelaaja.getRahaMaara(), 0.50 );
                break;
            default:
                System.out.println("Kiitos pelaamisesta!");
                break;
        }
        return saldo;
    }
}
