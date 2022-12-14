package logika;

import java.util.ArrayList;
import java.util.Collections;

public class Vymena {
    private String popisVymeny;
    private ArrayList<Vec> ocekavaneVeci;
    private ArrayList<Object> navratoveHodnoty;
    private String kratkyNazev;
    private Object trestZaNesplneni;
    private String textKZobrazeni;

    /**
     * @param popisVymeny
     * @param kratkyNazev
     */
    public Vymena(String popisVymeny, String kratkyNazev, String textKZobrazeni) {
        this.popisVymeny = popisVymeny;
        this.kratkyNazev = kratkyNazev;
        this.textKZobrazeni = textKZobrazeni;
        this.trestZaNesplneni = null;
        navratoveHodnoty = new ArrayList<>();
        ocekavaneVeci = new ArrayList<>();
    }

    /**
     * @param ocekavanaVec
     */

    public void setOcekavaneVeci(Vec ocekavanaVec) {
        ocekavaneVeci.add(ocekavanaVec);
    }

    /**
     * @param navratovaHodnota
     */
    public void setNavratovaHodnota(Object navratovaHodnota) {
        navratoveHodnoty.add(navratovaHodnota);
    }

    /**
     * @return
     */
    public ArrayList<Vec> getOcekavaneVeci() {
        return (ArrayList<Vec>) ocekavaneVeci.clone();
    }

    /**
     * @return
     */
    public ArrayList<Object> getNavratoveHodnoty() {
        return (ArrayList<Object>) navratoveHodnoty.clone();
    }

    /**
     * @return
     */
    public String getPopisVymeny() {
        return popisVymeny;
    }

    /**
     * @return
     */
    public String getKratkyNazev() {
        return kratkyNazev;
    }

    /**
     *
     * @param trestZaNesplneni
     */
    public void setTrestZaNesplneni(Object trestZaNesplneni) {
        this.trestZaNesplneni = trestZaNesplneni;
    }

    /**
     *
     * @return
     */
    public Object getTrestZaNesplneni() {
        return trestZaNesplneni;
    }

    /**
     *
     * @return
     */
    public String getTextKZobrazeni() {
        return textKZobrazeni;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return popisVymeny + "pokud mas vsechny predmety tak to aktivujes napsanim vymen " + kratkyNazev ;
    }
}
