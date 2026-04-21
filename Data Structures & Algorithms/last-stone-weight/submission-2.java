class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> -Integer.compare(a,b));
        for (int weight : stones) {
            pq.offer(weight);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != b) {
                pq.offer(Math.abs(a - b));
            }
        }

        return (pq.size() > 0) ? pq.poll() : 0;
    }
}
