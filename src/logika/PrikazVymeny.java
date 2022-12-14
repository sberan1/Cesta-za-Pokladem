package logika;

public class PrikazVymeny implements IPrikaz{

    final String NAZEV = "vymena";
    private Prostor mistnost;

    public PrikazVymeny(Prostor mistnost) {
        this.mistnost = mistnost;
    }
    /**
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return
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
     * @return
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
