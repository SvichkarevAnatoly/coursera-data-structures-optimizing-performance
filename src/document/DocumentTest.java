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
}