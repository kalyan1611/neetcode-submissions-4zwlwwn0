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
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        
        if (isPerm(counts)) return true;

        for (int left = 1, right = s1.length(); right < s2.length(); left++, right++) {
            counts[s2.charAt(left - 1) - 'a']++;
            counts[s2.charAt(right) - 'a']--;
            if (isPerm(counts)) return true;
        }

        return false;
    }
}
