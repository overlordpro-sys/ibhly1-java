import java.util.ArrayList;

class MyCalendarThree {
    private ArrayList<int[]> times;
    public MyCalendarThree() {
        times = new ArrayList<int[]>();
    }

    public int book(int start, int end) {
        times.add(new int[]{start, end});
        int overlaps = 1;
        for (int[] booking : times) {
            if (start < booking[1] || end > booking[0]) {
                overlaps++;
            }
        }
        return overlaps;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */