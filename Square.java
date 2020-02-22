public class Square {

    private final boolean containsShip;
    private boolean hit = false;

    public Square(boolean containsShip) {
        this.containsShip = containsShip;
    }

    public void hit() {
        hit = true;
    }

   
    public String toString() {
        if(!hit){
            return "_";  
        }
        if(containsShip){
            return "X";
        }
        return "O";
    }
}
