package main.java.com.slavacom.taskB;

import java.io.*;

public class Task {
    private static class Train {
        int firstTime;
        int interval;

        public Train(String[] input) {
            this.firstTime = Integer.parseInt(input[0]);
            this.interval = Integer.parseInt(input[1]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());

        Train[] trains = new Train[n];
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().trim().split(" ");

            trains[i] = new Train(input);
        }

        int q = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < q; i++) {
            String[] input = reader.readLine().trim().split(" ");

            int lineNum = Integer.parseInt(input[0]) - 1;
            int time = Integer.parseInt(input[1]);

            int trainWaitingTime = ((time - trains[lineNum].firstTime) % trains[lineNum].interval);

            if (trainWaitingTime == 0) writer.write(time + "\n");
            else writer.write(time + (trains[lineNum].interval - trainWaitingTime) + "\n");
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}