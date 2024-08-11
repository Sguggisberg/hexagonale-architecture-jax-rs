package ch.guggisberg.stefan.hex.adapter.in.rest.common;

import ch.guggisberg.stefan.hex.model.customer.CustomerId;

public final class CustomerIdParser {
    public static CustomerId parseCustomerId(String customerId) {
        return new CustomerId(Integer.parseInt(customerId));
    }
}
