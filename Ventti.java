package Rahapelisimulaattori;
import java.util.Arrays;
import java.util.ArrayList;

public class Ventti {
    private ArrayList<int> pakka = new ArrayList();
    
    public static void alustaPakka(ArrayList<int> pakka) {
        this.pakka=pakka;
        pakka.clear();

    }
    public static void taytaPakka(ArrayList<int> pakka) {
        for (int i=2; i++; i<=14;) {
            for (int j=0; j++; j<=4;) {
                pakka.add(i);
            }
        }
    }
}