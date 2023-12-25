import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeamList {

    public void teamList() {
        String filePath = "TeamList.csv";
        List<Team> teamList = getTeamList(filePath);
        showTeamList(filePath, teamList);
    }

    public void updatedList() {
        String filePath = "TeamList.csv";
        List<Team> teamList = getTeamList(filePath);
        System.out.println("Enter the match date: ");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        MatchList matchList = new MatchList();
        List<String> teamName = matchList.searchByDate(date);
        System.out.println("Write the team name to win and loos the match from given option.");
        System.out.println("Team A: " + teamName.get(0) + " Team B: " + teamName.get(1));
        System.out.print("Enter the winning team: ");
        String winningTeam = scanner.nextLine();
        System.out.print("Enter the losing team: ");
        String losingTeam = scanner.nextLine();
        writeUpdatedDataToCSV(filePath, teamList, winningTeam, losingTeam);
        showTeamList(filePath, teamList);

    }

    private List<Team> getTeamList(String filePath) {
        List<Team> teamList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String[] headers = line.split(",");
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Team team = new Team();
                team.setName(values[0]);
                team.setMatches(Integer.parseInt(values[1]));
                team.setWin(Integer.parseInt(values[2]));
                team.setLoss(Integer.parseInt(values[3]));
                team.setTie(Integer.parseInt(values[4]));
                team.setPoints(Integer.parseInt(values[5]));
                teamList.add(team);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teamList;
    }

    private void showTeamList(String filePath, List<Team> teamList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String[] headers = line.split(",");
            Collections.sort(teamList);
            System.out.printf("%-40s %-6s %-4s %-4s %-4s %-4s\n", headers[0], headers[1], headers[2], headers[3], headers[4], headers[5]);
            for (Team team : teamList) {
                System.out.printf("%-40s %-6s %-4s %-4s %-4s %-4s\n", team.getName(), team.getMatches(), team.getWin(), team.getLoss(), team.getTie(), team.getPoints());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeUpdatedDataToCSV(String filePath, List<Team> teamList, String winningTeam, String losingTeam) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Name,Match,Win,Loss,Tie,Point");
            for (Team team : teamList) {
                if (team.getName().equalsIgnoreCase(winningTeam)) {
                    team.setWin(team.getWin() + 1);
                    team.setPoints(team.getPoints() + 2);
                    team.setMatches(team.getMatches() + 1);
                } else if (team.getName().equalsIgnoreCase(losingTeam)) {
                    team.setLoss(team.getLoss() + 1);
                    team.setMatches(team.getMatches() + 1);
                }
                writer.printf("%s,%d,%d,%d,%d,%d\n", team.getName(), team.getMatches(), team.getWin(), team.getLoss(), team.getTie(), team.getPoints());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void top4Team(){
        String filePath="TeamList.csv";
        List<Team> teamList=getTeamList(filePath);
        if(allTeamsPlayed14Matches(teamList)){
           showTop4TeamList(filePath,teamList);
        }
        else {
            System.out.println("Some teams have not played all the 14 matches");
        }
    }

    private void showTop4TeamList(String filePath, List<Team> teamList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String[] headers = line.split(",");
            Collections.sort(teamList);
            System.out.printf("%-40s %-6s %-4s %-4s %-4s %-4s\n", headers[0], headers[1], headers[2], headers[3], headers[4], headers[5]);
            for (int i=0;i<4;i++) {
                System.out.printf("%-40s %-6s %-4s %-4s %-4s %-4s\n", teamList.get(i).getName(), teamList.get(i).getMatches(), teamList.get(i).getWin(),
                        teamList.get(i).getLoss(), teamList.get(i).getTie(), teamList.get(i).getPoints());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean allTeamsPlayed14Matches(List<Team> teams) {
        return teams.stream().allMatch(team -> team.getMatches() == 14);
    }

}





