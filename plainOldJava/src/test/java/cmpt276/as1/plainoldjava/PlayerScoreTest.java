package cmpt276.as1.plainoldjava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cmpt276.as1.plainoldjava.model.PlayerScore;

class PlayerScoreTest {

    @Test
    void test1() {
        PlayerScore test1 = new PlayerScore(4,15,1);
        assertEquals(-10, test1.getScore());
    }

    @Test
    void test2() {
        PlayerScore test2 = new PlayerScore(10,30,2);
        assertEquals(50, test2.getScore());
    }

    @Test
    void test3() {
        PlayerScore test3 = new PlayerScore(5,40,2);
        assertEquals(60, test3.getScore());
    }

    @Test
    void test4() {
        PlayerScore test4 = new PlayerScore(4,40,2);
        assertEquals(60, test4.getScore());
    }

    @Test
    void test5() {
        PlayerScore test5 = new PlayerScore(2,10,1);
        assertEquals(-20, test5.getScore());
    }

    @Test
    void test6() {
        //should throw exception
        PlayerScore test6 = new PlayerScore(0,10,1);
    }

    @Test
    void test7() {
        PlayerScore test7 = new PlayerScore(0,0,0);
        assertEquals(0, test7.getScore());
    }

    @Test
    void paramtest1() {
        //should throw exception
        PlayerScore test8 = new PlayerScore(-2,10,1);
    }

    @Test
    void paramtest2() {
        //should throw exception
        PlayerScore test9 = new PlayerScore(5,-10,1);
    }

    @Test
    void paramtest3() {
        //should throw exception
        PlayerScore test10 = new PlayerScore(2,10,-1);
    }
}