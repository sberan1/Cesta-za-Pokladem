package logika;

import java.text.Normalizer;

public class PrikazPouzij implements IPrikaz{

    final String NAZEV = "pouzij";
    private HerniPlan plan;

    public PrikazPouzij(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "musis napsat co mam pouzit";
        }
        if (parametry.length > 1) {
            return "Co z toho chces pouzit?";
        }
        for (var item : plan.getBatuzek().getObsah()) {
            if (Normalizer.normalize(parametry[0], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").equalsIgnoreCase(item.getNormalizedNazev()) && item.isPouzitelna()){
                plan.getBatuzek().odeberVec(item.getNazev());
                if (item.getTyp() == Pouzitelnosti.Lektvar){
                    plan.uberZivoty(-item.getModifikator());
                    if (plan.getPocetZivotu() > 100){
                        plan.uberZivoty(plan.getPocetZivotu()-100);
                        return "Použil jsi " + item.getNazev() + "\n" + plan.getAktualniProstor().dlouhyPopis();
                    }
                }
                if (item.getTyp() == Pouzitelnosti.Brneni){
                    int brneni = 0;
                    brneni += item.getModifikator();
                }
                if (item.getTyp() == Pouzitelnosti.Zbran) {
                    int poskozeni = 0;
                    poskozeni += item.getModifikator();
                }
                }
                }
        return "bud to nemas v batohu nebo to nemuzes pouzit";
            }




    /**
     * @return
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
