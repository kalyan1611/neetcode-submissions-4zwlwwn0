class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> -Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = pq.poll()[0];
        }
        return topK;
    }
}
