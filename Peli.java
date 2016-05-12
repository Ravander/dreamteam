package rahapeliSimulaattori;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/*
Peli-luokka simulaatioon implementoitavien pelien pohjaksi. Helpottaa
huomattavasti pelien luontia sekä simulaattorin, pelien ja pelaajan välistä
yhteistyötä.
=======================
Tuomas Ravander 2016 
=======================
*/
public class Peli {

    /* PRIVATE-MUUTTUJAT */    
    private double panos, voitot;
    
    /* PUBLIC-MUUTTUJAT */
    public static Random arpa = new Random();
    public static Scanner lukija = new Scanner(System.in);
    
    /* GET / SET */
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
    
    protected boolean jatkaminen() {
    
        System.out.println("Haluatko jatkaa? (k/e)");
        System.out.print("> ");
        char valinta = syotaChar();
		if (valinta == 'k') {
			return true;
		} else {
			return false;
		}
    }
    protected double tuplausCheck(double voitto) {
    
        if (voitto > 0) {
            System.out.println("Haluatko tuplata? (k/e)");
            System.out.print("> ");
            while ( syotaChar() == 'k' && voitto > 0) {
                voitto = tuplaus(voitto);
                System.out.println("voittosi: " + voitto + "0 €");
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
    private double tuplaus(double rahaMaara) {
    
        int arvo = arpa.nextInt(2);
        if (arvo < 1) {
            System.out.println("Tuplaus epäonnistui!");
            return 0;
        } else {
            System.out.println("Tuplaus onnistui!");
            return (rahaMaara * 2);
        }
    }
	
	/*
	Error-handling
	================
	Yksityiskohtaisempi tarkastelu käyttäjän syötteisiin.
	*/
	
	public static int syotaInt() {
		boolean onkoNumero = false;
		int luku = 0;
		while (!onkoNumero){
			try {
				luku = lukija.nextInt();
				luku = Math.abs(luku);
				onkoNumero = true;
			}
			catch(InputMismatchException e) {
				lukija.nextLine();
				System.out.println("Syöttämäsi merkki ei ole numero.");
				System.out.print("Anna uusi numero: ");
			}
		}
		return luku;
	}
	public static double syotaDbl() {
		boolean onkoNumero = false;
		double luku = 0.00;
		while (!onkoNumero){
			try {
				luku = lukija.nextDouble();
				luku = Math.abs(luku);
				onkoNumero = true;
			}
			catch(InputMismatchException e) {
				lukija.nextLine();
				System.out.println("Syöttämäsi merkki ei ole numero.");
				System.out.print("Anna uusi numero: ");
			}
		}
		return luku;
	}
	public static String syotaString() {
		boolean onkoTeksti = false;
		String teksti = "";
		while (!onkoTeksti){
			try {
				teksti = lukija.next();
				onkoTeksti = true;
			}
			catch(InputMismatchException e) {
				lukija.nextLine();
				System.out.println("Syötteesti ei ole merkkijono.");
				System.out.print("Yritä uudestaan: ");
			}
		}
		return teksti;
	}
	public static char syotaChar() {
		boolean onkoMerkki = false;
		char merkki = 'o';
		String apu = "";
		do {
			apu = syotaString().toLowerCase();
			merkki = apu.charAt(0);
			if (merkki == 'k' || merkki == 'e') {
				onkoMerkki = true;
			} else {
				System.out.println("Syötteesi oli virheellinen!");
				System.out.println("Syöttäisitkö merkin uudestaan?");
				System.out.print("> ");
			}
		} while (onkoMerkki == false);
		return merkki;
	}
}
