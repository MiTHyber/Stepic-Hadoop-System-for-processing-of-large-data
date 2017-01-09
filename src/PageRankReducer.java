import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PageRankReducer {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String cur = null;
            Map<String,String[]> res = new LinkedHashMap<>();
            while ((cur = br.readLine()) != null) {
                String[] t = cur.split("\t");
                res.putIfAbsent(t[0], new String[2]);
                String[] v = res.get(t[0]);
                double sum = 0;
                if (v[0] != null)
                    sum = Double.parseDouble(v[0]);
                if (t[2].length() != 2)
                    v[1] = t[2];
                else
                    sum += Double.parseDouble(t[1]);
                v[0] = String.format("%.3f",sum);
            }
            for (Map.Entry<String, String[]> entry : res.entrySet()) {
                System.out.printf("%s\t%s\t%s\n",entry.getKey(),entry.getValue()[0],entry.getValue()[1]);
            }
        }
    }
}
