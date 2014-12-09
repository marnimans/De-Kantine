import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Klasse kassa
 * @author (Joshua van den Hof en Marnix Blaauw) 
 * @version (1-12-2014)
 */
public class Kassa {
    private KassaRij kassarij;
    private Dienblad dienblad;
    private int totaalArtikelen;
    private double totaalBetalingen;
    private NumberFormat round = new DecimalFormat("#.00");    

    /**
     * Constructor voor kassa
     * @param
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
    }

    /**
     * Deze methode vraagt het aantal artikelen en de totaalprijs op.
     * (De implementatie wordt later vervangen
     * door een echte betaling door de persoon.)
     * @param persoon die moet afrekenen
     */
    public void rekenAf(Persoon persoon) {
        System.out.println("Aantal artikelen:      " + artikelenOpDienblad(persoon));
        System.out.println("Totaalprijs artikelen: " + round.format(totaalPrijsDienblad(persoon)) + " euro \n");
        totaalBetalingen += totaalPrijsDienblad(persoon);
        totaalArtikelen += artikelenOpDienblad(persoon);
    }

    /**
     * Geeft het aantal artikelen dat de kassa
     * heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden
     * is aangeroepen.
     * retouneert aantal artikelen
     * @return totaal artikelen
     */
    public int totaalArtikelen() {
        return totaalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die
     * de kassa zijn gepasseerd, vanaf het moment dat de methode
     *resetKassa
     * is aangeroepen.
     * retouneert de hoeveelheid geld in de kassa
     * @return totaal betalingen
     */
    public double hoeveelheidGeldInKassa() {
        return totaalBetalingen;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        totaalBetalingen = 0.0;
        totaalArtikelen = 0;
    }

    /**
     * Telt aantal artikelen op dienblad per persoon
     * @param persoon
     * @return artikelen op dienblad
     */
    public int artikelenOpDienblad(Persoon persoon){
        int index = 0;
        if(persoon.getDienblad().getIterator() == null){
            System.out.println("er staan geen artikelen op het dienblad.");
            return index;
        }
        else {
            Iterator<Artikel> it = persoon.getDienblad().getIterator();
            while(it.hasNext()) {
                it.next();
                index++;
            }
            return index;
        }

    }

    /**
     * geeft de totaal prijs per persoon door
     * @param persoon
     * @return prijs
     */
    public double totaalPrijsDienblad(Persoon persoon){
        double prijs = 0.0;
        if(persoon.getDienblad().getIterator() == null){
            System.out.println("er staan geen artikelen op het dienblad.");
            return prijs;
        }
        else{
            Iterator<Artikel> it = persoon.getDienblad().getIterator();
            while(it.hasNext()) {
                prijs += it.next().getArtikelPrijs();
            }
            return prijs;
        }
    }
}
