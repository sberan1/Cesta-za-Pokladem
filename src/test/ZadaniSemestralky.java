import logika.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZadaniSemestralky {
    
    private Hra hra;
    
    @BeforeEach
    public void setUp(){
        hra = new Hra();
    }

    @AfterEach
    void tearDown() {
        hra = new Hra();
    }

    @Test
    void testPrubehuHry() {
            assertEquals("domeček", hra.getHerniPlan().getAktualniProstor().getNazev());
            hra.zpracujPrikaz("jdi les");
            assertEquals("les", hra.getHerniPlan().getAktualniProstor().getNazev());
            assertFalse(hra.konecHry());
            hra.zpracujPrikaz("konec");
            assertTrue(hra.konecHry());

    }


    // zde bude probihat test Hry, ktery bude slouzit jako zadani semestralni prace
    @Test
    void testHry() {

        /**
         * Mapa generovana pomoci online nastroje - inkarnate.com
         *
         * Mapa se nachazi v adresari souboru ve slozce dalsi soubory - nazev souboru mapa.jpeg
         *
         * ve slozce se take nachazi textovy soubor popisujici co jde v jakych prostorech najit za vychody a predmety
         *
         */
        //Uvítání - zapnutí hry
        assertEquals(hra.vratUvitani(),  "Vítej v adventuře, kde je tvým cílem dojít do zamčené " +
                "shované místnosti v čarodějově věži kde čaroděj shovává všechno ukradené zlato.\n" +
                "Čeká tě těžký průchod a budeš muset cestou posbírat několik předmětů.\n " +
                "Napište 'nápověda', pokud si nevíte rady, jak hrát dál. \n" +
                "Počet životů 100/100\n" +
                "Momentálně se nacházíš v prostoru: Město\n" +
                "Věci v místnosti: MrtváKrysa Střepy Barel Lampa\n" +
                "Východy: Hospoda Kostel Les HlubokýLes Hory\n" +
                "Zamčené východy: DůmKováře Stodola\n" +
                "Aktuální předměty v batohu: V batohu nemáš nic\n" +
                "Kapacita batohu: 0/15");

        //1. krok jdi kostel
        assertEquals(hra.zpracujPrikaz("jdi kostel"),
                "Kostel -  Místo, kde jsme blíže bohu a můžeme zde najít\n" +
                "Počet životů 100/100\n" +
                "Momentálně se nacházíš v prostoru: Kostel\n" +
                "Věci v místnosti: Róba Žezlo Lavice\n" +
                "Východy: Město\n" +
                "Aktuální předměty v batohu: V batohu nemáš nic\n" +
                "Kapacita batohu: 0/15");

        //2. krok prozkoumej kostel
        assertEquals(hra.zpracujPrikaz("prozkoumej kostel"),
                "V místnosti Kostel jsi našel Klíč LektvarŽivota\n" +
                "Počet životů 100/100\n" +
                "Momentálně se nacházíš v prostoru: Kostel\n" +
                "Věci v místnosti: Róba Žezlo Lavice Klíč LektvarŽivota\n" +
                "Východy: Město\n" +
                "Aktuální předměty v batohu: V batohu nemáš nic\n" +
                "Kapacita batohu: 0/15");
        //3. krok seber klic
        assertEquals(hra.zpracujPrikaz("seber klic"), "Sebral jsi Klíč\n" +
                "Počet životů 100/100\n" +
                "Momentálně se nacházíš v prostoru: Kostel\n" +
                "Věci v místnosti: Róba Žezlo Lavice LektvarŽivota\n" +
                "Východy: Město\n" +
                "Aktuální předměty v batohu: Klíč\n" +
                "Kapacita batohu: 1/15");
        //4.krok seber lektvarzivota
        assertEquals(hra.zpracujPrikaz("seber lektvarzivota"), "Sebral jsi LektvarŽivota\n" +
                "Počet životů 100/100\n" +
                "Momentálně se nacházíš v prostoru: Kostel\n" +
                "Věci v místnosti: Róba Žezlo Lavice\n" +
                "Východy: Město\n" +
                "Aktuální předměty v batohu: Klíč LektvarŽivota\n" +
                "Kapacita batohu: 2/15");
        //5. krok jdi mesto
        assertEquals(hra.zpracujPrikaz("jdi mesto"),"Město - Tady se děje všechno svaté i nesvaté\n" +
                "Počet životů 100/100\n" +
                "Momentálně se nacházíš v prostoru: Město\n" +
                "Věci v místnosti: MrtváKrysa Střepy Barel Lampa\n" +
                "Východy: Hospoda Kostel Les HlubokýLes Hory\n" +
                "Zamčené východy: DůmKováře Stodola\n" +
                "Aktuální předměty v batohu: Klíč LektvarŽivota\n" +
                "Kapacita batohu: 2/15");
        //6.krok odemkni dumkovare
        assertEquals(hra.zpracujPrikaz("odemkni dumkovare"),"Odemkl jsi DůmKováře\n" +
                "Počet životů 100/100\n" +
                "Momentálně se nacházíš v prostoru: Město\n" +
                "Věci v místnosti: MrtváKrysa Střepy Barel Lampa\n" +
                "Východy: Hospoda Kostel Les DůmKováře HlubokýLes Hory\n" +
                "Zamčené východy: Stodola\n" +
                "Aktuální předměty v batohu: LektvarŽivota\n" +
                "Kapacita batohu: 1/15");
        //7.krok jdi dumkovare
        assertEquals(hra.zpracujPrikaz("jdi dumkovare"),"DůmKováře - tady bydlí kovář\n" +
                "Počet životů 100/100\n" +
                "Momentálně se nacházíš v prostoru: DůmKováře\n" +
                "Věci v místnosti: Meč Stůl Nůž\n" +
                "Východy: Město\n" +
                "Aktuální předměty v batohu: LektvarŽivota\n" +
                "Kapacita batohu: 1/15");
        assertEquals(hra.zpracujPrikaz("seber lektvarzivota"),"");
        assertEquals(hra.zpracujPrikaz("seber lektvarzivota"),"");
        assertEquals(hra.zpracujPrikaz("seber lektvarzivota"),"");
        assertEquals(hra.zpracujPrikaz("seber lektvarzivota"),"");
        assertEquals(hra.zpracujPrikaz("seber lektvarzivota"),"");
        assertEquals(hra.zpracujPrikaz("seber lektvarzivota"),"");


    }
}
