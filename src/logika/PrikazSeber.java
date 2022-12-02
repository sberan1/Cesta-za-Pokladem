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
        if (parametry.length > 1){
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
                if (plan.getBatuzek().vlozVec(pozadovanaVec))
                {
                return "sebral jsi" + nazevVeci +"\n"+ plan.getAktualniProstor().dlouhyPopis();
                }
                return "Tam už se nic nevejde hele";
            }
        }
        return nazevVeci + "tu neni ty blazne";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
