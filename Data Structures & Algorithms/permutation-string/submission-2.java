class Solution {

    public boolean isPerm(int[] counts) {
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false;
        
        int[] counts = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']--;
        }

        int left = 0, right = 0;

        while (right < s2.length()) {
            
            while (right - left + 1 <= s1.length()) {
                counts[s2.charAt(right) - 'a']++;
                right++;
            }

            if (isPerm(counts)) return true;

            counts[s2.charAt(left) - 'a']--;
            left++;
        }

        return false;
    }
}
