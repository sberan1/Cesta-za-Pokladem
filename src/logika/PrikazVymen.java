package logika;

import java.text.Normalizer;

public class PrikazVymen implements IPrikaz{
    final String NAZEV = "vymen";
    private HerniPlan plan;

    public PrikazVymen(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return
     */
    @Override
    public String provedPrikaz(String... parametry) {
        int counter = 0; //pomocna promenna pro zjisteni, zda ma uzivatel vsechny potrebne veci u sebe
        Vymena vymena = plan.getAktualniProstor().getVymena(); //ulehceni pristupu k vymene v aktualnim prostoru
        if (vymena != null) {
            if (parametry.length == 0) {
                return "musis napsat co chces vymenit";
            }
            if (parametry.length > 1) {
                return "Co z toho chces vymenit?";
            }
            if (Normalizer.normalize(parametry[0], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").equalsIgnoreCase(Normalizer.normalize(vymena.getKratkyNazev(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""))) {
                //zkoumame, jestli ma uzivatel vsechny potrebne veci a podle toho inicializujeme prikaz
                for (var item : vymena.getOcekavaneVeci()){
                   if(plan.getBatuzek().getObsah().contains(item)){
                       counter++;
                   }
                }
                if (counter == vymena.getOcekavaneVeci().size()){
                    for (var item : vymena.getOcekavaneVeci()){
                        plan.getBatuzek().odeberVec(item.getNazev());
                    }
                    for (var item : vymena.getNavratoveHodnoty()){
                        if (item.getClass().getName().equals("java.lang.Integer")) {
                            plan.uberZivoty((Integer) item);
                        }
                        if (item.getClass().getName().equals("logika.Vec")){
                            plan.getBatuzek().vlozVec((Vec) item);
                        }
                        if (item.getClass().getName().equals("logika.Prostor")){
                            Prostor placeholder = (Prostor) item;
                            for (var prostor : placeholder.getVychody()){
                                if (prostor.getZivotnost() == 999){

                                }
                                else {
                                    prostor.nastavPast(prostor.getZivotnost()-1);
                                }
                            }
                            plan.setAktualniProstor((Prostor) item);
                        }
                    }
                    if (vymena.getOdemceniMistnosti()[0] != null && vymena.getOdemceniMistnosti()[1] != null){
                        vymena.getOdemceniMistnosti()[0].setVychod(vymena.getOdemceniMistnosti()[1]);
                    }
                    return vymena.getTextKZobrazeni() + "\n" + plan.getAktualniProstor().dlouhyPopis();
                }
                if (vymena.getTrestZaNesplneni() != null){
                    Object item = vymena.getTrestZaNesplneni();
                    if (item.getClass().getName().equals("java.lang.Integer")) {
                        plan.uberZivoty((Integer) item);
                    }
                    if (item.getClass().getName().equals("logika.Prostor")){
                        plan.setAktualniProstor((Prostor) item);
                    }
                    return "nesplnil jsi vymenu, potkal te trest" + plan.getAktualniProstor().dlouhyPopis();
                }
                return "nemas potrebne veci pro tuto vymenu, bez hledat";
            }
            return "tohle tu neni, zkus zadat prikaz vymeny a podivat se co muzes vymenit";
        }
        return "hele tady neni moc co vymenovat";
    }

    /**
     * @return
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}

