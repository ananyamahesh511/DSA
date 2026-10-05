import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Count characters in p
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        int k = p.length();

        // Build the first window
        for (int i = 0; i < k; i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(pFreq, windowFreq)) {
            result.add(0);
        }

        // Slide the window
        for (int right = k; right < s.length(); right++) {
            // Remove the outgoing character
            char leftChar = s.charAt(right - k);
            windowFreq[leftChar - 'a']--;

            // Add the incoming character
            char rightChar = s.charAt(right);
            windowFreq[rightChar - 'a']++;

            // Compare frequencies
            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(right - k + 1);
            }
        }

        return result;
    }
}