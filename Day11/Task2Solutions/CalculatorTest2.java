package Task2Solutions;


	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.Test;

import Task1.Calculator;

	public class CalculatorTest2 {

	    private Calculator calculator;

	    // This method runs once before any tests run (static context).
	    @BeforeAll
	    public static void setUpBeforeClass() {
	        System.out.println("Before all tests.");
	    }

	    // This method runs once after all tests are completed (static context).
	    @AfterAll
	    public static void tearDownAfterClass() {
	        System.out.println("After all tests.");
	    }

	    // This method runs before each test.
	    @BeforeEach
	    public void setUp() {
	        calculator = new Calculator(); // Initialize the calculator object before each test
	        System.out.println("Before each test.");
	    }

	    // This method runs after each test.
	    @AfterEach
	    public void tearDown() {
	        calculator = null; // Clean up the calculator object after each test
	        System.out.println("After each test.");
	    }

	    @Test
	    public void testAdd() {
	        System.out.println("Running testAdd");
	        assertEquals(5, calculator.add(2, 3));
	    }

	    @Test
	    public void testSub() {
	        System.out.println("Running testSub");
	        assertEquals(1, calculator.sub(3, 2));
	    }

	    @Test
	    public void testMul() {
	        System.out.println("Running testMul");
	        assertEquals(6, calculator.mul(2, 3));
	    }

	    @Test
	    public void testDiv() {
	        System.out.println("Running testDiv");
	        assertEquals(2, calculator.div(6, 3));
	    }

	    @Test
	    public void testDivByZero() {
	        System.out.println("Running testDivByZero");
	        assertThrows(ArithmeticException.class, () -> calculator.div(1, 0));
	    }
	}


