package logika;

import java.text.Normalizer;

public class PrikazSeber implements IPrikaz {

    private static final String NAZEV = "seber";

    public HerniPlan plan;

    public PrikazSeber(HerniPlan plan){
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0){
            return "Coze mam sebrat? Vyber si!";
        }
        if (parametry.length > 1){
            return "Co z toho chces sebrat? Blazne!";
        }

        String nazevVeci = Normalizer
                .normalize(parametry[0], Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();

        Prostor aktualniProstor = plan.getAktualniProstor();

        String standartniNazev = aktualniProstor.nazevVeciZpatky(nazevVeci);

        if (aktualniProstor.obsahujeVec(nazevVeci)){
            Vec pozadovanaVec = aktualniProstor.vyberVeci(nazevVeci);
            if (pozadovanaVec == null){
                return standartniNazev + "je moc tezka, tu neuneses";
            } else if (!pozadovanaVec.isViditelna()) {
                return standartniNazev + "tu neni ty blazne";
            } else {
                if (plan.getBatuzek().vlozVec(pozadovanaVec))
                {
                return "Sebral jsi " + standartniNazev +"\n"+ plan.getAktualniProstor().dlouhyPopis();
                }
                return "Tam už se nic nevejde hele";
            }
        }
        return standartniNazev + "tu neni ty blazne";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
