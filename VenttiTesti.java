package rahapeliSimulaattori;
import java.util.ArrayList;
public class VenttiTesti {
    


public static void main(String[] args) {
    Ventti testiVentti = new Ventti();
    ArrayList<Integer>jakajanLopullisetKortit = new ArrayList<Integer>();
    ArrayList<Integer>pelaajanLopullisetKortit = new ArrayList<Integer>();
    testiVentti.alustaPakka();
    testiVentti.taytaPakka();
    /*System.out.println("Testi!");
    for (int i=0; i<=testiVentti.pakka.size()-1; i++) {
        System.out.println(testiVentti.pakka.get(i));
        }
    System.out.println("testi");*/
    jakajanLopullisetKortit = testiVentti.jakajanKasi();
    pelaajanLopullisetKortit = testiVentti.pelaajanKasi();
    int jakajanArvo = testiVentti.kadenArvo(jakajanLopullisetKortit);
    int pelaajanArvo = testiVentti.kadenArvo(pelaajanLopullisetKortit);
    
    if (pelaajanArvo > 21 & jakajanArvo > 21) {
        System.out.println("Jakaja voitti!");   
    }
    else if (pelaajanArvo > jakajanArvo & pelaajanArvo <= 21 | jakajanArvo > 21) {
        System.out.println("Voitit jakajan!");
    }
    else if (pelaajanArvo > 21 | jakajanArvo > pelaajanArvo) {
        System.out.println("Jakaja voitti!");
    }
    else {
        System.out.println("Tasapeli!");
    }
    /*System.out.println("Pakassa jäljellä:");
    for (int i=0; i<=testiVentti.pakka.size()-1; i++) {
        System.out.println(testiVentti.pakka.get(i));
    }*/
    }
}
