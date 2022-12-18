package logika;




/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * <p>
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor; //prostor ve kterem se prave hrac nachazi
    private Prostor vyherniProstor; //prostor ve kterem hrac automaticky vyhraje
    private Prostor proherniProstor; //prostor ktery pro hrace ukonci hru
    private Batoh batuzek = new Batoh(15); //zakladame instanci batohu s vybranou velikosti
    private int pocetZivotu = 100; //nastaveni defaultniho poctu zivotu
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        inicializaceProstoru();
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    /**
     * Metoda vraci prostor, ve kterem hra skonci uspesnym koncem
     *
     * @return vyherni prostor
     */
    public Prostor getVyherniProstor() {
        return vyherniProstor;
    }

    /**
     * Metoda vraci prostor, ve kterem hra skonci neuspesnym koncem
     *
     * @return prostor, kde hrac automaticky prohraje
     */
    public Prostor getProherniProstor(){return proherniProstor;}

    /**
     * vraci instanci tridy batoh, se kterou je pak mozne pracovat
     *
     * @return mistni instanci tridy batoh
     */
    public Batoh getBatuzek() {
        return batuzek;
    }

    /**
     * metoda get pro vlastnost pocetZivotu, vraci pouze int s momentalni hodnotou zivotu
     *
     * @return momentalni pocet zivotu
     */
    public int getPocetZivotu() {
        return pocetZivotu;
    }

    /**
     * stanovuje o kolik by se mel snizit vlastnost zivoty pri vstupu do mistnosti
     *
     * @param decrement - volba kolik bychom meli ubrat nebo pridat zivotu (default: ubrani)
     */
    public void uberZivoty(int decrement) {
        pocetZivotu -= decrement;
    }


    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    public void inicializaceProstoru(){
        // vytvářejí se jednotlivé prostory
        Prostor hory = new Prostor("Hory", "Tady jsi v horách, je tu pěkný výhled a všechno ale nic tu není", this);
        Prostor mesto = new Prostor("Město","Město - Tady se děje všechno svaté i nesvaté", this);
        Prostor stodola = new Prostor("Stodola", "Stodola - tady je seno a par vandraku, muzes se tu klidne i vyspat nebo tak", this);
        Prostor kostel = new Prostor("Kostel", "Kostel -  Místo, kde jsme blíže bohu a můžeme zde najít" , this);
        Prostor dumKovare = new Prostor("DůmKováře","DůmKováře - tady bydlí kovář" , this);
        Prostor hospoda = new Prostor("Hospoda","Hospoda - tady se pije" , this);
        Prostor hlubokyLes = new Prostor("HlubokýLes","HlubokýLes - Při vstupu do Hlubokého lesa tě napadli vlci a ubrali ti 20 životů než jsi je stihl zahnat." , this);
        Prostor pustina = new Prostor("Pustina", "Pustina - tady krom suché hlíny nic nenajdeš, cestou jsi z vyčerpání ztratil 10 životů.", this);
        Prostor vesnice = new Prostor("Vesnice", "Vesnice - Tady se neděje absolutně nic zajímavého, potkal jsi pár ovcí, a zvláštního kupce co ti za LahevAlkoholu nabízí svůj nůž a kámen.", this);
        Prostor piratskaLod = new Prostor("PirátskáLoď", "PirátskáLoď - byl jsi napaden a obklíčen, piráti ti nabízejí výměnu lahveAlkoholu a meče za tvůj život.", this);
        Prostor carodejovaVez = new Prostor("ČarodějovaVěž", "ČarodějovaVěž - Vešel jsi dovnitř, kde tě napadl čaroděj, po dlouhé bitvě jsi ho svými magickými schopnostmi překonal. Přišel jsi o 70 životů.", this);
        Prostor tajnaPokladnice = new Prostor("TajnáPokladnice", "Vyhrál jsi", this);
        Prostor les = new Prostor("Les", "Při vstupu do lesa ses praštil o větev a ubylo ti 10 zivotu, jejda", this);
        Prostor taborak = new Prostor("Táborák", "Došel jsi k taboraku a nejakej pobuda ti tu nabizi nahrdelnik za pullitr, mec a nuz", this);
        Prostor pastStodola = new Prostor("Stodola", "past", this);
        Prostor taboriste = new Prostor("Tábořiště", "Našel jsi opuštěné tábořiště, tak se tu kdyžtak zkus poohlédnout", this);

        //zalozeni veci
        Vec mrtvaKrysa = new Vec("MrtváKrysa", true, true);
        Vec strepy = new Vec("Střepy", true, true);
        Vec barel = new Vec("Barel", false, true);
        Vec lampa = new Vec("Lampa", false, true);
        Vec roba = new Vec("Róba", true, true);
        Vec zezlo = new Vec("Žezlo", true, true);
        Vec lavice = new Vec("Lavice", false, true);
        Vec klicKostel = new Vec("Klíč", true, false);
        Vec lektvarZivota = new Vec("LektvarŽivota", true, false, Pouzitelnosti.Lektvar, 100);
        Vec mec = new Vec("Meč", true, true);
        Vec stul = new Vec("Stůl", false, true);
        Vec nuz = new Vec("Nůž", true, true);
        Vec pullitr = new Vec("Půllitr", true, true);
        Vec zidle = new Vec("Židle", false, true);
        Vec lahevAlkoholu = new Vec("LahevAlkoholu", true, true);
        Vec klacek = new Vec("Klacek", true, true);
        Vec kamen = new Vec("Kámen", true, true);
        Vec strom = new Vec("Strom", false, true);
        Vec klicHlubokyLes = new Vec("Klíč", true, false);
        Vec stan = new Vec("Stan", false, true);
        Vec klicTaboriste = new Vec("Klíč", true, false);
        Vec lektvarLes = new Vec("MalýLektvarŽivota", true, false, Pouzitelnosti.Lektvar, 50);
        Vec nahrdelnik = new Vec("Náhrdelník", true, true);
        Vec parez = new Vec("Pařez", false, true);
        Vec slama = new Vec("Sláma", true, true);
        Vec seno = new Vec("Seno", true, true);

        //zalozeni vymen
        Vymena vymenaVesnice = new Vymena("zvláštní kupec ti nabizi za LahevAlkoholu svůj nůž a kámen", "lahev", "tak to byla naprosto silena vymena, jak myslis, dostals kamen a nuz, uzivej");
        vymenaVesnice.setOcekavaneVeci(lahevAlkoholu);
        vymenaVesnice.setNavratovaHodnota(nuz);
        vymenaVesnice.setNavratovaHodnota(kamen);

        Vymena zivotPiratskaLod = new Vymena(" piráti ti nabízejí výměnu lahveAlkoholu a meče za tvůj život", "zivot", "Když tě piráti okrádali tak jsi jim začal utíkat do Vesnice, zvládl jsi jednomu z nich ukrást klíč, přišel jsi o věci co po tobě chtěli a byl jsi postřelen za 50 životů.");
        zivotPiratskaLod.setOcekavaneVeci(lahevAlkoholu);
        zivotPiratskaLod.setOcekavaneVeci(mec);
        zivotPiratskaLod.setNavratovaHodnota(50);
        zivotPiratskaLod.setNavratovaHodnota(klicHlubokyLes);
        zivotPiratskaLod.setNavratovaHodnota(vesnice);
        zivotPiratskaLod.setTrestZaNesplneni(100);
        zivotPiratskaLod.setOdemceniMistnosti(pustina, carodejovaVez);

        Vymena taborakVymena = new Vymena("Pobuda ti nabizi nahrdelnik za pullitr, mec a nuz", "nahrdelnik", "vymenil jsi bezcenny nahrdelnik za par veci, gratulace");
        taborakVymena.setOcekavaneVeci(pullitr);
        taborakVymena.setOcekavaneVeci(mec);
        taborakVymena.setOcekavaneVeci(nuz);
        taborakVymena.setNavratovaHodnota(nahrdelnik);


        stodola.zamknoutMistnost();
        dumKovare.zamknoutMistnost();

        // přiřazují se průchody mezi prostory (sousedící prostory)

        //mesto setup
        mesto.setVychod(hory);
        mesto.setVychod(les);
        mesto.setVychod(hlubokyLes);
        mesto.setVychod(hospoda);
        mesto.setVychod(kostel);
        mesto.setVychod(dumKovare);
        mesto.setVychod(stodola);
        mesto.vlozVec(mrtvaKrysa);
        mesto.vlozVec(strepy);
        mesto.vlozVec(barel);
        mesto.vlozVec(lampa);

        //kostel setup
        kostel.setVychod(mesto);
        kostel.vlozVec(roba);
        kostel.vlozVec(zezlo);
        kostel.vlozVec(lavice);
        kostel.vlozVec(klicKostel);
        kostel.vlozVec(lektvarZivota);

        //dumkovare setup
        dumKovare.setVychod(mesto);
        dumKovare.vlozVec(mec);
        dumKovare.vlozVec(stul);
        dumKovare.vlozVec(nuz);

        //hospoda setup
        hospoda.setVychod(mesto);
        hospoda.vlozVec(pullitr);
        hospoda.vlozVec(nuz);
        hospoda.vlozVec(stul);
        hospoda.vlozVec(zidle);
        hospoda.vlozVec(lahevAlkoholu);

        //hlubokyles setup
        hlubokyLes.setModifikatorZivotu(20);
        hlubokyLes.setVychod(mesto);
        hlubokyLes.setVychod(hory);
        hlubokyLes.setVychod(taborak);
        hlubokyLes.setVychod(pustina);
        hlubokyLes.vlozVec(klacek);
        hlubokyLes.vlozVec(kamen);
        hlubokyLes.vlozVec(strom);
        hlubokyLes.vlozVec(klicHlubokyLes);

        //pustina setup
        pustina.setModifikatorZivotu(10);
        pustina.setVychod(hlubokyLes);
        pustina.setVychod(les);
        pustina.setVychod(vesnice);
        pastStodola.zamknoutMistnost();
        pastStodola.nastavPast(2);
        pustina.setVychod(pastStodola);

        //vesnice setup
        vesnice.setVychod(les);
        vesnice.setVychod(pustina);
        vesnice.setVychod(piratskaLod);
        vesnice.vlozVec(kamen);
        vesnice.vlozVec(klacek);
        vesnice.vlozVec(barel);
        vesnice.setVymena(vymenaVesnice);

        //piratskalod setup
        piratskaLod.setVymena(zivotPiratskaLod);
        piratskaLod.nastavPast(2);

        //carodejovavez setup
        carodejovaVez.zamknoutMistnost();
        carodejovaVez.setVychod(pustina);
        carodejovaVez.setModifikatorZivotu(70);
        tajnaPokladnice.setViditelnost(false);
        tajnaPokladnice.zamknoutMistnost();
        carodejovaVez.setVychod(tajnaPokladnice);

        //taboriste setup
        taboriste.setViditelnost(false);
        taboriste.setVychod(les);
        taboriste.vlozVec(stan);
        taboriste.vlozVec(klicTaboriste);

        //les setup
        les.setVychod(taboriste);
        les.setVychod(vesnice);
        les.setVychod(hory);
        les.setVychod(pustina);
        les.vlozVec(klacek);
        les.vlozVec(kamen);
        les.vlozVec(strom);
        les.setModifikatorZivotu(10);
        les.vlozVec(lektvarLes);

        //taborak setup
        taborak.setVychod(hlubokyLes);
        taborak.setVymena(taborakVymena);
        taborak.vlozVec(parez);
        taborak.vlozVec(klacek);

        //hory setup
        hory.setVychod(mesto);
        hory.setVychod(les);
        hory.setVychod(hlubokyLes);
        hory.vlozVec(kamen);
        hory.vlozVec(strom);

        //stodola setup
        stodola.setVychod(mesto);
        stodola.vlozVec(seno);
        stodola.vlozVec(slama);


        vyherniProstor = tajnaPokladnice;
        aktualniProstor = mesto;  // hra začíná v domečku
        proherniProstor = pastStodola;


    }

}
