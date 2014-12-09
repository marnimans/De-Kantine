import java.util.*;
/**
 * @author (Joshua van den Hof en Marnix Blaauw) 
 * @version (1-12-2014)
 * Klasse kantine
 */
public class Kantine {
    private Kassa kassa;
    private KassaRij kassarij;
    private Persoon persoon;
    private Dienblad dienblad;
    private Artikel artikel;
    Random rand = new Random();
    private int totaalArtikelen;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor voor de kantine
     */
    public Kantine() {
        kassarij=new KassaRij();
        kassa=new Kassa(kassarij);
        //artikel=new Artikel(Artikel.artikel);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad
     * gemaakt en aan elkaar
     * gekoppeld. Maak twee Artikelen aan en plaats
     * deze op het dienblad.
     * Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     * @param persoon en artikelnamen
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen){
        for(int index = 0; index < artikelnamen.length; index ++) {
            Artikel artikel = kantineAanbod.getArtikel(artikelnamen[index]);
            persoon.getDienblad().voegToe(artikel);
        }
        kassarij.sluitAchteraan(persoon);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij() == true) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());

        }
    }
    
    /**
     * retourneerd de waarde van kassa
     * @return kassa
     */
    public Kassa getKassa(){
        return kassa;
    }
    
    /**
     * set de kantine aanbod vanuit kantine simulator
     * @param kantineAanbod
     */
    public void setKantineAanbod(KantineAanbod kantineAanbod){
        this.kantineAanbod = kantineAanbod;
    }
    
    /**
     * returnd de kantine aanbod
     * @return kantineAanbod
     */
    public KantineAanbod getKantineAanbod(){
        return kantineAanbod;
    }
}