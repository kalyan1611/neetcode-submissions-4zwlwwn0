class Solution {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        if (n == 0) return 0;

        int left = 0;
        int right = 1;
        int maxLength  = 1;
        Map<Character, Integer> charCount = new HashMap<>();

        charCount.put(s.charAt(0), 1);

        while (left <= right && right < n) {

            Character rightChar = s.charAt(right);
            Character leftChar = s.charAt(left);

            if (charCount.getOrDefault(rightChar, 0) > 0) {
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++;
            } else {
                charCount.put(rightChar, 1);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
        }

        return maxLength;
    }
}
