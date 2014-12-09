
/**
 * Klasse artikel
 * 
 * @author (Joshua van den Hof en Marnix Blaauw) 
 * @version (1-12-2014)
 */
public class Artikel
{
    // instance variables - replace the example below with your own
    private double prijs;
    private String naam;

    /**
     * Constructor voor artikel
     */
    public Artikel(String naamArtikel, double prijsArtikel)
    {
        prijs = prijsArtikel;
        naam = naamArtikel;
    }

    /**
     * Wijst artikel een prijst toe
     * @param prijst
     */
    public void setArtikelPrijs(int prijs){
        this.prijs = prijs;
    }

    /**
     * Wijst artikel een naam toe
     * @param naam
     */
    public void setArtikelNaam(String naam){
        this.naam = naam;
    }

    /**
     * Geeft prijs weer
     * @return artikel prijs
     */
    public double getArtikelPrijs(){
        return prijs;
    }

    /**
     * Geeft naam weer
     * @return artikel naam
     */
    public String getArtikelNaam(){
        return naam;
    }

    /**
     * Drukt de gegevens van de artikel(en) af
     */
    public void drukAf(){
        System.out.println(prijs);
        System.out.println(naam);
    }
}
