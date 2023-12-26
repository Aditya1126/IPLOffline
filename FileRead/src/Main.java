import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Welcome to IPL Project");
        System.out.println("For getting team list press 1");
        System.out.println("For getting match list press 2");
        System.out.println("For getting player list press 3");
        System.out.print("Enter the number: ");

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (num != 0) {
            int choice;
            if (num == 1) {
                TeamList teamList = new TeamList();
                teamList.teamList();
                System.out.println();
                System.out.println("To play the IPL match press 1");
                System.out.println("For getting list of qualified team press 2");
                System.out.print("Enter the number: ");
                choice = sc.nextInt();
                if (choice == 1) {
                    teamList.updatedList();
                } else {
                    teamList.top4Team();
                }
            } else if (num == 2) {
                System.out.println("For getting all match list press 1");
                System.out.println("For getting match list by name press 2");
                System.out.println("For getting match list by date press 3");
                System.out.print("Enter the number: ");
                choice = sc.nextInt();
                MatchList matchList = new MatchList();
                if (choice == 1) {
                    matchList.matchList();
                } else if (choice == 2) {
                    System.out.print("Enter the team name: ");
                    String name = sc.nextLine();
                    String name1 = sc.nextLine();
                    matchList.searchByName(name1);
                } else {
                    System.out.print("Enter the date: ");
                    String date = sc.next();
                    matchList.searchByDateClass(date);
                }
            } else if (num == 3) {
                System.out.println("For getting all player list press 1");
                System.out.println("For getting player list by name press 2");
                System.out.print("Enter the number: ");
                choice = sc.nextInt();
                PlayerList playerList = new PlayerList();
                if (choice == 1) {
                    playerList.playerList();
                } else if (choice == 2) {
                    System.out.flush();
                    System.out.print("Enter the player name: ");
                    String name = sc.nextLine();
                    String name1 = sc.nextLine();
                    playerList.searchByName(name1);
                }
            }
            System.out.println();
            System.out.println("For getting team list press 1");
            System.out.println("For getting match list press 2");
            System.out.println("For getting player list press 3");
            System.out.print("Enter the number: ");
            num = sc.nextInt();
            System.out.println();
        }
    }

}

