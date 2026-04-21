class Solution {
    public int leastInterval(char[] tasks, int n) {

        var scheduler = new PriorityQueue<Integer>(Comparator.reverseOrder());

        int[] charFreq = new int[26];

        var queue = new ArrayDeque<int[]>();

        for (char task : tasks) {
            charFreq[task - 'A']++;
        }

        for (int charCount : charFreq) {
            if (charCount > 0) {
                scheduler.offer(charCount);
            }
        }
        
        int t = 0;

        while (!scheduler.isEmpty() || !queue.isEmpty()) {

            if (!queue.isEmpty() && queue.peek()[1] == t) {
                scheduler.offer(queue.poll()[0]);
            }
            
            if (!scheduler.isEmpty()) {
                int cur = scheduler.poll();
                if (cur > 1) {
                    queue.add(new int[]{cur - 1, t + n + 1});
                }
            }
            t++;
        }

        return t;
    }
}