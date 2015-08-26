package leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yufeijiang on 8/25/15.
 */
public class ZigZagTest {

    private ZigZag zigZag;

    @Before
    public void setUp() throws Exception {
        zigZag=new ZigZag();
    }

    @org.junit.Test
    public void testConvert() throws Exception {
        zigZag.convert("AB", 2);
    }

    @Test
    public void testCovertII() throws Exception {
        zigZag.convert("ABCD", 2);
    }
}