package rahapeliSimulaattori;

import java.util.Scanner;

/*  
Simulaation alustus ja eteneminen tapahtuu tässä pääluokassa.
Luokka myös luo simulaatiolle oleelliset oliot ja huolehtii olioiden
päivityksestä.
=======================
Tuomas Ravander 2016 
=======================
*/
public class Pelisimulaattori {

    /* PRIVATE-MUUTTUJAT */
    private static Scanner lukija = new Scanner(System.in);
    private static Pelaaja pelaaja;
    private static Tahti tahti;
    private static Ventti ventti;
    private static Keno keno;
    
    public static void main(String[] args) {
      
        String valinta;
        alusta();
        
        /* Simulaation perusluuppi */
        do {
            valinta = valitsePeli(); 
            pelaaja.setRahaMaara( pelaa(valinta) );
        } while (valinta != "lopeta");          
    }
    
    private static void alusta() {
        
        tahti = new Tahti();
        ventti = new Ventti();
        keno = new Keno();
        
        System.out.println("Tervetuloa Hyväntahdon Peleihin!");
        System.out.println("===============================");
        
        luoPelaaja();
    }
    
    private static void luoPelaaja() {
    
        System.out.println("Hei! Kuka olet?");
        System.out.print("> Olen ");
        String nimi = Peli.syotaString();
        
        System.out.println("Kuinka vanha olet?");
        System.out.print("> Olen ");
        int ika = Peli.syotaInt();
        if (ika < 18) {
            System.out.println("Olet liian nuori pelaamaan...");
            System.out.println("...Mutta olkoon menneeksi!");
        }
        
        System.out.println("Paljonko haluat syytää rahaa?");
        System.out.print("> Sijoitan ");
        double rahaMaara = Peli.syotaDbl();
        
        System.out.println();
        
        pelaaja = new Pelaaja(rahaMaara, nimi, ika);
    }
    
    /*
    Palauttaa String-muuttujana halutun toimenpiteen nimen, jonka
    pelaa-metodi osaa lukea.
    */
    private static String valitsePeli() {
    
        System.out.println();
        System.out.println(" RAY-SKA Rahapelisimulaattori");
        System.out.println("=============================");
        System.out.print(" " + pelaaja.getNimi() + 
            "\t\t" + pelaaja.getRahaMaara() + "0 €\n" );
        System.out.println("=============================");
        System.out.println(" 0: LOPETA");
        System.out.println(" 1: TÄHTI");
        System.out.println(" 2: VENTTI"); 
        System.out.println(" 3: KENO"); 
        System.out.println(" 4: INFO");
		System.out.println(" 5: TALLETUS");
        System.out.println("=============================");
        System.out.print(" > ");
        
        int valinta;
        String peliValinta = "";       
        valinta = Peli.syotaInt();
        
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
			case 5:
				peliValinta = "talletus";
				break;
            default:
                peliValinta = "lopeta";
                break;
        }
        return peliValinta;
    }
	
	private static double kysyPanos() {
		
		System.out.println("Aseta panos");
		System.out.print("> ");
		double panos = Peli.syotaDbl();
		return panos;
	}
	
	private static double lisaaRahaa(Pelaaja p) {
		
		System.out.println("Paljonko haluat syytää rahaa?");
		System.out.print("> ");
		
		double maara = Peli.syotaDbl();
		maara += p.getRahaMaara();
		
		return maara;
	}
    
    /*
    pelaa-metodi kutsuu Peli-luokan alaluokkien pelaa-metodia, joka palauttaa
    pelin jälkeisen rahamäärän saldo-muuttujaan, josta main-funktio hoitaa
    tietojen päivityksen pelaaja-oliolle.
    */
    private static double pelaa(String peli) {
    
        double panos, saldo = pelaaja.getRahaMaara();
        
        switch (peli) {
        
            case "tahti":
                panos = kysyPanos();
                saldo = tahti.pelaa( pelaaja.getRahaMaara(), panos );
                break;
            case "ventti":
                panos = kysyPanos();
                saldo = ventti.pelaa( pelaaja.getRahaMaara(), panos );
                break;
            case "keno":
                panos = kysyPanos();
                saldo = keno.pelaa( pelaaja.getRahaMaara(), panos );
                break;
            case "info":
                System.out.print("\nINFO\n");
                System.out.println(pelaaja);
                System.out.println();
                break;
			case "talletus":
                System.out.print("\nRAHAN TALLETUS\n");
                saldo = lisaaRahaa(pelaaja);
                System.out.println();
                break;
            default:
                System.out.println("Kiitos pelaamisesta!");
                break;
        }
        return saldo;
    }
}
