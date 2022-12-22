package org.example.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRegister extends Remote {
    public void register (PrimeChecker checker) throws RemoteException;
}
