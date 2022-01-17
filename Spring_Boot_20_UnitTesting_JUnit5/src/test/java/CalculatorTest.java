import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUpEach(){
        System.out.println("BeforeEach executed");
    }

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll executed");
    }

    @AfterAll
    static void tearAll(){
        System.out.println("AfterAll executed");
    }

    @AfterEach
    void tearEach(){
        System.out.println("AfterEach executed");
    }


    @Test
    void testCase1(){
        System.out.println("TC1 executed");
        assertEquals(20,20);
    }

    @Test
    void testCase2(){
        System.out.println("TC2 executed");
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3(){
        System.out.println("TC3 executed");
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
    }

    @Test
    void testCase4(){
        System.out.println("TC4 executed");
        String nullString = null;
        String notNullString = "Cybertek";

        assertNotNull(notNullString);
//        assertNotNull(nullString);
        assertNull(nullString);
    }

    @Test
    void testCase5(){
        System.out.println("TC5 executed");
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertNotSame(c1,c3); // not same object...
//        assertNotSame(c1,c2);
        assertSame(c1,c2);
    }


    @Test
    void add() {
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);
    }


}