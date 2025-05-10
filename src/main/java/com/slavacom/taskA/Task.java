package main.java.com.slavacom.taskA;

import java.io.*;

public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = reader.readLine().trim();
        reader.close();

        if (task(word)) writer.write("YES");
        else writer.write("NO");

        writer.flush();
        writer.close();
    }


    public static boolean isPalindrome(final String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) return false;
        }

        return true;
    }

    public static boolean task(final String word) {
        for (int i = 0; i < word.length(); i++) {
            StringBuilder wordBuilder = new StringBuilder(word);
            wordBuilder.deleteCharAt(i);
            if (isPalindrome(wordBuilder.toString())) return true;
        }

        return false;
    }
}