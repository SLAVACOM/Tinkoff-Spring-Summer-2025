package test.java.com.slavacom;

import main.java.com.slavacom.taskD.Task;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTaskD {
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
        String input = "5\n" +
                "1 2 3 3 2";
        String output = "3";
        assertEquals(output, runWithInput(input));
    }
}
