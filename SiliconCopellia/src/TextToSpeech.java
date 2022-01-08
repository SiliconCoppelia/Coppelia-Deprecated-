/**
 * @Author: Anthony
 * @Date: 01/08/2022
 * @Description:Java code to convert text to speech
 *
 * Please refer to https://www.geeksforgeeks.org/converting-text-speech-java/
 * Add jsapi.jar, en_us.jar in the Speech fold/freetts-1.2/lib
 */


import java.util.Locale;



import javax.speech.Central;

import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;


public class TextToSpeech {

    String text;
    public TextToSpeech(String str){
        text=str;
        speak();
    }
    public void speak() {

        try {
            // Set property as Kevin Dictionary
            System.setProperty(
                    "freetts.voices",
                    "com.sun.speech.freetts.en.us"
                            + ".cmu_us_kal.KevinVoiceDirectory");

            // Register Engine
            Central.registerEngineCentral(
                    "com.sun.speech.freetts"
                            + ".jsapi.FreeTTSEngineCentral");

            // Create a Synthesizer
            Synthesizer synthesizer
                    = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));

            // Allocate synthesizer
            synthesizer.allocate();

            // Resume Synthesizer
            synthesizer.resume();

            // Speaks the given text
            // until the queue is empty.
            synthesizer.speakPlainText(
                    this.text, null);
            synthesizer.waitEngineState(
                    Synthesizer.QUEUE_EMPTY);

            // Deallocate the Synthesizer.
            synthesizer.deallocate();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}