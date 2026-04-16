class Solution {
    public int characterReplacement(String s, int k) {

        int[] counts = new int[26];

        int left = 0, right = 0, maxF = 0, maxL = 0;

        while (right < s.length()) {

            Character rightChar = s.charAt(right);
            counts[rightChar - 'A']++;
            maxF = Math.max(maxF, counts[rightChar - 'A']);

            while ((right - left + 1) - maxF > k) {
                Character leftChar = s.charAt(left);
                counts[leftChar - 'A']--;
                left++;
            }

            maxL = Math.max(maxL, right - left + 1);
            right++;
        }

        return maxL;
    }
}