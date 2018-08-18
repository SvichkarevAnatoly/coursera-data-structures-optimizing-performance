package document;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DocumentTest {

    @Test
    public void countSyllables() {
        BasicDocument document = new BasicDocument("");

        assertEquals(document.countSyllables("cat"), 1);
        assertEquals(document.countSyllables("caaat"), 1);
        assertEquals(document.countSyllables("a"), 1);
        assertEquals(document.countSyllables("polina"), 3);

        // e at end case
        assertEquals(document.countSyllables("the"), 1);
        assertEquals(document.countSyllables("THE"), 1);
        assertEquals(document.countSyllables("coffe"), 1);
        assertEquals(document.countSyllables("COFFE"), 1);
        assertEquals(document.countSyllables("coffee"), 2);

        // extra
        assertEquals(document.countSyllables("contiguous"), 3);
    }

    @Test
    public void getNumSentences() {
        assertEquals(new BasicDocument("").getNumSentences(), 0);
        assertEquals(new BasicDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5.").getNumSentences(), 4);
    }

    @Test
    public void getFleschScore() {
        assertEquals(new BasicDocument("A").getFleschScore(), 121.220, 0.001);
        assertEquals(new BasicDocument("A.").getFleschScore(), 121.220, 0.001);
        assertEquals(new BasicDocument("Aba.").getFleschScore(), 36.620, 0.001);

        assertEquals(new BasicDocument("Here is a series of test sentences. Your program should "
                + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
                + "the correct amount of syllables (example, for example), "
                + "but most of them will.")
                .getFleschScore(), 70.051, 0.001);
    }
}