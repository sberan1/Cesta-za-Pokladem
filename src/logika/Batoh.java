package logika;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Batoh {
    private int velikostBatuzku;
    private List<Vec> obsah;

    /**
     *
     * @param velikostKosicku
     */
    public Batoh(int velikostKosicku) {
        this.velikostBatuzku = velikostKosicku;
        obsah = new ArrayList<Vec>();
    }
    /**
     *
     * @return
     */
    public boolean vlozVec(Vec neco){
        if(obsah.size() < velikostBatuzku){
            obsah.add(neco);
            return true;
        }
            return false;

    }

    /**
     *
     * @param nazev
     * @return
     */
    public boolean odeberVec(String nazev){
        String normalizedNazev = Normalizer.normalize(nazev, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        for (var item : obsah){
            if (normalizedNazev.equals(item.getNormalizedNazev())){
                obsah.remove(item);
                return true;
            }
        }
        return false;
    }
    /**
     *
     * @return
     */
    public int getVelikostBatuzku() {
        return obsah.size();
    }

    /**
     *
     * @return
     */
    public String getPredmetyVBatohu(){
        String predmety = "";
        for (var item : obsah) {
            predmety += " " + item.getNazev();
        }
        if (predmety.equals("")){
            return " V batohu nemáš nic";
        }
        return predmety;
    }
}
