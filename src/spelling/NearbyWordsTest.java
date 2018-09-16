package spelling;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class NearbyWordsTest {

    @Test
    public void distanceOne() {
        DictionaryBST dict = new DictionaryBST();
        dict.addWord("cab");
        NearbyWords nearbyWords = new NearbyWords(dict);

        List<String> suggestions = nearbyWords.distanceOne("a", false);
        assertThat(suggestions).hasSize(76);

        suggestions = nearbyWords.distanceOne("cat", false);
        assertThat(suggestions).hasSize(179);

        suggestions = nearbyWords.distanceOne("cat", true);
        assertThat(suggestions).hasSize(1);
    }
}