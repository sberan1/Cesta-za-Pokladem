package logika;

import java.text.Normalizer;

public class PrikazOdemkni implements IPrikaz{

    private final String NAZEV = "odemkni";
    private HerniPlan plan;

    public PrikazOdemkni(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Musite mit jasno v tom co chcete odemknout, co sem vubec lezete takhle nepripravenej sakra";
        }
        if (parametry.length > 1) {
            return "jezisi kriste a co z toho mam asi odemknout, vy jste jak z jara";
        }

        String nazevMistnosti = Normalizer.normalize(parametry[0], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        for (var mistnost : plan.getAktualniProstor().zamceneProstoryList()){
            if(nazevMistnosti.equals(mistnost.getnNormalnizedNazev())) {
                if (plan.getBatuzek().odeberVec("klic")) {
                    mistnost.odemknoutMistnost();
                    return "Odemkl jsi " + mistnost.getNazev() + "\n" + plan.getAktualniProstor().dlouhyPopis();
                }
                return "A jak bys to chtel bez klice odemknout prosimte?";
            }
            return "Tahle mistnost tu neni sefe";
        }
        return "Tohle by se nemelo stat";
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
