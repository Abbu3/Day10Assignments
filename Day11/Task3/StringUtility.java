package Task3;

	public class StringUtility {

	    public boolean isPalindrome(String str) { //palindrome
	        if (str == null || str.isEmpty()) {
	            return false;
	        }
	        String reversed = new StringBuilder(str).reverse().toString();
	        return str.equals(reversed);
	    }

	    public String reverseString(String str) {
	        if (str == null) {
	            return null;
	        }
	        return new StringBuilder(str).reverse().toString();
	    }

	    // Method to check if a string is empty or null
	    public boolean isEmpty(String str) {
	        return str == null || str.isEmpty();
	    }
	}


