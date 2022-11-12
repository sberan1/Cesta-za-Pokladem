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
        assertEquals(hra.vratUvitani(), "Vítejte!\n" +
                "Toto je příběh o Červené Karkulce, babičce a vlkovi.\n" +
                "Napište 'nápověda', pokud si nevíte rady, jak hrát dál.\n" +
                "\n" +
                "Jsi v mistnosti/prostoru domeček, ve kterém bydlí Karkulka.\n" +
                "východy: les");

        //1. krok jdi les
        assertEquals(hra.zpracujPrikaz("jdi les"), "Jsi v mistnosti/prostoru les s jahodami, malinami a pramenem vody.\n" +
                "východy: domeček hluboký_les");

        //2. krok jdi hluboký_les
        assertEquals(hra.zpracujPrikaz("jdi hluboký_les"), "Jsi v mistnosti/prostoru temný les, ve kterém lze potkat vlka.\n" +
                "východy: Sousedni_domecek chaloupka jeskyně les");
    }
}
