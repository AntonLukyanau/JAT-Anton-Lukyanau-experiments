package org.example.rmi.server;

import org.example.rmi.ClientRegister;
import org.example.rmi.PrimeChecker;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrimeNumbersSearchServer implements ClientRegister {

    private final BlockingQueue<PrimeChecker> availableCheckers = new LinkedBlockingQueue<>();
    private BigDecimal number = BigDecimal.ONE;

    public void register(PrimeChecker checker) throws RemoteException {
        availableCheckers.add(checker);
    }

    public void startSearch() {
        long startTime = System.currentTimeMillis();
        while (true/*System.currentTimeMillis() - startTime < 100000*/) {
            try {
                final PrimeChecker checker = availableCheckers.take();
                final BigDecimal numberToCheck = increment();
                new Thread(() -> {
                    try {
                        if (checker.check(numberToCheck)) {
                            System.out.println(numberToCheck);
                        }
                        availableCheckers.add(checker);
                    } catch (RemoteException e) {
                        System.out.println("Client disconnected or unknown error occurred");
                    }
                }).start();
            } catch (InterruptedException ignored) {
            }
        }
    }

    private synchronized BigDecimal increment() {
        number = number.add(BigDecimal.ONE);
        return number;
    }

}
