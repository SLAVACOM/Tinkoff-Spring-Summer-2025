package test.java.com.slavacom;

import main.java.com.slavacom.taskB.Task;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaskB {
    private String runWithInput(String input) throws IOException {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));

        Task.main(new String[]{});
        System.setIn(originalIn);
        System.setOut(originalOut);

        return out.toString().trim();
    }


    @Test
    public void test1() throws IOException {
        String input = "3\n" +
                "0 1\n" +
                "2 3\n" +
                "1 4\n" +
                "5\n" +
                "1 2\n" +
                "2 6\n" +
                "3 6\n" +
                "2 5\n" +
                "3 8";
        String output = "2\n" +
                "8\n" +
                "9\n" +
                "5\n" +
                "9";
        assertEquals(output, runWithInput(input));
    }
}
