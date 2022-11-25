package logika;

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
        if (parametry.length >= 0){
            return "Co z toho chces sebrat? Blazne!";
        }


        String nazevVeci = parametry[0];
        Prostor aktualniProstor = plan.getAktualniProstor();
        if (aktualniProstor.obsahujeVec(nazevVeci)){
            Vec pozadovanaVec = aktualniProstor.vyberVeci(nazevVeci);
            if (pozadovanaVec == null){
                return nazevVeci + "je moc tezka, tu neuneses";
            }
            else {
                //TODO vlozit tu sracku do batohu
                return nazevVeci + "jsi hodil do batohu" + plan.getAktualniProstor().dlouhyPopis();
            }
        }else {
            return nazevVeci + "tu neni ty blazne";
        }

    }

    @Override
    public String getNazev() {
        return null;
    }
}
