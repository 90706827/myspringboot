package com.jangni.form;

import java.util.List;

public class OrderPostForm {

    private Order order;
    private List<OrderDetail> details;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }
}
