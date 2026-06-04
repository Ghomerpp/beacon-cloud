import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://leetcode.cn/problems/meeting-rooms-ii/
//会议室
public class leetcode253 {
    public static int minMeetingRooms(int[][] intervals) {
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a - b);
        if (intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals,0,intervals.length,(a,b) -> (a[0] - b[0]));
        for (int i = 0; i < intervals.length; i++) {
            heap.add(intervals[i][1]);
            if (intervals[i][0] >= heap.peek()){
                heap.poll();
            }
            ans = Math.max(heap.size(),ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        final int MAX_ROWS = 2;
        final int COLS = 2;
        int[][] arr = new int[MAX_ROWS][COLS];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        System.out.println(minMeetingRooms(arr));
    }
}
