public class Ship {
    // if fields are final and they are that type it is not possible value, does need to be private
    public final int startRow;
    public final int startCol;
    public final boolean horizontal;
    public final ShipType type;

    // final board
    private final boolean[] hits;

    // constructor
    public Ship(int startRow, int startCol, boolean horizontal, ShipType type) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.horizontal = horizontal;
        this.type = type;
        this.hits = new boolean[type.length];
    }

    public int endCol() {
        if(horizontal){
            return startCol+type.length-1;
        }
        return startCol;
        
        // return horizontal ? startCol + type.length - 1 : startCol;
    }

    public int endRow() {
        if(horizontal){
            return startRow;
        }
        return startRow + type.length - 1;

        // return horizontal ? startRow : startRow + type.length - 1;
    }

    public boolean fitsOnBoard(int boardSize) {
        boolean positionInRow = startRow >=0;
        boolean positionInCol = startCol >=0;
        boolean shipInRow= endRow() < boardSize;
        boolean shipInCol = endCol()<boardSize;
        

        return positionInRow && positionInCol && shipInRow && shipInCol;
        // return startRow >= 0 && startCol >= 0 && endRow() < boardSize && endCol() < boardSize;
    }

    public boolean containsSquare(int row, int col) {
        boolean rowEqualToStartRow = row == startRow;
        boolean colEqualOrBiggerStartCol = col >= startCol;
        boolean colEqualOrSmallerEndCol = col <=endCol();

        boolean isHorizontal = horizontal & rowEqualToStartRow && colEqualOrBiggerStartCol && colEqualOrSmallerEndCol;
        if (isHorizontal){
            return true;
        }
        boolean colEqualToStartRow = col == startRow;
        boolean rowEqualOrBiggerStartCol = row >= startCol;
        boolean rowEqualOrSmallerEndCol = row <= endRow();

        boolean isVertical = !horizontal && colEqualToStartRow && rowEqualOrBiggerStartCol && rowEqualOrSmallerEndCol;
        if (isVertical)
            return true;

            // (!horizontal && col == startCol && row >= startRow && row <= endRow())
        return false;
    }

    public void hit(int row, int col) {
        int distance = row - startRow + col - startCol;
        hits[distance] = true;
    }

    public boolean isSunk() {
        for (boolean fieldHit : hits) {
            if (!fieldHit)
                return false;
        }
        return true;
    }
}
