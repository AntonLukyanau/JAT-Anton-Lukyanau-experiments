package org.example.rmi.server;

import org.example.rmi.ClientRegister;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerApplication {

    private static final int STUB_PORT = 12344;
    private static final int REGISTRY_PORT = 12345;
    private static String SERVER_HOST = "95.155.10.44"; //public IP ec2 server

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        if (args.length > 0) {
            SERVER_HOST = args[0];
        }
        System.setProperty("java.rmi.server.hostname",SERVER_HOST);
        PrimeNumbersSearchServer server = new PrimeNumbersSearchServer();
        ClientRegister stub = (ClientRegister) UnicastRemoteObject.exportObject(server, STUB_PORT);
        Registry registry = LocateRegistry.createRegistry(REGISTRY_PORT);
        registry.bind("ClientRegister", stub);

        server.startSearch();
    }
}
