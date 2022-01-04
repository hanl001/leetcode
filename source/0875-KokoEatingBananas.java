class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(pile, r);
        }
        //// 模版方法
        // while (l <= r) {
        //     int mid = (l + r) >>> 1;
        //     int curHour = getHour(piles, mid);
        //     if (curHour <= h) {
        //         if (mid == 1 || getHour(piles, mid - 1) > h) {
        //             return mid;
        //         } else {
        //             r = mid - 1;
        //         }
        //     } else {
        //         l = mid + 1;
        //     }
        // }
        
        //// 非模版方法
        while (l < r) {
            int mid = (l + r) >>> 1;
            int curHour = getHour(piles, mid);
            if (curHour <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // get hour for x
    private int getHour(int[] piles, int x) {
        int hour = 0;
        for (int pile : piles) {
            hour += (pile + x - 1) / x;
        }
        return hour;
    }
}
