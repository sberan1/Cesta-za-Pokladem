package logika;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan; //obsahuje instanci herniho plan
    private boolean konecHry = false; //nastavuje konec hry
    private String epilog = "Dohrál jsi tuto úžasnou hru, našel jsi ukradené zlato a je už jen na tobě, jestli si ho necháš, nebo ho půjdeš vrátit do města. Děkuji za zahrání!";

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazProzkoumej(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazOdemkni(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPoloz(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazVymen(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazVymeny(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPouzij(herniPlan));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return "Vítej v adventuře, kde je tvým cílem dojít do zamčené " +
                "shované místnosti v čarodějově věži kde čaroděj shovává všechno ukradené zlato.\n" +
                "Čeká tě těžký průchod a budeš muset cestou posbírat několik předmětů.\n " +
                "Napište 'nápověda', pokud si nevíte rady, jak hrát dál. \n" +
               herniPlan.getAktualniProstor().dlouhyPopis();
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return epilog;
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
         if (herniPlan.getPocetZivotu() > 0) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
           	parametry[i]= slova[i+1];  	
        }
        String textKVypsani;
            if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
                IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
                textKVypsani = prikaz.provedPrikaz(parametry);
            } else {
                textKVypsani = "Nevím co tím myslíš? Tento příkaz neznám. ";
            }
            return textKVypsani;
        }
        konecHry = true;
        return "umrel jsi, zkus to znovu kamo";
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }

    /**
     * nastavi epilog
     *
     * @param epilog - text co ma hra vratit pri ukonceni hry
     */

    public void setEpilog(String epilog) {
        this.epilog = epilog;
    }
}

