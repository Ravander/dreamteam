package rahapeliSimulaattori;
import java.util.Arrays;
import java.util.ArrayList;

public class Ventti {
    ArrayList pakka = new ArrayList();
    
    public void alustaPakka() {
        //this.pakka=pakka;
        pakka.clear();

    }
    public void taytaPakka() {
        for (int i=2; i<=14; i++) {
            for (int j=1; j<=4; j++) {
                pakka.add(i);
            }
        }
    }
}