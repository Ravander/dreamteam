package rahapeliSimulaattori;
public class VenttiTesti {
    


public static void main(String[] args) {
    Ventti testiVentti = new Ventti();
    testiVentti.alustaPakka();
    testiVentti.taytaPakka();
    System.out.println("Testi!");
    for (int i=0; i<=testiVentti.pakka.size()-1; i++) {
        System.out.println(testiVentti.pakka.get(i));
        }
    System.out.println("testi");
    testiVentti.jakajanKasi();
    }
}
