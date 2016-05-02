package rahapeliSimulaattori;
import java.util.Arrays;
import java.util.ArrayList;

public class Ventti extends Peli {
    ArrayList<Integer> pakka = new ArrayList<>();
    ArrayList<Integer> jakajanKortit = new ArrayList<>();
    ArrayList<Integer> pelaajanKortit = new ArrayList<>();
    
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
    public int jako() {
        int jaetunIndeksi = (arpa.nextInt((pakka.size()-1)));
        int jaettavaKortti = pakka.get(jaetunIndeksi);
        pakka.remove(jaetunIndeksi);
        return jaettavaKortti;
    }
    public ArrayList<Integer> jakajanKasi() {
        int jakajanArvo = 0;
        int jaettuKortti;
        do {
            jaettuKortti = jako();
            jakajanKortit.add(jaettuKortti);
            jakajanArvo = kadenArvo(jakajanKortit);
            System.out.println("Jakaja sai kortin "+jaettuKortti);
            System.out.println("Jakajan arvo: "+jakajanArvo);
            if (jakajanArvo > 21 && jakajanKortit.contains(14)) {
                jakajanKortit = assanVaihto(jakajanKortit);
                jakajanArvo = kadenArvo(jakajanKortit);
                System.out.println("Ässät vaihdettu ykkösiksi, jakajalla on nyt kortit: ");
                for (int i=0; i<=jakajanKortit.size()-1; i++) {
                    System.out.println(jakajanKortit.get(i));
                }
                System.out.println("Jakajan arvo: "+jakajanArvo);
            }
        } while (jakajanArvo <= 17);
        return jakajanKortit;
    }
    public ArrayList<Integer> pelaajanKasi() {
        int pelaajanArvo = 0;
        int jaettuKortti;
        char jatketaan;
        do {
            jaettuKortti = jako();
            pelaajanKortit.add(jaettuKortti);
            pelaajanArvo = kadenArvo(pelaajanKortit);
            System.out.println("Sait kortin "+jaettuKortti+", kätesi arvo on nyt "+pelaajanArvo);
            if (pelaajanArvo > 21) {
                if (pelaajanKortit.contains(14)) {
                    pelaajanKortit = assanVaihto(pelaajanKortit);
                    pelaajanArvo = kadenArvo(pelaajanKortit);
                    System.out.println("Ässät vaihdettu");
                }
                else {
                    System.out.println("Käden arvo on yli 21!");
                    break;
                }
            }
            System.out.print("Haluatko jatkaa (k/e): ");
            jatketaan = lukija.next().charAt(0);
        } while (pelaajanArvo <= 21 && jatketaan !='e');
        return pelaajanKortit;
    }
    public ArrayList<Integer> assanVaihto(ArrayList<Integer> vaihdettavatKortit) {
        for (int i=0; i<=vaihdettavatKortit.size()-1; i++) {
            if (vaihdettavatKortit.get(i) == 14) {
                vaihdettavatKortit.set(i,1);
            }
        }
        return vaihdettavatKortit;
    }
    public String kukaVoitti(ArrayList<Integer> pelaajanKortit, ArrayList<Integer> jakajanKortit) {
        int pelaajanArvo = kadenArvo(pelaajanKortit);
        int jakajanArvo = kadenArvo(jakajanKortit);
        if (pelaajanArvo > 21 & jakajanArvo > 21) {
            System.out.println("Jakaja voitti!");
            return "jakaja"
        }
        else if (pelaajanArvo > jakajanArvo & pelaajanArvo <= 21 | jakajanArvo > 21) {
            System.out.println("Voitit jakajan!");
            return "pelaaja"
        }
        else if (pelaajanArvo > 21 | jakajanArvo > pelaajanArvo) {
            System.out.println("Jakaja voitti!");
            return "jakaja"
        }
        else {
            System.out.println("Tasapeli!");
            return "tasapeli"
        }
    }
    public double pelaa(double rahaMaara double panos) {
        char jatkuu;
        do {
            kukaVoitti(pelaajanKasi(),jakajanKasi());
            //jakajanKasi();
            //pelaajanKasi();
            System.out.print("Jatketaanko (k/e)? ");
            lukija.next().charAt(0)
        }
    }
}