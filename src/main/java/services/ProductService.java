package services;

import models.Products;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductService {
    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());
    public List<Products> products = new LinkedList<>();
    private int nextId = 1;

    public ProductService() {
        // Add three products to the list
        addProduct(new Products(0, 1, "Chocolate Cake", 10, 50, "sugar-free"));
        addProduct(new Products(0, 2, "Product B", 200, 150, "gluten-free"));
    }

    public int addProduct(Products product) {
        product.setId(nextId++);
        products.add(product);
        return product.getId();
    }

    public Products getProductById(int id) {
        for (Products product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct(int id, Products updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, updatedProduct);
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info(String.format("Product with ID %d updated successfully.", id));
                }
                return;
            }
        }
        if (LOGGER.isLoggable(Level.WARNING)) {
            LOGGER.warning(String.format("Product with ID %d not found.", id));
        }
    }

    public void printAllProducts() {
        if (products.isEmpty()) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("No products available.");
            }
        } else {
            for (Products product : products) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info(product.toString());
                }
            }
        }
    }

    public void removeProduct(int id) {
        boolean removed = products.removeIf(product -> product.getId() == id);
        if (removed) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(String.format("Product with ID %d removed successfully.", id));
            }
        } else {
            if (LOGGER.isLoggable(Level.WARNING)) {
                LOGGER.warning(String.format("Product with ID %d not found.", id));
            }
        }
    }

    public void searchProductsByName(String searchQuery) {
        List<Products> matchingProducts = new ArrayList<>();
        for (Products product : products) {
            if (product.getName().toLowerCase().contains(searchQuery.toLowerCase())) {
                matchingProducts.add(product);
            }
        }
        if (matchingProducts.isEmpty()) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("No products found matching the search query.");
            }
        } else {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Search Results:");
                for (Products product : matchingProducts) {
                    LOGGER.info(String.format("ID: %d, Name: %s, Price: $%d", product.getId(), product.getName(), product.getPrice()));
                }
            }
        }
    }

    public void filterProductsByDietaryNeeds(String filter) {
        List<Products> filteredProducts = new ArrayList<>();
        for (Products product : products) {
            if (product.getDietaryInfo().toLowerCase().contains(filter.toLowerCase())) {
                filteredProducts.add(product);
            }
        }
        if (filteredProducts.isEmpty()) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("No products found matching the dietary need or allergy.");
            }
        } else {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info("Filtered Products:");
                for (Products product : filteredProducts) {
                    LOGGER.info(String.format("ID: %d, Name: %s, Price: $%d", product.getId(), product.getName(), product.getPrice()));
                }
            }
        }
    }

    public List<Products> getProductsFromStores(StoreService storeService) {
        return new ArrayList<>();
    }
}
