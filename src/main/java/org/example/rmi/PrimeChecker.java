package org.example.rmi;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimeChecker extends Remote {
    public boolean check (BigDecimal number) throws RemoteException;
}
