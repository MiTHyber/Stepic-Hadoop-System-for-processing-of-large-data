import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DijkstraMapper {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String cur = null;
            while ((cur = br.readLine()) != null) {
                String[] t = cur.split("\t");
                String[] adj = null;
                t[2] = t[2].replace("{", "");
                t[2] = t[2].replace("}", "");
                if (t[2].length() != 0)
                    adj = t[2].split(",");
                System.out.println(cur);
                if (adj != null) {
                    for (String s : adj) {
                        System.out.println(s + "\t" + (t[1].equals("INF") ? "INF" : (Integer.parseInt(t[1]) + 1)) + "\t{}");
                    }
                }
            }
        }
    }
}
