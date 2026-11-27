package app.entities;

public class Material {
    private int id; // We forgot this in the class diagram, but I assume we want a "varenummer"
    private String type;
    private String variant;
    private int length;
    private double cost;

    // Mapper constructor
    public Material(int id, String type, String variant, int length, double cost) {
        this.id = id;
        this.type = type;
        this.variant = variant;
        this.length = length;
        this.cost = cost;
    }

    public int getLength() {
        return length;
    }
}
