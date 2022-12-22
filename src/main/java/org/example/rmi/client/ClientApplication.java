package org.example.rmi.client;

import org.example.rmi.ClientRegister;
import org.example.rmi.PrimeChecker;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientApplication {

    private static final int STUB_PORT = 12346;
    private static final int REGISTRY_PORT = 12345;
    private static String HOST = "3.120.141.209"; //public IP ec2 server

    public static void main(String[] args) throws RemoteException, NotBoundException {
        if (args.length > 0) {
            HOST = args[0];
        }
        PrimeNumbersSearchClient client = new PrimeNumbersSearchClient();
        Registry remoteRegistry = LocateRegistry.getRegistry(HOST, REGISTRY_PORT);
        ClientRegister server = (ClientRegister) remoteRegistry.lookup("ClientRegister");
        PrimeChecker stub = (PrimeChecker) UnicastRemoteObject.exportObject(client, STUB_PORT);
        server.register(stub);
    }

}
