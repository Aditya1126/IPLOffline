import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlayerList {

    public void playerList() {
        String path = "PlayerList.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine();
            String[] headers = line.split(",");
            int size = headers.length;
            for (int i = 0; i < size; i++) {
                System.out.printf("%-40s", headers[i]);
            }
            System.out.println();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(","); // Split line by comma
                for (int i = 0; i < values.length; i++) {
                    System.out.printf("%-40s", values[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchByName(String playerName) {

        String path = "PlayerList.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine();
            String[] headers = line.split(",");
            int size = headers.length;
            String type = "";
            String[] values = new String[0];
            while ((line = reader.readLine()) != null) {
                values = line.split(","); // Split line by comma
                if (values[1].trim().equals(playerName)) {
                    type = values[2];
                    break;
                }
            }
            if (type.equalsIgnoreCase("Bowler")) {
                System.out.printf("%-40s %-38s %-40s %-40s %-38s %-40s %-38s %-5s\n", headers[0], headers[1], headers[2], headers[3], headers[8], headers[9], headers[10], headers[11]);
                System.out.printf("%-40s %-38s %-40s %-40s %-38s %-40s %-38s %-5s\n", values[0], values[1], values[2], values[3], values[8], values[9], values[10], values[11]);
            } else if (type.equalsIgnoreCase("Batsman")) {
                System.out.printf("%-40s %-38s %-40s %-40s %-38s %-40s %-38s %-5s\n", headers[0], headers[1], headers[2], headers[3], headers[4], headers[5], headers[6], headers[7]);
                System.out.printf("%-40s %-38s %-40s %-40s %-38s %-40s %-38s %-5s\n", values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
            }
            if (type.equalsIgnoreCase("Both")) {
                for (int i = 0; i < size; i++) {
                    System.out.printf("%-40s", headers[i]);
                }
                System.out.println();
                for (int i = 0; i < size; i++) {
                    System.out.printf("%-40s", values[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
