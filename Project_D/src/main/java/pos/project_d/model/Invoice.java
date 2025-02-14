package pos.project_d.model;

import java.math.BigDecimal;

/**
 * Invoice Model - Represents an invoice.
 */
public class Invoice {
    private int id;
    private String name;
    private int amount;
    private BigDecimal price;
    private BigDecimal total;
    private String status;
    private boolean pickedUp;

    public Invoice(int id, String name, int amount, BigDecimal price, BigDecimal total, String status, boolean pickedUp) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.total = total;
        this.status = status;
        this.pickedUp = pickedUp;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAmount() { return amount; }
    public BigDecimal getPrice() { return price; }
    public BigDecimal getTotal() { return total; }
    public String getStatus() { return status; }
    public boolean isPickedUp() { return pickedUp; }
}
