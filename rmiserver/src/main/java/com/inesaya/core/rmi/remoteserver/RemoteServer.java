package com.inesaya.core.rmi.remoteserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.inesaya.core.rmi.rminterface.Configuration;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class RemoteServer {

    public static void main(String[] args) throws RemoteException {
        
        // Crée l'implémentation du service
        val rmiImplementation = new RMIImplementation();

        // Crée un registre sur le port spécifié
        val registry = LocateRegistry.createRegistry(Configuration.getRemotePort());

        // Utilise rebind pour associer ou remplacer l'implémentation
        registry.rebind(Configuration.REMOTE_ID, rmiImplementation);

        log.info("Rebinded id:{} port:{}", Configuration.REMOTE_ID, Configuration.getRemotePort());
    }
}