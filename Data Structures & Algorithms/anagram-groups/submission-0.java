class Solution {

    public String generateKey(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return Arrays.toString(freq);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for (String str : strs) {
            String key = generateKey(str);
            groupedAnagrams.putIfAbsent(key, new ArrayList<>());
            groupedAnagrams.get(key).add(str);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }
}
