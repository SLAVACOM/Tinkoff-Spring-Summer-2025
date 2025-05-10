package main.java.com.slavacom.taskE;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        char[] line = reader.readLine().trim().toCharArray();
        reader.close();

        a = Math.min(a, b * 2);
        int openCount = 0;
        for (char c : line) {
            if (c == '(') openCount++;
        }

        int delta = openCount - n;
        long result = 0;

        if (delta > 0) {
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < line.length; i++) {
                if (line[i] == '(') positions.add(i);
            }
            for (int i = 0; i < delta; i++) {
                line[positions.get(positions.size() - 1 - i)] = ')';
            }
            result += (long) delta * b;
        } else if (delta < 0) {
            int deltaAbs = -delta;
            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < line.length; i++) {
                if (line[i] == ')') positions.add(i);
            }
            for (int i = 0; i < deltaAbs; i++) {
                line[positions.get(positions.size() - 1 - i)] = '(';
            }
            result += (long) deltaAbs * b;
        }

        int swapCount = getSwapCount(line);

        result += (long) swapCount * a;

        writer.write(result + "\n");
        writer.flush();
        writer.close();
    }

    private static int getSwapCount(char[] line) {
        List<Integer> opens = new ArrayList<>();
        for (int i = line.length - 1; i >= 0; i--) {
            if (line[i] == '(') opens.add(i);
        }

        int balance = 0;
        int swapCount = 0;
        int j = 0;

        for (int i = 0; i < line.length; i++) {
            if (line[i] == '(') balance++;
            else balance--;

            if (balance < 0) {
                while (j < opens.size() && opens.get(j) <= i) {
                    j++;
                }
                if (j < opens.size()) {
                    swapCount++;
                    balance += 2;
                    j++;
                }
            }
        }
        return swapCount;
    }
}
