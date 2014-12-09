import java.util.ArrayList;
/**
 * klasse persoon
 * 
 * @author (Joshua van den Hof en Marnix Blaauw) 
 * @version (1-12-201)
 */
public class Persoon
{
    // instance variables - replace the example below with your own
    private Dienblad dienblad;
    private Artikel artikel;
    private int burgerServiceNummer;
    private String voornaam;
    private String achternaam;
    private String geboorteDatum;
    private int geboorteDag;
    private int geboorteMaand;
    private int geboorteJaar;
    private char geslacht;
    
    // Deze variabelen worden gebruikt voor een check.
    boolean isSchrikkeljaar;
    boolean geldigeDag;

    /**
     * Constructor voor uniek persoon
     */
    public Persoon(int burgerServiceNummer, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht)
    {
        setBurgerServiceNummer(burgerServiceNummer);
        setVoornaam(voornaam);
        setAchternaam(achternaam);
        setgeboorteDatum(geboorteDag, geboorteMaand, geboorteJaar);
        setGeslacht(geslacht);
    }

    /**
     * Constructor voor standaard persoon
     */
    public Persoon()
    {   this.dienblad = null;
        this.geboorteDag=0;
        this.geboorteMaand=0;
        this.geboorteJaar=0;
        this.geslacht='x';
    }

    /**
     * Zet burgerservicenummer van persoon
     * @param Burgerservice nummer
     */
    public void setBurgerServiceNummer(int BurgerServiceNummer)
    {
        this.burgerServiceNummer = BurgerServiceNummer;
    }

    /**
     * Zet voornaam van persoon
     * @param voornaam
     */
    public void setVoornaam(String Voornaam)
    {
        this.voornaam = Voornaam;
    }

    /**
     * zet achternaam van persoon
     * @param achternaam
     */
    public void setAchternaam(String Achternaam)
    {
        this.achternaam = Achternaam;
    }

    /**
     * zet geboortedag, geboortemaand en geboortejaar
     * controleert de geldigheid van de ingevoerde datum
     * @param geboortedag geboortemaand geboortejaar
     */
    public void setgeboorteDatum(int geboorteDag, int geboorteMaand, int geboorteJaar)
    {
        switch (geboorteMaand){
            case 1 : 
            case 3 :
            case 5 :
            case 7 :
            case 8 :
            case 10:
            case 12:
            if (geboorteDag >= 1 && geboorteDag <= 31){
                this.geboorteDag = geboorteDag;
                geldigeDag = true;
            }
            else {
                System.out.println ("Dag voldoet niet aan de voorwaarden.");
                this.geboorteDag = 0;
                this.geboorteMaand = 0;
                this.geboorteJaar = 0;
            }
            break ;
            case 4 :
            case 6 :
            case 9 :
            case 11:
            if (geboorteDag >= 1 && geboorteDag <= 30){
                this.geboorteDag = geboorteDag;
                geldigeDag = true;
            }
            else {
                System.out.println ("Dag voldoet niet aan de voorwaarden deze maand heeft geen 31 dagen.");
                this.geboorteDag = 0;
                this.geboorteMaand = 0;
                this.geboorteJaar = 0;
            }
            break ;
            case 2 :
            if(geboorteJaar % 4 == 0)
            {
                if((geboorteJaar % 100 == 0) && (geboorteJaar % 400 != 0))
                {
                    isSchrikkeljaar = false;
                }
                else
                {
                    isSchrikkeljaar = true;
                }
            }
            else
            {
                isSchrikkeljaar = false;
            }           

            if(isSchrikkeljaar == false)
            {
                if(geboorteDag >= 1 && geboorteDag <= 28){
                    this.geboorteDag = geboorteDag;
                    geldigeDag = true;
                }
                else{
                    this.geboorteDag = 0;
                    geldigeDag = false;
                    System.out.println ("deze maand gaat maar tot 28 dagen");
                }
            }

            if(isSchrikkeljaar == true)
            {
                if(geboorteDag >= 1 && geboorteDag <= 29){
                    this.geboorteDag = geboorteDag;
                    geldigeDag = true;
                }
                else{
                    this.geboorteDag = 0;
                    geldigeDag = false;
                    System.out.println ("deze maand gaat maar tot 29 dagen");
                }
            }
            break ;
        }

        if (geboorteMaand >= 1 && geboorteMaand <= 12 && geldigeDag == true){
            this.geboorteMaand = geboorteMaand;
        }
        else {
            System.out.println ("Maand voldoet niet aan de voorwaarden.");
            this.geboorteDag = 0;
            this.geboorteMaand = 0;
            this.geboorteJaar = 0;
        }

        if (geboorteJaar >= 1900 && geboorteJaar <= 2100 && geldigeDag == true){
            this.geboorteJaar = geboorteJaar;
        }
        else {
            System.out.println ("Jaar voldoet niet aan de voorwaarden.");
            this.geboorteDag = 0;
            this.geboorteMaand = 0;
            this.geboorteJaar = 0;
        }        
    }

    /**
     * zet het geslacht van persoon
     * controleert of geslacht man of vrouw is
     * controleert geldigheid van geslacht
     * @param geslacht
     */
    public void setGeslacht(char geslacht)
    {
        if (geslacht == 'm' || geslacht == 'v'){
            this.geslacht = geslacht;
        }
        else {
            this.geslacht = 'x';
            System.out.println ("Voer een geldig geslacht in. (M/V)"); 
            //deze melding geeft aan dat de geslacht niet corect is ingevoerd en is veranderd naar onbekent.
        }
    }

    /**
     * Retouneert geboortedatum
     * @return geboortedatum
     */
    public String getGeboorteDatum() {
        if (geboorteDag==0 && geboorteMaand==0 && geboorteJaar==0) {
            geboorteDatum="Onbekend";
        } else {
            geboorteDatum=geboorteDag+"/"+geboorteMaand+"/"+geboorteJaar;
        }
        return geboorteDatum;
    }

    /**
     * Retouneert voornaam
     * @return voornaam
     */
    public String getVoorNaam(){
        return voornaam;
    }

    /**
     * Retouneert achternaam
     * @return achternaam
     */
    public String getAchterNaam(){
        return achternaam;
    } 

    /**
     * Retouneert burgerservicenummer
     * @return burgerservicenummer
     */
    public int getBurgerServiceNummer(){
        return burgerServiceNummer;
    }

    /**
     * Retouneert geslacht
     * @return geslacht
     */
    public String getGeslacht(){
        if(geslacht == 'm'){
            return "man";
        }
        if(geslacht == 'v'){
            return "vrouw";
        }
        else{
            return "onbekent";
        }
    }

    /**
     * Drukt de gegevens van persoon af
     */
    public void drukAf(){
        System.out.println(burgerServiceNummer);
        System.out.println(voornaam);
        System.out.println(achternaam);
        System.out.println(geboorteDatum);
        System.out.println(getGeslacht());       
    }

    /**
     * Methode om dienblad te koppelen aan een persoon
     * @param dienblad
     */
    public void pakDienblad(Dienblad dienblad){
        this.dienblad = dienblad;
    }

    /**
     * retouneert de dienblad aan de klassen die hem nodig hebben zo dat die het kunnen ophalen. 
     * @return dienblad
     */
    public Dienblad getDienblad(){
        return dienblad;
    }
}