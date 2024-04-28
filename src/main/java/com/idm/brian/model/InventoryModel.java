package com.idm.brian.model;

public class InventoryModel {
    private long inventory_id;
    private String Location;
    private int quantity_available;

    public long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }
}
