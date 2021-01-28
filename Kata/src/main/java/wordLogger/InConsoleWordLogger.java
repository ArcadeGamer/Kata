package wordLogger;

public class InConsoleWordLogger implements WordLogger {
    public void displayResult(String firstSubword, String secondSubword, String word) {
        System.out.println(firstSubword + " + " + secondSubword + " => " + word);
    }
}
