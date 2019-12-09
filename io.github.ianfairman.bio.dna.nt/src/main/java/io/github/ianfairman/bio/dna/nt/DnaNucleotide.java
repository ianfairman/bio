package io.github.ianfairman.bio.dna.nt;

import io.github.ianfairman.bio.nt.Nucleotide;
import io.github.ianfairman.bio.nt.NucleotideName;
import io.github.ianfairman.bio.nt.NucleotideSymbol;
import io.github.ianfairman.bio.rna.nt.RnaNucleotide;
import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Map;

public enum DnaNucleotide {
  ADENINE(Nucleotide.ADENINE, RnaNucleotide.ADENINE),
  CYTOSINE(Nucleotide.CYTOSINE, RnaNucleotide.CYTOSINE),
  GUANINE(Nucleotide.GUANINE, RnaNucleotide.GUANINE),
  THYMINE(Nucleotide.THYMINE, RnaNucleotide.URACIL);

  private final static Map<DnaNucleotide, DnaNucleotide> complements;

  static {
    complements = new HashMap<>();
    complements.put(ADENINE, THYMINE);
    complements.put(CYTOSINE, GUANINE);
    complements.put(GUANINE, CYTOSINE);
    complements.put(THYMINE, ADENINE);
  }

  private final Nucleotide nucleotide;
  private final RnaNucleotide transcribesTo;

  DnaNucleotide(Nucleotide nucleotide, RnaNucleotide transcribesTo) {
    this.nucleotide = requireNonNull(nucleotide);
    this.transcribesTo = requireNonNull(transcribesTo);
  }

  public NucleotideName getName() {
    return nucleotide.getName();
  }

  public NucleotideSymbol getSymbol() {
    return nucleotide.getSymbol();
  }

  public RnaNucleotide getTranscribesTo() {
    return transcribesTo;
  }

  public DnaNucleotide getComplement() {
    return complements.get(this);
  }

  public static DnaNucleotide lookup(char symbol) {
    for (DnaNucleotide value : values()) {
      if (value.getSymbol().getValue() == symbol) {
        return value;
      }
    }
    throw new IllegalArgumentException("Character is not a valid DNA nucleotide symbol: " + symbol);
  }

  @Override
  public String toString() {
    return getSymbol().toString();
  }
}
