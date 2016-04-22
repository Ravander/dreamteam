package rahapeliSimulaattori;
import java.util.Random;

public class Tahti {

    private char[] merkit = { 'a', 'b', 'c', 'd', '*' };
    private int[] lukitut = { 0, 0, 0 };
    
    public int[] getLukitut() {
        return lukitut;
    }
    
    private char arvoMerkki() { 
      
        Random arpa = new Random();
        int arvo = arpa.nextInt(5);           
        return merkit[arvo];    
    }
    
    public String arvoRivi(char[] riviLista, int[] lukitusLista) {
    
        String tulosRivi = "";
        for ( int i = 0; i < 3; i++ ) {
            if (lukitusLista[i] == 0) {
                riviLista[i] = arvoMerkki();
            }
            tulosRivi += riviLista[i];
        }
        
        return tulosRivi;
    }
    
    public void lukitse(int[] lukot) {
        
        for ( int i = 0; i < 3; i++ ) {
            lukitut[i] = lukot[i];
        }
    }
}
    
