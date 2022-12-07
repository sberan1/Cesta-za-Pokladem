package logika;

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
        if (predmety == ""){
            return "V batohu nemáš nic";
        }
        return predmety;
    }
}
