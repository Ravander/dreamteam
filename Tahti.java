package rahapeliSimulaattori;

public class Tahti extends Peli {

    private char[] merkit = { 'a', 'b', 'c', 'd', '*' };
    private int[] lukitut = { 0, 0, 0 };
    
    public int[] getLukitut() { return lukitut; }
    public void setLukitut(int[] lukitut) {
        this.lukitut = lukitut;
    }
    
    private char arvoMerkki() { 
      
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
    
    public void lukitse() {
    
        int[] lukot = new int[3];
        System.out.println("Valitse lukitukset");
        for (int i = 0; i < 3; i++) {
            System.out.print("> ");
            lukot[i] = lukija.nextInt();
        }
        setLukitut(lukot);
    }
    
    public void resetLukot() {
        int[] nollaus = { 0, 0, 0 };
        setLukitut(nollaus);
    }
    
    public double tarkistaVoitto(String rivi, double panos) {
    
        double voitto = 0;
        switch (rivi) {
            
            case "*ab": case "*ac": case "*ad": 
            case "*ba": case "*bc": case "*bd": 
            case "*ca": case "*cb": case "*cd": 
            case "*da": case "*db": case "*dc":
            case "ab*": case "ac*": case "ad*": 
            case "ba*": case "bc*": case "bd*": 
            case "ca*": case "cb*": case "cd*": 
            case "da*": case "db*": case "dc*":
                voitto = panos * 2;
                break;
            case "aaa": case "*aa": case "a*a": case "aa*":
            case "a**": case "**a": case "*a*":
                voitto = panos * 3;
                break;
            case "bbb": case "*bb": case "b*b": case "bb*":
            case "b**": case "**b": case "*b*":
                voitto = panos * 5;
                break;
            case "ccc": case "*cc": case "c*c": case "cc*":
            case "c**": case "**c": case "*c*":
                voitto = panos * 10;
                break;
            case "ddd": case "*dd": case "d*d": case "dd*":
            case "d**": case "**d": case "*d*":
                voitto = panos * 15;
                break;
            case "***":
                voitto = panos * 20;
                break;
            default:
                voitto -= panos;
                break;
        }
        return voitto;
    }
    
    public double pelaa(double rahaMaara, double panos) {
        
        String rivi = "ooo";
        boolean pelaa = true;
        
        while (pelaa && rahaMaara > 0) {
            char[] riviLista = { 'o', 'o', 'o' };
            resetLukot();
            rivi = arvoRivi( riviLista, getLukitut() );
            System.out.println(rivi);
            if (tarkistaVoitto(rivi, panos) > 0) {
                rahaMaara += tarkistaVoitto(rivi, panos);
            } else {
                lukitse();
                rivi = arvoRivi( riviLista, getLukitut() );
                System.out.println(rivi);
                rahaMaara += tarkistaVoitto(rivi, panos);
            }
            System.out.println("Voitto: " + tarkistaVoitto(rivi, panos) );
            System.out.println("Sinulla on rahaa: " + rahaMaara);
            pelaa = jatkaminen();
        }
        return rahaMaara;        
    }
}
    
