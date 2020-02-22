public enum ShipType {
    // enum może przyjąć tylko określone (wymienione niżej) wartości. W nawiasie podany jest argument konstruktora
    // CARRIER(5),
    // BATTLESHIP(4),
    // CRUISER(3),
    // SUBMARINE(3),
    DESTROYER(2);

    final int length;

    ShipType(int length) {
        this.length = length;
    }
}
