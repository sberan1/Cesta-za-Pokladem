package logika;

public class Vec {

    private String nazev;

    private boolean prenositelna;

    /**
     *
     * @param nazev - nazev veci, jednoznacny identifikator
     * @param prenositelnost - Parametr, ktery urcuje jestli je mozne vec umistit do batohu a prenaset
     */
    public Vec(String nazev, boolean prenositelnost) {
        this.nazev = nazev;
        this.prenositelna = prenositelnost;
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
}
