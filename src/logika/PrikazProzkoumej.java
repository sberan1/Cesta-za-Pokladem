package logika;

import java.text.Normalizer;

public class PrikazProzkoumej implements IPrikaz{

    HerniPlan plan;
    final String NAZEV = "prozkoumej";

    public PrikazProzkoumej(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *
     *
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     *
     * @return textovy retezec obsahujici zpravu o tom co se stalo a dlouhy popis mistnosti
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "musis napsat co mam prozkoumat sakra";
        }
        if (parametry.length > 1) {
            return "Co z toho chces prozkoumat?";
        }

        if (Normalizer.normalize(parametry[0], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").equalsIgnoreCase(Normalizer.normalize(plan.getAktualniProstor().getNazev(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""))){
            StringBuilder navratovaHodnota = new StringBuilder();
            for (var item : plan.getAktualniProstor().schovaneProstory()) {
                item.setViditelnost(true);
                navratovaHodnota.append(" ").append(item.getNazev());
            }
            for (var item : plan.getAktualniProstor().getSchovaneSchovaneVeci()) {
                item.setViditelna(true);
                navratovaHodnota.append(" ").append(item.getNazev());
            }

            return "V místnosti " + plan.getAktualniProstor().getNazev() + " jsi našel" + navratovaHodnota + "\n" + plan.getAktualniProstor().dlouhyPopis();
        }
        return "tam nejsi, tak to prece nemuzes prozkoumat";
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
