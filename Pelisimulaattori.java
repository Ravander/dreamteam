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
        
        System.out.println("Tervetuloa Hyväntahdon Peleihin!");
        System.out.println("===============================");
        
        luoPelaaja();
    }
    
    public static void luoPelaaja() {
    
        System.out.println("Hei! Kuka olet?");
        System.out.print("> Olen ");
        String nimi = lukija.nextLine();
        
        System.out.println("Kuinka vanha olet?");
        System.out.print("> Olen ");
        int ika = lukija.nextInt();
        if (ika < 18) {
            System.out.println("Olet liian nuori pelaamaan...");
            System.out.println("...Mutta olkoon menneeksi!");
        }
        
        System.out.println("Paljonko haluat syytää rahaa?");
        System.out.print("> Sijoitan ");
        double rahaMaara = lukija.nextDouble();
        
        System.out.println();
        
        pelaaja = new Pelaaja(rahaMaara, nimi, ika);
    }
    
    public static String valitsePeli() {
    
        System.out.println();
        System.out.println("RAY-SKA Rahapelisimulaattori");
        System.out.println("============================");
        System.out.print(" " + pelaaja.getNimi() + "\t\t" + pelaaja.getRahaMaara() + "0 €\n" );
        System.out.println("============================");
        System.out.println("0: LOPETA");
        System.out.println("1: TÄHTI");
        System.out.println("2: VENTTI"); 
        System.out.println("3: KENO"); 
        System.out.println("4: INFO");
        System.out.println("============================");
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
            case 4:
                peliValinta = "info";
                break;
            default:
                peliValinta = "lopeta";
                break;
        }
        return peliValinta;
    }
    
    public static double pelaa(String peli) {
    
        double panos, saldo = pelaaja.getRahaMaara();
        
        switch (peli) {
        
            case "tahti":
                System.out.println("Aseta panos");
                System.out.print("> ");
                panos = lukija.nextDouble();
                saldo = tahti.pelaa( pelaaja.getRahaMaara(), panos );
                break;
            case "ventti":
                System.out.println("Aseta panos");
                System.out.print("> ");
                panos = lukija.nextDouble();
                saldo = ventti.pelaa( pelaaja.getRahaMaara(), panos );
                break;
            case "keno":
                System.out.println("Aseta panos");
                System.out.print("> ");
                panos = lukija.nextDouble();
                saldo = keno.pelaa( pelaaja.getRahaMaara(), panos );
                break;
            case "info":
                System.out.print("\nINFO\n");
                System.out.println(pelaaja);
                System.out.println();
                break;
            default:
                System.out.println("Kiitos pelaamisesta!");
                break;
        }
        return saldo;
    }
}
