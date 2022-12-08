package logika;

import java.text.Normalizer;

public class Vec {

    private String nazev;

    private boolean prenositelna;

    private boolean viditelna;

    /**
     *
     * @param nazev - nazev veci, jednoznacny identifikator
     * @param prenositelnost - Parametr, ktery urcuje jestli je mozne vec umistit do batohu a prenaset
     */
    public Vec(String nazev, boolean prenositelnost, boolean viditelnost) {
        this.nazev = nazev;
        this.prenositelna = prenositelnost;
        this.viditelna = viditelnost;
    }

    /**
     * Vraci nazev veci
     *
     * @return nazev veci
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vraci prenositelnost predmetu
     *
     * @return prenositelnost veci
     */
    public boolean jePrenositelna() {
        return prenositelna;
    }

    /**
     * Vraci viditelnost predmetu, respektive informaci o tom, zda je predmet v mistnosti schovany, nebo je videt na prvni pohled.
     *
     * @return viditelnost veci
     */
    public boolean isViditelna() {
        return viditelna;
    }

    /**
     * Dovoluje nam nastavit viditelnost predmetu v mistnosti
     *
     * @param viditelna - parametr urcujici jestli ma byt predmet viditelny v mistnosti
     */
    public void setViditelna(boolean viditelna) {
        this.viditelna = viditelna;
    }

    public String getNormalizedNazev(){
        return Normalizer.normalize(nazev, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
    }
}
