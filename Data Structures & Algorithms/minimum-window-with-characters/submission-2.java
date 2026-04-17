class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, minL = Integer.MAX_VALUE, min_i = -1, min_j = -1;
        int need = t.length(), have = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            sCount.put(rightChar, sCount.getOrDefault(rightChar, 0) + 1);

            if (sCount.get(rightChar) <= tCount.getOrDefault(rightChar, 0)) {
                have++;
            }
            
            while (left < right && (sCount.get(s.charAt(left)) > tCount.getOrDefault(s.charAt(left), 0))) {
                sCount.put(s.charAt(left), sCount.get(s.charAt(left)) - 1);
                left++;
            }

            if (have == need && right - left + 1 < minL) {
                minL = right - left + 1;
                min_i = left;
                min_j = right;
            } 
        }

        return (minL == Integer.MAX_VALUE) ? "" : s.substring(min_i, min_j + 1);
    }
}
