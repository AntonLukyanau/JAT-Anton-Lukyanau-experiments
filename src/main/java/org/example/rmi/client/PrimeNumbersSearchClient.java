package org.example.rmi.client;

import org.example.rmi.PrimeChecker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

public class PrimeNumbersSearchClient implements PrimeChecker {

    public boolean check(BigDecimal number) throws RemoteException {
        boolean isPrime = true;
        BigDecimal current = new BigDecimal(2);
        BigDecimal end = calculatedEnd(number);
        while (isNotOver(current, end)) {
            if (number.divideAndRemainder(current)[1].compareTo(BigDecimal.ZERO) == 0) {
                isPrime = false;
                break;
            }
            current = current.add(BigDecimal.ONE);
        }
        System.out.println("Client " + computerName() + ":\n" + number + ((isPrime) ? " is prime" : " is not prime"));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            return isPrime;
        }
        return isPrime;
    }

    private BigDecimal calculatedEnd(BigDecimal number) {
        BigDecimal sqrt = BigDecimal.valueOf(Math.sqrt(number.doubleValue()));
        BigDecimal div = number.divide(sqrt, RoundingMode.UP);
        return div.compareTo(sqrt) > 0 ? div : sqrt;
    }

    private boolean isNotOver(BigDecimal current, BigDecimal end) {
        return current.compareTo(end) < 0;
    }

    private String computerName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Unknown host";
        }
    }

}
