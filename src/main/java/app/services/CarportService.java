package app.services;

import app.entities.Carport;
import app.entities.Material;
import app.entities.PartLine;
import app.exceptions.DatabaseException;
import app.persistence.CarportMapper;
import app.persistence.ConnectionPool;

import java.util.ArrayList;
import java.util.List;

public class CarportService {
    private ConnectionPool connectionPool;
    private CarportMapper carportMapper;

    public CarportService(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.carportMapper = new CarportMapper(connectionPool);
    }

    public void addPartsToPartsList(Carport carport) throws DatabaseException {
        //Numbers are placeholders for the type_variant_id used for the specific part
        Material postMaterial = getOptimalMaterial(calcPostLength(carport), 101);
        Material depthSternMaterial = getOptimalMaterial(calcPostLength(carport), 102);
        Material widthSternMaterial = getOptimalMaterial(calcPostLength(carport), 102);
        Material rafterMaterial = getOptimalMaterial(calcPostLength(carport), 201);
        Material purlinMaterial = getOptimalMaterial(calcPostLength(carport), 201);

        // remove .getPartLines()
        carport.getPartsList().add(new PartLine(postMaterial, calcPostLength(carport), calcPostQuantity(carport)));
        carport.getPartsList().add(new PartLine(depthSternMaterial, calcDepthSternLength(carport), 2));
        carport.getPartsList().add(new PartLine(widthSternMaterial, calcWidthSternLength(carport), 2));
        carport.getPartsList().add(new PartLine(rafterMaterial, calcRafterLength(carport), calcRafterQuantity(carport)));
        carport.getPartsList().add(new PartLine(purlinMaterial, calcPurlinLength(carport), calcPurlinQuantity(carport)));
    }

    private Material getOptimalMaterial(int fittedLength, int typeVariantID) throws DatabaseException {
        List<Material> materials = carportMapper.getMaterialsByTypeVariantID(typeVariantID);
        int quantity = 1; // Trying to find a single piece of materials first

        // Get materials that are long enough
        List<Material> longEnoughMaterials = new ArrayList<>();

        while (longEnoughMaterials.isEmpty()) {                 // If no materials were long enough, try again with the fitted length being divided
            fittedLength = (fittedLength*quantity)/quantity+1;  // Divide original fitted length with one more quantity
            quantity++;
            longEnoughMaterials = getLongEnoughMaterials(materials, fittedLength);
        }

        // Get shortest of remaining materials
        Material best = null;
        for (Material material : longEnoughMaterials) {
            if (material.getLength() < best.getLength()) {
                best = material;
            }
        }

        return best;
    }

    private List<Material> getLongEnoughMaterials(List<Material> materials, int fittedLength) {
        List<Material> longEnoughMaterials = new ArrayList<>();
        for (Material material : materials) {
            if (material.getLength() >= fittedLength) {
                longEnoughMaterials.add(material);
            }
        }
        return longEnoughMaterials;
    }


    // DUMMY METHODS FOR TESTING
    private int calcPostQuantity(Carport carport) {
        return 6; // DELETE THIS
    }

    private int calcPostLength(Carport carport) {
        return 190; // DELETE THIS
    }

    private int calcDepthSternLength(Carport carport) {
        return 480; // DELETE THIS
    }

    private int calcWidthSternLength(Carport carport) {
        return 360; // DELETE THIS
    }

    private int calcRafterQuantity(Carport carport) {
        return 10; // DELETE THIS
    }

    private int calcRafterLength(Carport carport) {
        return 360; // DELETE THIS
    }

    private int calcPurlinQuantity(Carport carport) {
        return 2; // DELETE THIS
    }

    private int calcPurlinLength(Carport carport) {
        return 480; // DELETE THIS
    }
}