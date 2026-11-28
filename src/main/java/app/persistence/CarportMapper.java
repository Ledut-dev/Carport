package app.persistence;

import app.entities.Carport;
import app.entities.Material;
import app.exceptions.DatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {
    ConnectionPool connectionPool;
    private static final Logger logger =
            LoggerFactory.getLogger(CarportMapper.class);

    public CarportMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<Material> getMaterialsByTypeVariantID(int typeVariantID) throws DatabaseException {
        List<Material> materials = new ArrayList<>();
        String query = """
            SELECT m.id, t.description, v.width, v.height, m.length, m.cost
            FROM materials m
            JOIN type_variants tv ON m.type_variant_id = tv.id
            JOIN types t ON tv.type_id = t.id
            JOIN variants v ON tv.variant_id = v.id
            WHERE tv.id = ?
            ORDER BY m.length
            """;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement stm = connection.prepareStatement(query)) {
            stm.setInt(1, typeVariantID);

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("m.id");
                    String type = rs.getString("t.description");
                    String variant = rs.getInt("v.width") + "x" + rs.getInt("v.height");
                    int length = rs.getInt("m.length");
                    double cost = rs.getDouble("m.cost");

                    materials.add(new Material(id, type, variant, length, cost));
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DatabaseException("Fejl ved søgning efter materialer");
        }
        return materials;
    }
}