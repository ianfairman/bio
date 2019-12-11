package io.github.ianfairman.bio.rna;

import io.github.ianfairman.bio.nt.Nucleotide;
import io.github.ianfairman.bio.nt.NucleotideName;
import io.github.ianfairman.bio.nt.NucleotideSymbol;
import static java.util.Objects.requireNonNull;

public enum RnaNucleotide {
  ADENINE(Nucleotide.ADENINE),
  CYTOSINE(Nucleotide.CYTOSINE),
  GUANINE(Nucleotide.GUANINE),
  URACIL(Nucleotide.URACIL);

  private final Nucleotide nucleotide;

  RnaNucleotide(Nucleotide nucleotide) {
    this.nucleotide = requireNonNull(nucleotide);
  }

  public NucleotideName getName() {
    return nucleotide.getName();
  }

  public NucleotideSymbol getSymbol() {
    return nucleotide.getSymbol();
  }

  public static RnaNucleotide lookup(char symbol) {
    for (RnaNucleotide value : values()) {
      if (value.getSymbol().getValue() == symbol) {
        return value;
      }
    }
    throw new IllegalArgumentException("Character is not a valid RNA nucleotide symbol: " + symbol);
  }

  @Override
  public String toString() {
    return getSymbol().toString();
  }
}
