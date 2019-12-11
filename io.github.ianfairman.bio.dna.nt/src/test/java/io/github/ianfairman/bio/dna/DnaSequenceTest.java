package io.github.ianfairman.bio.dna;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Ian Fairman <ian.fairman@gmail.com>
 */
public class DnaSequenceTest {
    
    @Test
    public void shouldCalculateCorrectNucleotideCounts() {
        String input = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        DnaCount expectedCount = new DnaCount(Map.of(
             DnaNucleotide.ADENINE, 20L,
             DnaNucleotide.CYTOSINE, 12L,
             DnaNucleotide.GUANINE, 17L,
             DnaNucleotide.THYMINE, 21L));
        DnaSequence dnaSequence = DnaSequence.parse(input);
        assertEquals(expectedCount, dnaSequence.counts());
    }
}
