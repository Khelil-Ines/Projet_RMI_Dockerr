package com.inesaya.core.rmi.remoteclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



import com.inesaya.core.rmi.rminterface.Configuration;
import com.inesaya.core.rmi.rminterface.Product;
import com.inesaya.core.rmi.rminterface.RemoteInterface;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class RemoteClient {

    static Registry reg;

    public static void main(String[] args) {
        try {
            val remoteHost = Configuration.getRemoteHost();
            int remotePort = Configuration.getRemotePort();

            log.info("Locating Registry: remoteHost:{} port:{}", remoteHost, remotePort);
            reg = LocateRegistry.getRegistry(remoteHost, remotePort);

            log.info("Lookup Interface: remoteID:{}", Configuration.REMOTE_ID);
            RemoteInterface rmiInterface = (RemoteInterface) reg.lookup(Configuration.REMOTE_ID);

            // Request a product by ID
            String productId = "101";
            Product product = rmiInterface.getProductById(productId);
            if (product != null) {
                log.info("Product received: {}", product);
                System.out.println("Product received: " + product);
            } else {
                log.info("Product not found.");
                System.out.println("Product not found.");
            }

        } catch (RemoteException | NotBoundException e) {
            log.error("Client exception: " + e.getMessage(), e);
        }
    }
}
