package ec.hulkStore.service;


import java.math.BigDecimal;
import java.util.Map;

import ec.hulkStore.model.Product;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout();

    BigDecimal getTotal();
}
