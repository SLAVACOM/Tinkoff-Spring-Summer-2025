package main.java.com.slavacom.taskC;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        Set<Integer> seen = new HashSet<>();

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());

            while (true) {
                if (seen.add(number)) break;
                if (number == 0) break;
                number /=2;
            }
        }

        writer.write(seen.size() + "\n");
        writer.flush();

        reader.close();
        writer.close();
    }
}