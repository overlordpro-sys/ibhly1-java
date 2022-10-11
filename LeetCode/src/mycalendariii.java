public class mycalendariii {
    private ArrayList<String> bookings;
    private ArrayList<int[]> times;

    public mycalendariii() {
        bookings = new ArrayList<String>();
        times = new ArrayList<int[]>();
    }

    public int book(int start, int end) {
        int count = 0;
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i)[0] <= end && times.get(i)[1] >= start) {
                count++;
            }
        }
        times.add(new int[] { start, end });
        return count;
    }

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
}
