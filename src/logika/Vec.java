package logika;

import java.text.Normalizer;

public class Vec {

    private String nazev;

    private boolean prenositelna;

    private boolean viditelna;

    private boolean pouzitelna;
    private Pouzitelnosti typ;
    private int modifikator;

    public Vec(String nazev, boolean prenositelna, boolean viditelna, Pouzitelnosti typ, int modifikator) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.viditelna = viditelna;
        pouzitelna = true;
        this.typ = typ;
        this.modifikator = modifikator;
    }

    /**
     *
     * @param nazev - nazev veci, jednoznacny identifikator
     * @param prenositelnost - Parametr, ktery urcuje jestli je mozne vec umistit do batohu a prenaset
     */
    public Vec(String nazev, boolean prenositelnost, boolean viditelnost) {
        this.nazev = nazev;
        this.prenositelna = prenositelnost;
        this.viditelna = viditelnost;
        pouzitelna = false;
        typ = null;
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

    public boolean isPouzitelna() {
        return pouzitelna;
    }

    public Pouzitelnosti getTyp() {
        return typ;
    }

    public int getModifikator() {
        return modifikator;
    }
}
