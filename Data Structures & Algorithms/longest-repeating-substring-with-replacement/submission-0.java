class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        Map<Character, Integer> dict = new HashMap<>();

        int left = 0, maxF = 0, max = 0;

        for (int right = 0; right < n; right++) {

            Character rightChar = s.charAt(right);
            dict.put(rightChar, dict.getOrDefault(rightChar, 0) + 1);
            maxF = Math.max(maxF, dict.get(rightChar));

            while ((right - left + 1) - maxF > k) {
                Character leftChar = s.charAt(left);
                dict.put(leftChar, dict.get(leftChar) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}