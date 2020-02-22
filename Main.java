import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            
        try (Scanner scanner = new Scanner(System.in)) { // automatically close scanner
            System.out.println("Initializing board");

            ArrayList<Ship> ships = new ArrayList<>();
            for (ShipType type : ShipType.values()) { // itterate through ShipType
                System.out.println("Insert " + type + " (length of " + type.length + ") (format: [A-J][0-9] [hv])");
                System.out.println("h means horizontal");
                System.out.println("v means vertical");
                String line = scanner.nextLine().toLowerCase();
                
                int startRow = Integer.parseInt(line.substring(1, 2));
                int startCol = line.charAt(0) - 'a'; 
                boolean horizontal = line.charAt(3) == 'h';
                ships.add(new Ship(startRow, startCol, horizontal, type));
            }

            Ocean ocean = new Ocean(ships);

            System.out.println("Starting game");

            // boolean checkWin = ocean.allShipsSunk();
            while (!ocean.allShipsSunk()) {
                System.out.println("Enter coordinates (format [A-J][0-9])");
                String line = scanner.nextLine().toLowerCase();
                if (!line.matches("^[a-j][0-9]")) {
                    System.out.println("Wrong coordinates");
                    continue;
                }

                int row = Integer.parseInt(line.substring(1, 2));
                int col = line.charAt(0) - 'a';

                ocean.hit(row, col);
                System.out.println(ocean);
                
            }
            System.out.println("YOU WON!");
        }
    }
}

