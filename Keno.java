package rahapeliSimulaattori;

import java.util.ArrayList;
import java.util.Collections;

public class Keno extends Peli {

    private ArrayList<Integer> arvotutNumerot = new ArrayList();
    private ArrayList<Integer> pelaajanNumerot = new ArrayList();
    private int annetutNumerot = 0, osumat = 0;
    private final int[] voitto = {5, 0, 0, 1, 2, 4, 8, 16, 32};

    private void valitseNumerot() {
        /*valitaan 9 numeroa väliltä 1-40*/
        System.out.println("KENO");
        System.out.println("Pelaaja valitsee yhdeksän numeroa väliltä 1-40. \n" +
			"Sen jälkeen kone arpoo yhdeksän numeroa samalta väliltä." + 
			"\nOsumien summa määrää voiton suuruuden");
        do {
            System.out.println();
            System.out.print("Valitse numero väliltä 1-40: ");
			int luku = syotaInt();
			
            if (luku <= 0 || luku > 40) {
                System.out.println("Antamasi numero ei kelpaa");
			/*Tarkistetaan ettei numero ole jo valittuna. Jos ei ole lisätään
			luku valittuihin lukuihin*/
            }
			else {
                if (pelaajanNumerot.size() == 0) {
                    pelaajanNumerot.add(luku);
                    annetutNumerot++;
                } else if (pelaajanNumerot.contains(luku)) {
                    System.out.println("Kyseinen numero on jo valittu");
                } else {
                    pelaajanNumerot.add(luku);
                    annetutNumerot++;

                }
            }
            /*Tulostetaan valitut numerot*/
            System.out.println();
            System.out.println("Numeroita valittu " + annetutNumerot + "kpl");
            System.out.print("Valitut numerot: ");
            Collections.sort(pelaajanNumerot);
            for (int i = 0; i <= pelaajanNumerot.size() - 1; i++) {
                System.out.print(pelaajanNumerot.get(i) + " ");
            }
            if (annetutNumerot == 9) {
                System.out.println();
                System.out.println("Antamasi numerot: ");
				tulostaPelaajanNumerot();
                System.out.println();
                System.out.println("Jatketaanko näillä numeroilla? k/e");
                char valinta = syotaChar();
                if (valinta == 'e') {
					alustus();
                }
            }
        } while (annetutNumerot < 9);
    }

    private void arvoNumerot() {
        /*Arvottujen numeroiden määrä*/
        int Numerot = 0;
        /*Arvotaan 9 numeroa väliltä 1-40*/
        do {
            int luku = (arpa.nextInt(39) + 1);
            /*Tarkistetaan ettei numero ole jo arvottu*/
            if (!arvotutNumerot.contains(luku)) {
                arvotutNumerot.add(luku);
                Numerot++;
            }
        } while (Numerot < 10);
        System.out.println("Arvotut numerot: ");
        Collections.sort(arvotutNumerot);
        for (int i = 0; i <= 8; i++) {
            System.out.print(arvotutNumerot.get(i) + " ");
        }
    }

    private void osumienTarkistus() {
        for (int i = 0; i < 9; i++) {
            if (arvotutNumerot.contains(pelaajanNumerot.get(i))) {
                osumat++;
            }
        }
		System.out.println();
        System.out.println("Osumia: " + osumat);

    }

    private int voitto() {
        int voittoKerroin = voitto[getOsumat()];
        return voittoKerroin;
    }

    private int getOsumat() {
        return osumat;
    }

    private int getAnnetutNumerot() {
        return annetutNumerot;
    }
	
	private void tulostaPelaajanNumerot() {
		for (int i = 0; i <= 8; i++) {
            System.out.print(pelaajanNumerot.get(i) + " ");
        }
	}
    
    public double pelaa(double rahaMaara, double panos){
		boolean pelaa = true;
		while (pelaa && rahaMaara >= panos){
			rahaMaara = rahaMaara - panos;
			valitseNumerot();
			arvoNumerot();
			System.out.println();
			System.out.println("Sinun numerosi: ");
			tulostaPelaajanNumerot();
			osumienTarkistus();
			System.out.println("Voitit: " + panos * voitto());
			double voitto = tuplausCheck(panos * voitto());
			rahaMaara += panos * voitto;
			System.out.println("Rahaa jäljellä: " + rahaMaara);
			alustus();
			pelaa = jatkaminen();
		}
		return (rahaMaara);
	}
	
	private void alustus(){
		annetutNumerot = 0;
		osumat = 0;
		pelaajanNumerot.clear();
		arvotutNumerot.clear();
	}
	
}
