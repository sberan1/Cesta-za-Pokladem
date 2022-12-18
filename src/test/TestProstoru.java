import logika.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestProstoru {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testLzeProjit() {
        Prostor prostor1 = new Prostor("hala", "xxxx", new HerniPlan());
        Prostor prostor2 = new Prostor("bufet", "yyyy", new HerniPlan());

        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);

        assertEquals(prostor2, prostor1.vratSousedniProstor("bufet"));
        assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
    }

    @Test
    void testNavratoveHodnotyObjektuPriObjektuVec() {

        Vec neco = new Vec("neco", true, true);
        Prostor prostor = new Prostor("nazev", "popis", null);

        Object o = 20;

        assertEquals(((Object) neco).getClass().getName(), "logika.Vec");
        assertEquals(((Object) prostor).getClass().getName(), "logika.Prostor");
        assertEquals(o.getClass().getName(), "java.lang.Integer");
    }
}
