package main.java.com.slavacom.taskD;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList[] lists = new ArrayList[11];
        for (int i = 1; i <= 10; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            lists[array[i]].add(i + 1);
        }

        int prev = 0;
        long result = 0;

        for (int r = 3; r <= n; r++) {
            int maxCurrent = 0;
            for (int j = 1; j < r; j++) {

                int x = 2 * array[j - 1] - array[r - 1];  // A_i = 2A_j - A_r
                if (x >= 1 && x <= 10) {
                    List<Integer> posList = lists[x];
                    int idx = binarySearch(posList, j - 1);

                    if (idx >= 0 && posList.get(idx) < j) {
                        maxCurrent = Math.max(maxCurrent, posList.get(idx));
                    }
                }
            }

            int right = Math.max(maxCurrent, prev);
            result += right;
            prev = right;

        }
        writer.write(result + "\n");

        writer.flush();
        writer.close();
    }

    private static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}