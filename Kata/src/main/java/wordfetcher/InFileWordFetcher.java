package wordfetcher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InFileWordFetcher implements WordFetcher {

    private static final String WORDSFILEPATH = "data/wordlist.txt";

    public String[] getWords() {
        ArrayList<String> words = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(WORDSFILEPATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while(bufferedReader.ready()) {
                words.add(bufferedReader.readLine()); // TODO : On pourrait faire un check ici en fonction de la longueur pour créer un objet qui contient la set et le array avec une factory
            }

        } catch (FileNotFoundException exception) {
            // TODO : Créer un exception mapper
        } catch (IOException exception) {
            // TODO : Créer un exception mapper
        }
        return words.toArray(new String[words.size()]);
    }
}
