package io.github.ianfairman.bio.dna.nt;

import io.github.ianfairman.bio.rna.nt.RnaSequence;
import io.github.ianfairman.text.Characters;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import static java.util.Collections.reverse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;

public class DnaSequence {

  private final List<DnaNucleotide> dnaNucleotides;


  public DnaSequence(Stream<DnaNucleotide> dnaNucleotidesStream) {
    this.dnaNucleotides = dnaNucleotidesStream.collect(toList());
  }

  public static DnaSequence parse(String dna) {
    return new DnaSequence(Characters.parse(dna, DnaNucleotide::lookup));
  }

  public DnaCount counts() {
    Map<DnaNucleotide, Long> counts = new HashMap<>(dnaNucleotides.stream().collect(groupingBy(identity(), counting())));
    Stream.of(DnaNucleotide.values()).filter(x -> counts.get(x) == null).forEach(x -> counts.put(x, 0L));
    return new DnaCount(counts);
  }

  public RnaSequence transcribe() {
    return new RnaSequence(dnaNucleotides.stream().map(DnaNucleotide::getTranscribesTo));
  }

  public DnaSequence reverseComplement() {
    List<DnaNucleotide> reversed = new ArrayList<>(dnaNucleotides);
    reverse(reversed);
    return new DnaSequence(reversed.stream().map(DnaNucleotide::getComplement));
  }

  @Override
  public String toString() {
    return dnaNucleotides.stream().map(DnaNucleotide::toString).collect(joining());
  }
}
