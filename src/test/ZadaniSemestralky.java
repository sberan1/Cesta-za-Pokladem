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

        assertEquals(hra.zpracujPrikaz("jdi chaloupka"), "Uspech");
    }
}
