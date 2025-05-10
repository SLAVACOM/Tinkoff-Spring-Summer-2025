package main.java.com.slavacom.taskJ;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Task {

    static final BigInteger MOD = BigInteger.valueOf(998244353);

    static int[] array;
    static int n;
    static Set<String> uniqueSeq = new HashSet<>();
    static BigInteger totalSum = BigInteger.ZERO;
    static int LIMIT;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine().trim());
        array = new int[n - 1];

        StringTokenizer st = new StringTokenizer(reader.readLine().trim());
        reader.close();
        for (int i = 0; i < n - 1; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        LIMIT = 1;
        for (int v : array) LIMIT *= v;

        for (int start = 1; start <= LIMIT; start++) {
            List<Integer> bPartial = new ArrayList<>();
            bPartial.add(start);
            dfs(1, bPartial);
        }

        for (String key : uniqueSeq) {
            String[] parts = key.split(",");
            BigInteger prod = BigInteger.ONE;
            for (String p : parts) {
                prod = prod.multiply(BigInteger.valueOf(Integer.parseInt(p)));
            }
            totalSum = totalSum.add(prod).mod(MOD);
        }

        writer.write(totalSum.toString());
        writer.flush();
        writer.close();
    }

    static void dfs(int idx, List<Integer> bPartial) {
        if (idx == n) {
            if (globalGCD(bPartial) == 1) {
                StringBuilder sb = new StringBuilder();
                for (int x : bPartial) {
                    if (!sb.isEmpty()) sb.append(",");
                    sb.append(x);
                }
                uniqueSeq.add(sb.toString());
            }
            return;
        }

        int bi = bPartial.getLast();
        for (int bj = 1; bj <= LIMIT; bj++) {
            if (beauty(bi, bj) == array[idx - 1]) {
                bPartial.add(bj);
                dfs(idx + 1, bPartial);
                bPartial.removeLast();
            }
        }
    }

    static int beauty(int bi, int bj) {
        int g = gcd(bi, bj);
        return (bi / g) * (bj / g);
    }

    static int gcd(int x, int y) {
        while (y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }
        return x;
    }

    static int globalGCD(List<Integer> list) {
        int g = list.getFirst();
        for (int i = 1; i < list.size(); i++) {
            g = gcd(g, list.get(i));
            if (g == 1) break;
        }
        return g;
    }
}
