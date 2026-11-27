package app.entities;

public class PartLine {
    private Material material;
    private int fittedLength;
    private int quantity;
    private double totalCost;
    String description;

    public PartLine(Material material, int fittedLength, int quantity) { // Ignoring cost and description for now
        this.material = material;
        this.fittedLength = fittedLength;
        this.quantity = quantity;
    }
}
