package Task3Solution;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import Task3.StringUtility;

public class StringUtilityTest {

    private StringUtility stringUtility;

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("Before all tests.");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("After all tests.");
    }

    @BeforeEach
    public void setUp() {
        stringUtility = new StringUtility(); 
        System.out.println("Before each test.");
    }

    @AfterEach
    public void tearDown() {
        stringUtility = null; 
        System.out.println("After each test.");
    }

    @Test
    public void testIsPalindromeTrue() {
        System.out.println("Running testIsPalindromeTrue");
        assertTrue(stringUtility.isPalindrome("madam"));
    }

    @Test
    public void testIsPalindromeFalse() {
        System.out.println("Running testIsPalindromeFalse");
        assertFalse(stringUtility.isPalindrome("hello"));
    }

    @Test
    public void testReverseString() {
        System.out.println("Running testReverseString");
        assertEquals("olleh", stringUtility.reverseString("hello"));
    }

    @Test
    public void testIsEmptyTrue() {
        System.out.println("Running testIsEmptyTrue");
        assertTrue(stringUtility.isEmpty(""));
    }

    @Test
    public void testIsEmptyFalse() {
        System.out.println("Running testIsEmptyFalse");
        assertFalse(stringUtility.isEmpty("non-empty"));
    }
}
