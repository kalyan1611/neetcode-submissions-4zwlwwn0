class Solution {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int left = 0;
        int right = 0;
        int maxLength  = 0;
        Map<Character, Integer> charCount = new HashMap<>();

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
