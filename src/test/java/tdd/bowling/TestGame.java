package tdd.bowling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGame {
    private Game g;

    @Before
    public void getGame() {
        g = new Game();
    }
//
//    @Test
//    public void testOneThrow(){
//        g.add(5);
//        Assert.assertEquals(5, g.score());
//        Assert.assertEquals(1, g.getCurrentFrame());
//    }

    @Test
    public void testTwoThrowsNoMark(){
        g.add(5);
        g.add(4);

        Assert.assertEquals(9, g.score());
    }

    @Test
    public void testFourThrowsNoMark(){
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);

        Assert.assertEquals(18, g.score());
        Assert.assertEquals(9, g.scoreForFrame(1));
        Assert.assertEquals(18, g.scoreForFrame(2));
    }

    @Test
    public void testSimpleSpare(){
        g.add(3);
        g.add(7);
        g.add(3);

        Assert.assertEquals(13, g.scoreForFrame(1));
    }

    @Test
    public void testSimpleFrameAfterSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);

        Assert.assertEquals(13, g.scoreForFrame(1));
        Assert.assertEquals(18, g.scoreForFrame(2));
        Assert.assertEquals(18, g.score());
    }

    @Test
    public void testSimpleStrike(){
        g.add(10);
        g.add(3);
        g.add(6);
        Assert.assertEquals(19, g.scoreForFrame(1));
        Assert.assertEquals(28, g.score());
    }

    @Test
    public void testPerfectGame(){
        for(int i = 0; i<12; i++){
            g.add(10);
        }

        Assert.assertEquals(300, g.score());
    }

    @Test
    public void testEndOfArray(){
        for(int i = 0; i<9; i++){
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8);
        g.add(10);

        Assert.assertEquals(20, g.score());
    }
}
