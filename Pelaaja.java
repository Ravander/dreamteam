package rahapeliSimulaattori;

/*
Pelaaja-luokkaan tallennetaan käyttäjän, eli pelaajan tärkeimmät tiedot.
*/
public class Pelaaja {
    
    /* PRIVATE-MUUTTUJAT */
    private double rahaMaara;
    private String nimi;
    private int ika;

    /* CONSTRUCTORIT */
    public Pelaaja() {
        this(0.00, "nimeton", 0);
    }
    public Pelaaja(double rahaMaara, String nimi, int ika) {
        this.rahaMaara = rahaMaara;
        this.nimi = nimi;
        this.ika = ika;
    }

    /* GET / SET */
    public double getRahaMaara() {
        return rahaMaara;
    }
    public void setRahaMaara(double rahaMaara) {
        this.rahaMaara = rahaMaara;
    }
    public String getNimi() {
        return nimi;
    }
    public void setNimi(String nimi) {
		this.nimi = nimi;
    }
    public int getIka() {
        return ika;
    }
    public void setIka(int ika) {
		this.ika = ika;
    }
    
    public String toString() {
        String teksti = "Pelaajan nimi: " + nimi + 
            ", ikä: " + ika + ", saldo: " + rahaMaara + "0 €";
        return teksti;
    }
       
}
