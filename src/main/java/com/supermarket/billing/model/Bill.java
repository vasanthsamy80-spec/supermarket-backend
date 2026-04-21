package com.supermarket.billing.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int billNumber;

    // ✅ FIXED (LIST OF ITEMS)
    @ElementCollection
    private List<BillItem> items;

    private double subtotal;
    private double gst;
    private double total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // GETTERS & SETTERS
    public Long getId() { return id; }

    public int getBillNumber() { return billNumber; }
    public void setBillNumber(int billNumber) { this.billNumber = billNumber; }

    public List<BillItem> getItems() { return items; }
    public void setItems(List<BillItem> items) { this.items = items; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public double getGst() { return gst; }
    public void setGst(double gst) { this.gst = gst; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}