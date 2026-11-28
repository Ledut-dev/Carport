package app.entities;

import java.util.ArrayList;
import java.util.List;

public class Carport {
    private int depth;
    private int width;
    private int height;
    List<PartLine> partsList;

    public Carport(int depth, int width, int height) {
        this.depth = depth;
        this.width = width;
        this.height = height;
        this.partsList = new ArrayList<>();
    }

    public List<PartLine> getPartsList() {
        return partsList;
    }
}
