package logika;

public class PrikazVymeny implements IPrikaz{

    final String NAZEV = "vymena"; //nazev prikazu a jeho zneni pro pouziti
    private Prostor mistnost; //instance tridy Prostor

    /**
     * Konstruktor tridy
     *
     * @param mistnost mistnost obsahujici vymenu
     */
    public PrikazVymeny(Prostor mistnost) {
        this.mistnost = mistnost;
    }

    /**
     * Co se stane pri exekuci prikazu
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return textovy retezec obsahujici zpravu o tom co se stalo a dlouhy popis mistnosti
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (mistnost.getVymena() != null){
            Vymena mistni = mistnost.getVymena();
            return mistni.toString();
        }
        return "tady nic nevymenis kamo";
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
