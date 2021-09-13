package cmpt276.as1.plainoldjava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MyClassTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFive() {
        assertEquals(5, MyClass.getFive());
    }
}