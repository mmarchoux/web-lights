package fr.emse.majeureinfo.springbootintro.hello;

public class ConsoleGreetingService implements GreetingService {

    @Override
    public void greet(String name){
        System.out.println("Hello, Spring!");
    }
}
