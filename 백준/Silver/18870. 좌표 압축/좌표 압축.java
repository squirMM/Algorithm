import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        List<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
            set.add(num);
        }
        Integer[] nums = set.toArray(new Integer[0]);
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            int ans = binarySearch(nums, 0, set.size(), a);
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(Integer[] nums, int s, int e, int target) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return s;
    }
}