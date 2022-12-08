package logika;

import java.text.Normalizer;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class Prostor {

    private String nazev;
    private String popis;
    private ArrayList<Prostor> vychody;   // obsahuje sousední místnosti
    private boolean zamceno; //obsahuje informaci o tom, zda je mistnost zamcena
    private List<Vec> veciVMistnosti; //obsahuje seznam veci
    private int modifikatorZivotu; // obsahuje informaci o tom kolik je treba ubrat zivotu pri vstupu do mistnosti
    private HerniPlan plan;
    private boolean viditelny;

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis, HerniPlan plan) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new ArrayList<>();
        veciVMistnosti = new ArrayList<>();
        this.zamceno = false;
        this.modifikatorZivotu = 0;
        this.plan = plan;
        viditelny = true;
    }


    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        boolean pomocna = false;
       for(Prostor item : vychody){
           if (item.equals(vedlejsi)){
               pomocna = true;
           }
       }
       if (!pomocna){
           vychody.add(vedlejsi);
       }
    }

    /**
     * Vloz veci do mistnosti, se kterymi bude clovek interagovat
     *
     * @param vec vec, ktera se nachazi v mistnosti
     */
    public void vlozVec(Vec vec) {
        veciVMistnosti.add(vec);
    }

    /**
     *
     * @param vec
     * @return
     */
    public boolean obsahujeVec(String vec){
        for (Vec neco : veciVMistnosti){
            if (Normalizer
                    .normalize(neco.getNazev(), Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "").toLowerCase().equals(Normalizer
                            .normalize(vec, Normalizer.Form.NFD)
                            .replaceAll("[^\\p{ASCII}]", "").toLowerCase())){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param nazev
     * @return
     */
    public Vec vyberVeci(String nazev){
        Vec vybranaVec = null;
        for (Vec neco : veciVMistnosti) {
            if (Normalizer
                    .normalize(neco.getNazev(), Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "").equalsIgnoreCase(Normalizer
                            .normalize(nazev, Normalizer.Form.NFD)
                            .replaceAll("[^\\p{ASCII}]", ""))) {
                vybranaVec = neco;
            }
        }

        if (vybranaVec != null){
            if (vybranaVec.jePrenositelna()){
                veciVMistnosti.remove(vybranaVec);
            }
            else {
                vybranaVec = null;
            }
        }
        return vybranaVec;
    }

    /**
     *
     * @return
     */
    private String seznamVeci(){
        StringBuilder seznam = new StringBuilder();
        for(Vec neco : veciVMistnosti){
            if (neco.isViditelna()){
            seznam.append(" ").append(neco.getNazev());
            }
        }
        if (seznam.isEmpty()){
            return " Tady nic není";
        }
        return seznam.toString();
    }
    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů.
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }
      

    /**
     * Vrací normalizovany název prostoru (bez hacku a carek, vsechno malym pro zjednoduseni user inputu)
     *
     * @return normalizovany název prostoru
     */
    public String getnNormalnizedNazev() {
        return  Normalizer
                .normalize(nazev, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }
    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev(){
        return nazev;
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        if (getZamceneVychody().equals(""))
        {
           return "Počet životů " + plan.getPocetZivotu() +"/100"+ "\n"
                    + "Momentálně se nacházíš v prostoru: " + this.getNazev() + "\n"
                    + "Věci v místnosti:" + seznamVeci() + "\n"
                    + "Východy:" + getOdemceneVychody() + "\n"
                    + "Aktuální předměty v batohu:" + plan.getBatuzek().getPredmetyVBatohu() + "\n"
                    + "Kapacita batohu: " + plan.getBatuzek().getVelikostBatuzku() + "/15";
        }
        return  "Počet životů " + plan.getPocetZivotu() +"/100"+ "\n"
                + "Momentálně se nacházíš v prostoru: " + this.getNazev() + "\n"
                + "Věci v místnosti:" + seznamVeci() + "\n"
                + "Východy:" + getOdemceneVychody() + "\n"
                + "Zamčené východy:" + getZamceneVychody() + "\n"
                + "Aktuální předměty v batohu:" + plan.getBatuzek().getPredmetyVBatohu() + "\n"
                + "Kapacita batohu: " + plan.getBatuzek().getVelikostBatuzku() + "/15";
    }


    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory =
                vychody.stream()
                        .filter(sousedni -> sousedni.getnNormalnizedNazev().equals(nazevSouseda)).toList();
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     *
     * @return
     */
    public String getOdemceneVychody() {
        StringBuilder pomoc = new StringBuilder();
        for (var item : vychody){
            if (!item.getStav()){
            pomoc.append(" ").append(item.getNazev());
            }
        }
        return pomoc.toString();
    }

    /**
     *
     * @return
     */
    public String getZamceneVychody() {
        StringBuilder pomoc = new StringBuilder();
        for (var item : vychody){
            if (item.getStav()){
                pomoc.append(" ").append(item.getNazev());
            }
        }
        return pomoc.toString();
    }

    /**
     *
     * @return
     */
    public boolean getStav() {
        return zamceno;
    }

    /**
     *
     * @return
     */
    public boolean odemknoutMistnost() {
        if (this.zamceno){
            zamceno = false;
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean zamknoutMistnost() {
    if (!this.zamceno){
        zamceno = true;
        return true;
    }
    return false;
    }

    /**
     *
     * @param modifikatorZivotu
     */
    public void setModifikatorZivotu(int modifikatorZivotu) {
        this.modifikatorZivotu = modifikatorZivotu;
    }

    /**
     *
     * @return
     */
    public int getModifikatorZivotu() {
        return modifikatorZivotu;
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }

    /**
     *
     * @return
     */
    public String getPopis() {
        return popis;
    }

    /**
     *
     * @return
     */

    public boolean isZamceno() {
        return zamceno;
    }

    /**
     *
     * @return
     */
    public boolean isViditelny() {
        return viditelny;
    }

    /**
     *
     * @param viditelnost
     */
    public void setViditelnost(boolean viditelnost) {
        this.viditelny = viditelnost;
    }

    /**
     *
     * @return
     */
    public ArrayList<Prostor> schovaneProstory(){
        ArrayList<Prostor> mistni = new ArrayList<>();
        for (var item : vychody){
            if (!item.isViditelny()){
                mistni.add(item);
            }
        }
        return mistni;
    }

    /**
     *
     * @return
     */
    public ArrayList<Vec> getSchovaneSchovaneVeci() {
        ArrayList<Vec> mistniList = new ArrayList<>();
        for (var item : veciVMistnosti){
            if (!item.isViditelna()){
                mistniList.add(item);
            }
        }
        return mistniList;
    }

    /**
     *
     * @param normalizovanyNazev
     * @return
     */
    public String nazevVeciZpatky(String normalizovanyNazev){
        for (var vec : veciVMistnosti){
            if (Normalizer.normalize(vec.getNazev(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").equalsIgnoreCase(Normalizer
                    .normalize(normalizovanyNazev, Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", ""))) {
                return vec.getNazev();
            }

        }
        return normalizovanyNazev;
    }

    /**
     *
     * @return
     */
    public ArrayList<Prostor> zamceneProstoryList(){
        ArrayList<Prostor> mistni = new ArrayList<>();
        for (var item : vychody){
            if (item.getStav()) {
                mistni.add(item);
            }
        }
        return mistni;
    }
}
