package textgen;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class MarkovTextGeneratorLoLTest {

    @Test
    public void train() {
        MarkovTextGeneratorLoL mtg = new MarkovTextGeneratorLoL(new Random(0));
        mtg.train("hi Polina");
    }

    @Test
    public void generateText() {
        MarkovTextGeneratorLoL mtg = new MarkovTextGeneratorLoL(new Random(0));
        mtg.train("hi Polina");

        String generatedText = mtg.generateText(10);
        assertEquals(generatedText, "hi Polina hi Polina hi Polina hi Polina hi Polina");
    }

    @Test
    public void retrain() {
        MarkovTextGeneratorLoL mtg = new MarkovTextGeneratorLoL(new Random(0));

        String text = "hi Polina";
        mtg.train(text);
        mtg.retrain(text);

        String generatedText = mtg.generateText(10);
        assertEquals(generatedText, "hi Polina hi Polina hi Polina hi Polina hi Polina");
    }

    @Test
    public void retrainOnNullText() {
        MarkovTextGeneratorLoL mtg = new MarkovTextGeneratorLoL(new Random(0));

        String text = "hi Polina";
        mtg.train(text);
        mtg.retrain(null);

        assertEquals("", mtg.generateText(10));
    }
}