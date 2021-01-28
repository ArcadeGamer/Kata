import sorting.WordSorter;
import wordLogger.InConsoleWordLogger;
import wordfinder.WordFinder;
import wordfetcher.InFileWordFetcher;

public class Main {

    public static void main(String[] args) {

        WordFinder finder = new WordFinder(new InFileWordFetcher(), new WordSorter(), new InConsoleWordLogger()); // TODO : Tasser l'injection de dépendances d'ici

        finder.findAllComposedWords(9); //TODO : Abstraire ici
    }
}
