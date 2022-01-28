class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<String>();
        for (String deadend : deadends) {
            deadendsSet.add(deadend);
        }
        if (deadendsSet.contains("0000")) {
            return -1;
        }
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                String[] nexts = getNextForString(cur);
                for (String next : nexts) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (deadendsSet.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }

    private String[] getNextForString(String cur) {
        char[] list = cur.toCharArray();
        String[] result = new String[8];
        int j = 0;
        for (int i = 0; i < list.length; i++) {
            char ch = list[i];
            if (ch == '0') {
                list[i] = '1';
                result[j++] = new String(list);
                list[i] = '9';
                result[j++] = new String(list);
            } else if (ch == '9') {
                list[i] = '0';
                result[j++] = new String(list);
                list[i] = '8';
                result[j++] = new String(list);
            } else {
                list[i] = (char)(ch - 1);
                result[j++] = new String(list);
                list[i] = (char)(ch + 1);
                result[j++] = new String(list);
            }
            list[i] = ch;
        }
        return result;
    }
}
