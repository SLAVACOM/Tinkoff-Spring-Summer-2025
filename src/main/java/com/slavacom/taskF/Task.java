package main.java.com.slavacom.taskF;

import java.io.*;
import java.util.BitSet;
import java.util.PriorityQueue;

class Task {

    static class Pair implements Comparable<Pair> {
        int diff;
        int left;
        int right;

        public Pair(int diff, int left, int right) {
            this.diff = diff;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.diff, diff);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        int[] personsAges = new int[n];

        String[] input = reader.readLine().trim().split(" ");
        reader.close();

        for (int i = 0; i < n; i++) {
            personsAges[i] = Integer.parseInt(input[i]);
        }

        BitSet alive = new BitSet(n);
        alive.set(0, n);

        int[] prev = new int[n], next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            int currentDiff = Math.abs(personsAges[i] - personsAges[i + 1]);
            pq.add(new Pair(currentDiff, i, i + 1));
        }

        long result = 0;

        while (!pq.isEmpty()) {
            Pair max = pq.poll();
            int left = max.left, right = max.right;

            if (!alive.get(left) || !alive.get(right)) continue;

            alive.clear(left);
            alive.clear(right);
            result += max.diff;

            int nl = prev[left]; // левый сосед до пары
            int nr = next[right]; // правый сосед после пары

            if (nl >= 0) next[nl] = nr;
            if (nr < n) prev[nr] = nl;

            if (nl >= 0 && nr < n && alive.get(nl) && alive.get(nr)) {
                int newDiff = Math.abs(personsAges[nl] - personsAges[nr]);
                pq.add(new Pair(newDiff, nl, nr));
            }

        }

        writer.write(result + "\n");

        writer.flush();
        writer.close();
    }
}