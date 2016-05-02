package rahapeliSimulaattori;

import java.util.ArrayList;
import java.util.Collections;

public class Keno extends Peli {

    private ArrayList<Integer> arvotutNumerot = new ArrayList();
    private ArrayList<Integer> pelaajanNumerot = new ArrayList();
    private int annetutNumerot = 0, osumat = 0;
    private final int[] voitto = {4, 0, 0, 0, 1, 2, 3, 4, 10};

    public void valitseNumerot() {
        /*valitaan 9 numeroa väliltä 1-40*/
        System.out.println("KENO");
        System.out.println("Pelaaja valitsee yhdeksän numeroa väliltä 1-40. \nSen jälkeen kone arpoo yhdeksän numeroa samalta väliltä. \nOsumien summa määrää voiton suuruuden");
        do {
            System.out.println();
            System.out.print("Valitse numero väliltä 1-40: ");
            int luku = lukija.nextInt();
            /*Tarkistetaan että numero sopii peliin*/
            if (luku <= 0 || luku > 40) {
                System.out.println("Antamasi numero ei kelpaa");
			/*Tarkistetaan ettei numero ole jo valittuna. Jos ei ole lisätään luku valittuihin lukuihin*/
            } else {
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
                for (int i = 0; i <= 8; i++) {
                    System.out.print(pelaajanNumerot.get(i) + " ");
                }
                System.out.println();
                System.out.println("Jatketaanko näillä numeroilla? k/e");
                char valinta = lukija.next().charAt(0);
                if (valinta == 'e') {
					alustus();
                }
            }
        } while (annetutNumerot < 9);
    }

    public void arvoNumerot() {
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

    public void osumienTarkistus() {
        for (int i = 0; i < 9; i++) {
            if (arvotutNumerot.contains(pelaajanNumerot.get(i))) {
                osumat++;
            }
        }
        System.out.println("Osumia: " + osumat);

    }

    public int voitto() {
        int voittoKerroin = voitto[getOsumat()];
        return voittoKerroin;
    }

    public int getOsumat() {
        return osumat;
    }

    public int getAnnetutNumerot() {
        return annetutNumerot;
    }
    
    public double pelaa(double rahaMaara, double panos){
		boolean pelaa = true;
		while (pelaa && rahaMaara>panos){
			rahaMaara = rahaMaara-panos;
			valitseNumerot();
			arvoNumerot();
			osumienTarkistus();
			System.out.println("Voitit: " + panos*voitto());
			alustus();
			pelaa = jatkaminen();	
		}
		return (rahaMaara+panos*voitto());
	}
	
	public void alustus(){
		annetutNumerot = 0;
		osumat = 0;
		pelaajanNumerot.clear();
		arvotutNumerot.clear();
	}
	
}
