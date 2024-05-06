package com.inesaya.core.rmi.remoteserver;

import com.inesaya.core.rmi.rminterface.Product;
import com.inesaya.core.rmi.rminterface.RemoteInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class RMIImplementation extends UnicastRemoteObject implements RemoteInterface {
    private static final long serialVersionUID = 1L;

    private Map<String, Product> productCatalog;

    protected RMIImplementation() throws RemoteException {
        super();
        // Initialize the catalog with some sample products
        productCatalog = new HashMap<>();
        productCatalog.put("101", new Product("101", "Laptop", 1200.99));
        productCatalog.put("102", new Product("102", "Smartphone", 699.99));
    }

    @Override
    public Product getProductById(String productId) throws RemoteException {
        // Retrieve the product from the catalog or return null if not found
        return productCatalog.getOrDefault(productId, null);
    }
}
