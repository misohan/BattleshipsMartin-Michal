import java.util.ArrayList;
import java.util.List;

public class Ocean {
    public final int boardLength = 10;

    private final Square[][] board;
    private final List<Ship> ships;

    public Ocean(ArrayList<Ship> ships) {
       
        board = new Square[boardLength][boardLength];
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                boolean isOccupied = isSquareOccupied(ships, i, j);
                board[i][j] = new Square(isOccupied);
            }
        }

        this.ships = ships;
    }

    private boolean isSquareOccupied(List<Ship> ships, int row, int col) {
        for (Ship ship : ships) {
            if (ship.containsSquare(row, col))
                return true;
        }
        return false;
    }

    public void hit(int row, int col) {
        board[row][col].hit();
        for (Ship ship : ships) {
            if (ship.containsSquare(row, col)) {
                ship.hit(row, col);
                System.out.println(ship.isSunk() ? "Hit and sunk" : "Hit");
                return;
            }
        }
        System.out.println("Miss");
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk())
                return false;
        }
        return true;
    }

    public String toString() {
        String output = "  A B C D E F G H I J\n";
        for (int i = 0; i < boardLength; i++) {
            output += i + " ";
            for (int j = 0; j < boardLength; j++)
                output += board[i][j] + " ";
            output += '\n';
        }
        return output;
    }
}
