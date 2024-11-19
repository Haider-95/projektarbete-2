package Model;

import static org.junit.jupiter.api.Assertions.*;

import Model.Entity;
import Model.Burglar;
import Model.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityTest {
    Resident resident;
    Burglar burglar;

    @BeforeEach
    void stats() {
        burglar = new Burglar("burglar", 20, 5);
        resident = new Resident("resident", 15, 3);
    }

    @Test
    void testPunch() {
        resident.punch(burglar);
        assertEquals(17, burglar.getHealth());
    }
    @Test
    void testtakeHit(){
       resident.takeHit(10);
       assertEquals(5, resident.getHealth());
    }
    @Test
    void testisConsciousTrue(){
        resident.takeHit(10);
        assertTrue(resident.isConscious());

    }
    @Test
    void testisConsciousFalse(){
        resident.takeHit(15);
        assertFalse(resident.isConscious());
    }
}


        //testa gethit och boolean isConscious
        //assert true i ett test och false i andra för boolean två st
