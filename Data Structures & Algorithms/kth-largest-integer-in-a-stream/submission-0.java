class KthLargest {

    private PriorityQueue<Integer> heap;
    private Integer k;

    public KthLargest(int k, int[] nums) {
        
        this.heap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
