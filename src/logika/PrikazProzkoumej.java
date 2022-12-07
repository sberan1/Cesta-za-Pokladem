package logika;

public class PrikazProzkoumej implements IPrikaz{

    HerniPlan plan;
    private final String NAZEV = "prozkoumej";

    public PrikazProzkoumej(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda pro provedení příkazu ve hře.
     * Počet parametrů je závislý na konkrétním příkazu,
     * např. příkazy konec a napoveda nemají parametry
     * příkazy jdi, seber, polož mají jeden parametr
     * příkaz pouzij může mít dva parametry.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     */
    @Override
    public String provedPrikaz(String... parametry) {
        String navratovaHodnota = "";
        for (var item : plan.getAktualniProstor().schovaneProstory()) {
            item.setViditelnost(true);
            navratovaHodnota += " " + item.getNazev();
        }
        for (var item : plan.getAktualniProstor().getSchovaneSchovaneVeci()){
            item.setViditelna(true);
            navratovaHodnota += " " + item.getNazev();
        }

        return "V místnosti " + plan.getAktualniProstor().getNazev() + " jsi našel" + navratovaHodnota + "\n" + plan.getAktualniProstor().dlouhyPopis();
    }

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}