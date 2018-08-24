package document;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EfficientDocumentTest {

    @Test
    public void processText() {
        EfficientDocument document = new EfficientDocument("I love mother. I love father.");

        assertEquals(document.getNumSentences(), 2);
        assertEquals(document.getNumWords(), 6);
        assertEquals(document.getNumSyllables(), 8);
    }
}