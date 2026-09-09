class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        // available rooms min heap 
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        // all rooms available initially 
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }
        // busy rooms by end time 
        // where each entry is [endTime, room num]
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));

        // answer eeting count 
        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;

            // free rooms completed before current meeting start
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.add((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                // assign meeting to smalles number available room 
                int room = availableRooms.poll();
                busyRooms.add(new long[] { start + duration, room });
                meetingCount[room]++;
            } else {
                // meeting delayed until earliest room becomes free. 
                long[] earliest = busyRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                busyRooms.add(new long[] { newStart + duration, room });
                meetingCount[room]++;
            }
        }

        int max = 0;
        int roomWithMax = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > max) {
                max = meetingCount[i];
                roomWithMax = i;
            }
        }
        return roomWithMax;
    }
}