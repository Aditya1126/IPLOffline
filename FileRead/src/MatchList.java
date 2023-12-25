import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchList {

    public void matchList() {
        try {
            // Specify the file path
            String filePath = "MatchList.csv";

            // Create a BufferedReader for efficient reading
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                // Read header
                String line = reader.readLine();
                String[] headers = line.split(",");

                // Print header with padding
                System.out.printf("%-20s %-40s %-40s %-20s %-4s\n", headers[0], headers[1], headers[2], headers[3], headers[4]);

                // Read data and print rows with padding
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    System.out.printf("%-20s %-40s %-40s %-20s %-4s\n", values[0], values[1], values[2], values[3], values[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchByName(String searchTerm){
        String filePath = "MatchList.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read header line
            String line = reader.readLine();
            String[] headers = line.split(",");

            // Print header with padding
            System.out.printf("%-20s %-40s %-40s %-20s %-4s\n", headers[0], headers[1], headers[2], headers[3], headers[4]);

            // Loop through each row

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(","); // Split line by comma

                // Compare team name
                if (values[1].trim().equals(searchTerm)) {
                    // Process or print additional data from the row if needed

                        System.out.printf("%-20s %-40s %-40s %-20s %-4s\n",values[0],values[1],values[2],values[3],values[4]);

                }
                if (values[2].trim().equals(searchTerm)) {
                    System.out.printf("%-20s %-40s %-40s %-20s %-4s\n",values[0],values[1],values[2],values[3],values[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> searchByDate(String searchTerm){
        String filePath = "MatchList.csv";
        List<String> teamList=new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read header line
            String line = reader.readLine();
            String[] headers = line.split(",");

            // Print header with padding
            //System.out.printf("%-20s %-40s %-40s %-20s %-4s\n", headers[0], headers[1], headers[2], headers[3], headers[4]);

            // Loop through each row

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(","); // Split line by comma

                // Compare team name
                if (values[3].trim().equals(searchTerm)) {
                    teamList.add(values[1]);
                    teamList.add(values[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teamList;
    }

}
