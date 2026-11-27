package app.controllers;

import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.services.OrderService;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;

public class OrderController {
    private ConnectionPool connectionPool;
    private OrderService orderService;

    public OrderController(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        this.orderService = new OrderService(connectionPool);
    }

    public void setRoutes(JavalinConfig config) {
        config.routes.get("/", ctx -> renderOrderForm(ctx));
        config.routes.get("/order-form", ctx -> renderOrderForm(ctx));
        config.routes.post("/create-order", ctx -> createOrder(ctx));
    }

    private void createOrder(Context ctx) {
        int height = Integer.parseInt(ctx.formParam("height"));
        int width = Integer.parseInt(ctx.formParam("width"));
        int depth = Integer.parseInt(ctx.formParam("depth"));
        String name = ctx.formParam("name");
        String address = ctx.formParam("address");
        String zipCode = ctx.formParam("zipCode");
        String email = ctx.formParam("email");
        String phonenumber = ctx.formParam("phonenumber");

        try {
            orderService.createOrder(height, width, depth, name, address, zipCode, email, phonenumber);
        }
        catch (DatabaseException e){
            ctx.attribute("error", e.getMessage());
            ctx.render("/order-form");
        }
    }

    private void renderOrderForm(Context ctx) {
        ctx.render("/order-form");
    }

}