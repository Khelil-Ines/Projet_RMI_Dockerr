package com.inesaya.core.rmi.rminterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote{

    Product getProductById(String productId) throws RemoteException;

}
