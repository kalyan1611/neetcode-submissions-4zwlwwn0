class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Coordinate> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.x*a.x+a.y*a.y, b.x*b.x+b.y*b.y);
        });

        for (int[] point : points) {
            pq.offer(new Coordinate(point[0], point[1]));
        }

        int[][] kClosest = new int[k][2];

        for (int i = 0; i < k; i++) {
            Coordinate point = pq.poll();
            kClosest[i][0] = point.x;
            kClosest[i][1] = point.y;
        }

        return kClosest;
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
