class Solution {
    public int leastInterval(char[] tasks, int n) {

        var scheduler = new PriorityQueue<Integer>(Comparator.reverseOrder());

        var map = new HashMap<Character, Integer>();

        var queue = new ArrayDeque<int[]>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (var entry : map.entrySet()) {
            scheduler.offer(entry.getValue());
        }

        int t = 0;

        while (scheduler.size() > 0 || queue.size() > 0) {
            t++;

            if (queue.size() > 0 && queue.peek()[1] == t) {
                scheduler.offer(queue.poll()[0]);
            }
            
            if (scheduler.size() > 0) {
                int cur = scheduler.poll();
                if (cur > 1) {
                    queue.add(new int[]{cur - 1, t + n + 1});
                }
            }
        }

        return t;
    }
}