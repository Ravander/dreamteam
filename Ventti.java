package rahapeliSimulaattori;
import java.util.Arrays;
import java.util.ArrayList;

public class Ventti extends Peli {
    ArrayList pakka = new ArrayList();
    ArrayList<Integer> jakajanKortit = new ArrayList<>();
    ArrayList pelaajanKortit = new ArrayList();
    
    public void alustaPakka() {
        pakka.clear();

    }
    public void taytaPakka() { //Täyttää pakan "korteilla" 2-14
        for (int i=2; i<=14; i++) {
            for (int j=1; j<=4; j++) {
                pakka.add(i);
            }
        }
    }
    public int kadenArvo(ArrayList<Integer> kasi) {
        int arvo = 0;
        for (Integer lisays : kasi) {
            arvo += lisays;
        }
        return arvo;
    }
    public ArrayList<Integer> jakajanKasi() {
        int jakajanArvo = 0;
        do {
            jakajanKortit.add((arpa.nextInt(13)+1));
            jakajanArvo = kadenArvo(jakajanKortit);
            System.out.println("Jakajan arvo: "+jakajanArvo);
        } while (jakajanArvo <= 17);
        return jakajanKortit;
    }
}