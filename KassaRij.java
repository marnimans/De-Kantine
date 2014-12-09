import java.util.*;

/**
 * @author (Joshua van den Hof en Marnix Blaauw) 
 * @version (1-12-2014)
 * Klasse kassarij
 */
public class KassaRij {
    private LinkedList <Persoon> wachtende;

    /**
     * Constructor voor kassarij
     */
    public KassaRij() {
        this.wachtende = new LinkedList<Persoon>();
    }

    /**
     * Laat de persoon achteraan sluiten
     * @param persoon
     */
    public void sluitAchteraan(Persoon persoon) {
        this.wachtende.add(persoon);
    }

    /**
     * Indien er een rij bestaat, de eerste Persoon uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     * @return Eerste persoon in de rij of null
     */
    public Persoon eerstePersoonInRij() {
        if (wachtende.size() > 0){
            Persoon eersteInRij = wachtende.get(0);
            wachtende.remove(0);
            return eersteInRij;
        }
        else{
            return null;
        }
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        if (wachtende.size() > 0){
            boolean erIsEenRij = true; 
            return erIsEenRij;
        }
        else {
            boolean erIsEenRij = false; 
            return erIsEenRij;
        }
    }
}