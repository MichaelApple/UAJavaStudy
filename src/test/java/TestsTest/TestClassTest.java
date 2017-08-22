package TestsTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Miha on 24.07.2017.
 */
public class TestClassTest {

    TestClass testClass;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Rule
    public final Timeout timeout = new Timeout(1000);

    @Before
    public void initTestClass() {
        testClass = new TestClass();
    }
    @Test(timeout = 10)
    public void deduct() throws Exception {
        int result = testClass.deduct(3,2);
        assertTrue(result == 1);
    }

    @Test(expected = ArithmeticException.class)
    public void div() throws Exception {
        Optional<Integer> optional = Optional.empty();
        Optional<Integer> actualResult = Optional.ofNullable(testClass.div(5, 0));
        assertEquals(optional, actualResult);
    }
    @Ignore
    @Test
    public void multiply() throws Exception {
        assertEquals(6, testClass.multiply(3,2));
    }

    @Test
    public void add() throws Exception {
        int result = testClass.deduct(3,2);
        assertNull(null);
        assertNotNull(result);
    }
}