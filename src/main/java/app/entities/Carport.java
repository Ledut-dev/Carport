package app.entities;

public class Carport {
    private int depth;
    private int width;
    private int height;
    PartsList partsList;

    public Carport(int depth, int width, int height) {
        this.depth = depth;
        this.width = width;
        this.height = height;
        this.partsList = new PartsList();
    }

    public PartsList getPartsList() {
        return partsList;
    }
}
