import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // Returns all palindrome partitionings of the string s
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    // Helper function to perform backtracking
    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // If we've reached the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }
        
        // Try all possible partitions starting at 'start'
        for (int end = start; end < s.length(); end++) {
            // If the substring s[start...end] is a palindrome, proceed
            if (isPalindrome(s, start, end)) {
                // Add the palindrome substring to the current partition
                currentPartition.add(s.substring(start, end + 1));
                // Recurse for the remaining substring starting from end+1
                backtrack(s, end + 1, currentPartition, result);
                // Backtrack: remove the last added substring and try another partition
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    // Helper function to check if the substring s[low...high] is a palindrome
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> partitions = solution.partition(s);
        System.out.println("Palindrome Partitionings for \"" + s + "\": " + partitions);
    }
}
