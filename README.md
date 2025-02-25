# Palindrome-Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
Explanation:
Backtracking Approach:

The function backtrack attempts to partition the string starting at index start.
For every possible substring s[start...end], if it is a palindrome (verified by isPalindrome), it is added to the current partition.
The function then recurses on the remaining substring starting from end + 1.
When the end of the string is reached (start == s.length()), the current partition is complete and added to the result.
Checking for Palindromes:

The helper method isPalindrome checks if the characters in the substring s[low...high] are the same when read from both ends.
Result:

All valid partitions are stored in the result list and returned by the partition method.
