import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class DijkstraReducer {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String cur = null;
            Map<String, String[]> res = new LinkedHashMap<>();
            while ((cur = br.readLine()) != null) {
                String[] t = cur.split("\t");
                res.putIfAbsent(t[0], new String[2]);
                String[] inf = res.get(t[0]);
                if (t[2].length() != 2) {
                    inf[1] = t[2];
                }
                if (inf[0] == null || inf[0].equals("INF"))
                    inf[0] = t[1];
                else {
                    if (!t[1].equals("INF")) {
                        if (Integer.parseInt(t[1]) < Integer.parseInt(inf[0]))
                            inf[0] = t[1];
                    }
                }
            }
            for (Map.Entry<String, String[]> pair : res.entrySet()) {
                System.out.println(pair.getKey() + "\t" + pair.getValue()[0] + "\t" + (pair.getValue()[1] == null ? "{}" : pair.getValue()[1]));
            }
        }
    }
}
