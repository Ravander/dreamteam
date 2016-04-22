package rahapeliSimulaattori;

public class TahtiTesti {

    public static void main(String[] args) {
    
        Tahti tahtipeli = new Tahti();
        
        char[] rivi = { 'o', 'o', 'o' };
        int[] lukot = tahtipeli.getLukitut();
        String xx = tahtipeli.arvoRivi(rivi, lukot);
        System.out.println( xx );
        int[] lukkoLista = { 1, 0, 1 };
        tahtipeli.lukitse(lukkoLista);
        xx = tahtipeli.arvoRivi(rivi, lukot);
        System.out.println( xx );
    }

}
