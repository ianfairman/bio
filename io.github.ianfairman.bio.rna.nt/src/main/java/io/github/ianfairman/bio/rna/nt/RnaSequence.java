package io.github.ianfairman.bio.rna.nt;

import io.github.ianfairman.text.Characters;
import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RnaSequence {

  private final List<RnaNucleotide> rnaNucleotides;

  public RnaSequence(Stream<RnaNucleotide> rnaNucleotidesStream) {
    this.rnaNucleotides = rnaNucleotidesStream.collect(Collectors.toList());
  }

  public static RnaSequence parse(String rna) {
    return new RnaSequence(Characters.parse(rna, RnaNucleotide::lookup));
  }

  @Override
  public String toString() {
    return rnaNucleotides.stream().map(RnaNucleotide::toString).collect(joining());
  }
}
