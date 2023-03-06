import java.util.Arrays;
class Solution {
    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1, end = (long) times[times.length - 1] *n;
        while (start < end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int t : times)
                cnt += mid / (int)t;
            if (cnt >= n)
                end = mid;
            else
                start = mid+1;
        }
        return end;
    }
}