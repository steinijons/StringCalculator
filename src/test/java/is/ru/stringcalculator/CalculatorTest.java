package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

     @Test
    public void testMultipleLines(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test(expected = RuntimeException.class)
    public void negativeException() {
        Calculator.add("-1,2");
    }

    @Test
    public final void negativeThrown() {
        RuntimeException exception = null;
        try {
                Calculator.add("1,-2");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertEquals("Negatives not allowed: [-2]", exception.getMessage());
    } 

    @Test
        public void testIllegalNumBiggerThan1000(){
                assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testDelimeterGiven(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }


}