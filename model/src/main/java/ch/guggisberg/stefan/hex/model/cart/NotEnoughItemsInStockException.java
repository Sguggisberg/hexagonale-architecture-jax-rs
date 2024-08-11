package ch.guggisberg.stefan.hex.model.product;

public class NotEnoughItemsInStockException extends Exception {

    private final int itemsInStock;

    public NotEnoughItemsInStockException(String message, int itemsInStock) {
        super(message);
        this.itemsInStock = itemsInStock;
    }

    public int itemsInStock() {
        return itemsInStock;
    }
}
