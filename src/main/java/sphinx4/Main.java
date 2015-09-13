/**
 * Created by Jorge on 09/09/2015.
 */
package sphinx4;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        // Set path to acoustic model
        configuration.setAcousticModelPath("src/main/resources/es-es/acoustic_model");
        // Set path to dictionary
        configuration.setDictionaryPath("src/main/resources/es-es/voxforge_es_sphinx.dic");
        // Set language model
        configuration.setGrammarPath("src/main/resources/es-es");
        configuration.setUseGrammar(true);
        configuration.setGrammarName("es_grammar.gram");

        try {
            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            recognizer.startRecognition(true);
            System.out.println("\n\n" + recognizer.getResult().getHypothesis() + "\n\n");
            recognizer.stopRecognition();
        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}

