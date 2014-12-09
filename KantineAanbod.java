import java.util.*;

public class KantineAanbod {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private double[] prijs;
    private int[] hoeveelheid;
    private String[] artikelnaam;

    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen,
     * het tweede argument is een lijst met prijzen en het derde argument
     * is een lijst met hoeveelheden. Let op: de dimensies van de drie arrays
     * moeten wel gelijk zijn!
     * @author (Joshua van den Hof en Marnix Blaauw) 
     * @version (1-12-2014)
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid) {
        this.artikelnaam = artikelnaam;
        this.prijs = prijs;
        this.hoeveelheid = hoeveelheid;
        
        aanbod = new HashMap<String, ArrayList<Artikel>>();
        for(int i=0;i<artikelnaam.length;i++) 
        {
            ArrayList<Artikel> artikelen=new ArrayList<Artikel>();
            for(int j=0;j<hoeveelheid[i];j++) 
            {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
            }
            aanbod.put(artikelnaam[i], artikelen);
        }
    }

    /**
     * Private methode om de lijst van artikelen te krijgen op basis van de    
     * naam van het artikel. Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
        return aanbod.get(productnaam); 
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. 
     * Retourneert null als de stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        if (stapel==null) { 
            return null;
        }
        if (stapel.size()==0)
        {
            return null;
        }
        else 
        {
            Artikel a=stapel.get(0);
            stapel.remove(0);
            controleMagazijn();
            return a;
        }
    }
    
    /**
     * controleerd de voorraad van de magazijn.
     * als magazijn onder 150 komt word er automaties bij besteld
     */
    private void controleMagazijn(){
        for(int index = 0; index < artikelnaam.length; index ++) 
        {
            ArrayList<Artikel> artikelen = aanbod.get(artikelnaam[index]);
            if(artikelen.size() <= 150)
            { 
                bijvullenMagazijn(index);
            }
        }
    }
    
    /**
     * vuld de magazijn bij waar de bestel niveau is berijkt
     */
    private void bijvullenMagazijn(int nummer){
        ArrayList<Artikel> artikelen = aanbod.get(artikelnaam[nummer]);
        while(artikelen.size() < hoeveelheid[nummer]){
            artikelen.add(new Artikel(artikelnaam[nummer], prijs[nummer]));
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken.
     * Retouneert null als artikel niet bestaat of niet op voorraad is.
     * @param naam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String naam) {
        return getArtikel(getArrayList(naam));
    }
}
