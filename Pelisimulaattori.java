package rahapeliSimulaattori;
import javax.swing.*;

public class Pelisimulaattori {
    public static void main(String[] args) {
        alusta();     
    }
    public static void alusta() {
        
        JFrame ikkuna = new JFrame("Rahapelisimulaattori");
        ikkuna.setSize(700, 500);
        ikkuna.setVisible(true);
        
        Pelaaja pelaaja1 = new Pelaaja(100.00, "RajaJonppe", 299);
    }
}
