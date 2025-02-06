package Task1Solution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Task1.Calculator;

class CalculatorTest {

	
	    @Test
	    public void testAdd() {
	        Calculator calculator = new Calculator();
	        assertEquals(5, calculator.add(2, 3));
	    }

	    @Test
	    public void testSub() {
	        Calculator calculator = new Calculator();
	        assertEquals(1, calculator.sub(3, 2));
	    }

	    @Test
	    public void testMul() {
	        Calculator calculator = new Calculator();
	        assertEquals(6, calculator.mul(2, 3));
	    }

	    @Test
	    public void testDiv() {
	        Calculator calculator = new Calculator();
	        assertEquals(2, calculator.div(6, 3));
	    }

	    @Test
	    public void testDivByZero() {
	        Calculator calculator = new Calculator();
	        assertThrows(ArithmeticException.class, () -> calculator.div(1, 0));
	    }
	
}





