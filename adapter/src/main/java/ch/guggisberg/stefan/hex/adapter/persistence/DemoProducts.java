package ch.guggisberg.stefan.hex.adapter.persistence;

import ch.guggisberg.stefan.hex.model.money.Money;
import ch.guggisberg.stefan.hex.model.product.Product;
import ch.guggisberg.stefan.hex.model.product.ProductId;

import java.util.Currency;
import java.util.List;

public final class DemoProducts {

    private static final Currency EUR = Currency.getInstance("EUR");

    public static final Product PLASTIC_SHEETING =
            new Product(
                    new ProductId("TTKQ8NJZ"),
                    "Plastic Sheeting",
                    "Clear plastic sheeting, tear-resistant, tough, and durable",
                    Money.of(EUR, 42, 99),
                    55);

    public static final Product COMPUTER_MONITOR =
            new Product(
                    new ProductId("K3SR7PBX"),
                    "27-Inch Curved Computer Monitor",
                    "Enjoy big, bold and stunning panoramic views",
                    Money.of(EUR, 159, 99),
                    24_081);
    public static final Product MONITOR_DESK_MOUNT =
            new Product(
                    new ProductId("Q3W43CNC"),
                    "Dual Monitor Desk Mount",
                    "Ultra wide and longer arm fits most monitors",
                    Money.of(EUR, 119, 90),
                    1_079);

    public static final Product LED_LIGHTS =
            new Product(
                    new ProductId("WM3BPG3E"),
                    "50ft Led Lights",
                    "Enough lights to decorate an entire room",
                    Money.of(EUR, 11, 69),
                    3_299);

    public static final List<Product> DEMO_PRODUCTS =
            List.of(PLASTIC_SHEETING, COMPUTER_MONITOR, MONITOR_DESK_MOUNT, LED_LIGHTS);

    private DemoProducts() {}
}