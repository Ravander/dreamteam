package rahapeliSimulaattori;

/*
Simulaatio RAY-rahapeliautomaatin Tähti-pelistä. Merkit vastaavat alkuperäisen
pelin hedelmiä ja kuvioita. Merkkejä voi lukita paikoilleen, jos ensimmäisellä
yrittämällä ei voittoa tullut.
*/
public class Tahti extends Peli {

    /* PRIVATE-MUUTTUJAT */
    private char[] merkit = { 'a', 'b', 'c', 'd', '*' };
    private int[] lukitut = { 0, 0, 0 };
    
    /* GET / SET */
    public int[] getLukitut() { return lukitut; }
    public void setLukitut(int[] lukitut) {
        this.lukitut = lukitut;
    }
    
    private char arvoMerkki() {  
        int arvo = arpa.nextInt(5);           
        return merkit[arvo];    
    }
    
    private String arvoRivi(char[] riviLista, int[] lukitusLista) {   
    
        String tulosRivi = "";
        
        for ( int i = 0; i < 3; i++ ) {
            if (lukitusLista[i] == 0) {
                riviLista[i] = arvoMerkki();
            }
            tulosRivi += riviLista[i];
        }    
        return tulosRivi;
    }
    
    private void lukitse() {
       
        int[] lukot = new int[3];
        int luku;
        
        System.out.println("Valitse lukitukset");
        for (int i = 0; i < 3; i++) {
            System.out.print("> ");
            luku = syotaInt();
            if (luku == 1 || luku == 0) {
                lukot[i] = luku;
            } else {
                System.out.println("Syötit virheellisen luvun");
                System.out.println("Merkkiä ei lukittu");
                lukot[i] = 0;
            }
        }
        setLukitut(lukot);
    }
    
    private void resetLukot() {
        int[] nollaus = { 0, 0, 0 };
        setLukitut(nollaus);
    }
    
    /* Tarkistaa voitot syötetyllä merkkiyhdistelmällä ja panoksella */
    private double tarkistaVoitto(String rivi, double panos) {   
    
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
                break;
        }
        return voitto;
    }
    
    public double pelaa(double rahaMaara, double panos) {
        
        String rivi = "ooo";
        double voitto;
        boolean pelaa = true;
        
        while (pelaa && rahaMaara >= panos) {
        
            rahaMaara = rahaMaara - panos;
            char[] riviLista = { 'o', 'o', 'o' };
            resetLukot();
            rivi = arvoRivi( riviLista, getLukitut() );
            System.out.println(rivi);
            
            if (tarkistaVoitto(rivi, panos) > 0) {
                voitto = tarkistaVoitto(rivi, panos);
            } else {
                lukitse();
                rivi = arvoRivi( riviLista, getLukitut() );
                System.out.println(rivi);
                voitto = tarkistaVoitto(rivi, panos);
            }
            
            System.out.println("Voitto: " + voitto + "0 €" );
            voitto = tuplausCheck(voitto);
            rahaMaara += voitto;
            System.out.println("Sinulla on rahaa: " + rahaMaara + "0 €");
            
            pelaa = jatkaminen();
        }
        return rahaMaara;        
    }
}
    
