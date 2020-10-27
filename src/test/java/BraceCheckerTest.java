import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BraceCheckerTest {
    @Test
    public void testValid() {
        BraceChecker checker = new BraceChecker();
        assertEquals(true, checker.isValid("()"));
        assertEquals(true, checker.isValid("{}"));
        assertEquals(true, checker.isValid("(){}[]"));
        assertEquals(true, checker.isValid("{}[]"));
        assertEquals(true, checker.isValid("([{}])"));
        assertEquals(true, checker.isValid("[{}]"));
        assertEquals(true, checker.isValid("({})[({})]"));
        assertEquals(true, checker.isValid("(({{[[]]}}))"));
        assertEquals(true, checker.isValid("(asd)"));
        assertEquals(true, checker.isValid("(({{[[asd]]}sss})aa)"));
    }

    @Test
    public void testInvalid() {
        BraceChecker checker = new BraceChecker();
        assertEquals(false, checker.isValid("[(])"));
    }
}
