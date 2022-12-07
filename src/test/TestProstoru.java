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
}
