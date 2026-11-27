package app.services;

import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;

public class OrderService {
    private ConnectionPool connectionPool;

    public OrderService(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public void createOrder(int height, int width, int depth, String name, String address, String zipCode, String email, String phonenumber) throws DatabaseException {
    }
}
