import java.util.*;

/**
 * Klasse dienblad
 * @author (Joshua van den Hof en Marnix Blaauw) 
 * @version (1-12-2014)
 */
public class Dienblad {
    private Stack<Artikel> artikelen;
    /**
     * Constructor voor dienblad
     */
    public Dienblad() {
        artikelen = new Stack<Artikel>();    
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }
    
    /**
     * maakt een iterator voor de artikelen.
     * @return iterator
     */
    public Iterator<Artikel> getIterator() {
        return artikelen.iterator();
    }
}
