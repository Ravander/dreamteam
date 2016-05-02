package rahapeliSimulaattori;

public class Pelaaja {
    
    private double rahaMaara;
    private String nimi;
    private int ika;

    public Pelaaja() {
        this(0.00, "nimeton", 0);
    }
    public Pelaaja(double rahaMaara, String nimi, int ika) {
        this.rahaMaara = rahaMaara;
        this.nimi = nimi;
        this.ika = ika;
    }

    public double getRahaMaara() {
        return rahaMaara;
    }

    public void setRahaMaara(double rahaMaara) {
        if (rahaMaara >= 0) {
            this.rahaMaara = rahaMaara;
        } else {
            System.out.println("Virhe 666");
            this.rahaMaara = 0.00;
        }
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        if (nimi.length() < 1 || nimi.length() > 15) {
            System.out.println("Virhe 666");
            this.nimi = "nimeton";
        } else {
            this.nimi = nimi;
        }
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        if (ika >= 18) {
            this.ika = ika;
        } else {
            System.out.println("Olet liian nuori pelaamaan...");
            System.out.println("..Mutta olkoon menneeksi.");
        }
    }
    public String toString() {
        String teksti = "Pelaajan nimi: " + nimi + 
            ", ikä: " + ika + ", saldo: " + rahaMaara + "0 €";
        return teksti;
    }
       
}
