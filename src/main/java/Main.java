import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
    }

    public static void convertToJPY(double value) {
        System.out.printf("%.2f CNY = %.2f JPY", value, value * getCurrencyRate());
    }

    public static void convertToCNY(double value) {
        System.out.printf("%.2f JPY = %.2f CNY\n\n", value, value / getCurrencyRate());
    }


    private static double getCurrencyRate() {
        Double rate = null;
        try {
            JsonNode json = new ObjectMapper().readTree(new URL("https://api.exchangerate.host/latest?base=CNY"));
            rate = json.get("rates").get("JPY").asDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rate;
    }

}