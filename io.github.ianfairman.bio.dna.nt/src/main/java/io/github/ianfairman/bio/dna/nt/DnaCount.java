package io.github.ianfairman.bio.dna.nt;

import java.util.AbstractMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import java.util.Set;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;

public class DnaCount extends AbstractMap<DnaNucleotide, Long> {

  private final Map<DnaNucleotide, Long> counts;

  public DnaCount(Map<DnaNucleotide, Long> counts) {
    this.counts = requireNonNull(counts);
  }
  public double getGcContent() {
    return (double) (counts.getOrDefault(DnaNucleotide.GUANINE, 0L) + counts.getOrDefault(DnaNucleotide.CYTOSINE, 0L))
            / counts.values().stream().mapToDouble(Long::doubleValue).sum();
  }

  @Override
  public Set<Entry<DnaNucleotide, Long>> entrySet() {
    return counts.entrySet();
  }

  @Override
  public String toString() {
    return Stream.of(DnaNucleotide.values()).map(n -> Long.toString(counts.get(n))).collect(joining(" "));
  }
}
