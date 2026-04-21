class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1]);
        });

        for (int[] point : points) {
            pq.offer(point);
        }

        int[][] kClosest = new int[k][2];

        for (int i = 0; i < k; i++) {
            kClosest[i] = pq.poll();
        }
        return kClosest;
    }
}
