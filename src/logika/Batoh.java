package logika;

import java.util.ArrayList;
import java.util.List;

public class Batoh {
    private int velikostBatuzku;
    private List<Vec> obsah;

    public Batoh(int velikostKosicku) {
        this.velikostBatuzku = velikostKosicku;
        obsah = new ArrayList<Vec>();
    }

    public boolean vlozVec(Vec neco){
        if(obsah.size() < velikostBatuzku){
            obsah.add(neco);
            return true;
        }
            return false;

    }

    public int getVelikostBatuzku() {
        return velikostBatuzku;
    }
}
