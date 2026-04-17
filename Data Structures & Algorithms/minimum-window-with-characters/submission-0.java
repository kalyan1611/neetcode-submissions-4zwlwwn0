class Solution {

    public boolean isMatch(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
        for (Map.Entry<Character, Integer> tEntry : tCount.entrySet()) {
            if (sCount.getOrDefault(tEntry.getKey(), 0) < tCount.getOrDefault(tEntry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, minL = Integer.MAX_VALUE, min_i = -1, min_j = -1;

        for (int right = 0; right < s.length(); right++) {
            sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0) + 1);
            while (left < right && (sCount.get(s.charAt(left)) > tCount.getOrDefault(s.charAt(left), 0))) {
                sCount.put(s.charAt(left), sCount.get(s.charAt(left)) - 1);
                left++;
            }
            if (isMatch(sCount, tCount)) {
                if (right - left + 1 < minL) {
                    minL = right - left + 1;
                    min_i = left;
                    min_j = right;
                }
            } 
        }
        return (minL == Integer.MAX_VALUE) ? "" : s.substring(min_i, min_j + 1);
    }
}
