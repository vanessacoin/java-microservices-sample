package com.vanessa.orderservice.model;

public class Order {
    private Long id;
    private String product;
    private int quantity;
    private Object user;

    public Order(Long id, String product, int quantity, Object user) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }
}
