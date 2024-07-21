import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SumCalculator {
    public static int calculateSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://symmetrical-succotash-7v977vjvx6vwhp4pp-3000.app.github.dev/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        int n = 10; // example input

        String jsonInputString = "{\"n\": " + n + "}";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}