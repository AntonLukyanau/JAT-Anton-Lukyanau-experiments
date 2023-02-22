package org.example.livecoding.date20_02_2023;

public class LogoutCommand implements Action{
    @Override
    public void execute() {
        System.out.println("logout");
    }
}
