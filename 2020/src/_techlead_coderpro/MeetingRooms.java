package _techlead_coderpro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static void main(String[] args) {
        System.out.println(meetingRooms(new int[][]{{20, 50}, {10, 20}, {0, 10}}));
        System.out.println(meetingRooms(new int[][]{{20, 30}, {10, 21}, {0, 50}}));
    }

    public static int meetingRooms(int[][] rooms) {
        int max = 0;
        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[0] - y[0];
            }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] meeting :
                rooms) {
            while (!heap.isEmpty() && heap.peek() <= meeting[0]) {
                heap.poll();
            }
            heap.add(meeting[1]);
        }
        return heap.size();
    }
}


