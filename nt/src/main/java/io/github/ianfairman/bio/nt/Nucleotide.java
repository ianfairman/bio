package io.github.ianfairman.bio.nt;

import static java.util.Objects.requireNonNull;

public enum Nucleotide {
  ADENINE(new NucleotideName("adenine"), new NucleotideSymbol('A')),
  CYTOSINE(new NucleotideName("cytosine"), new NucleotideSymbol('C')),
  GUANINE(new NucleotideName("guanine"), new NucleotideSymbol('G')),
  THYMINE(new NucleotideName("thymine"), new NucleotideSymbol('T')),
  URACIL(new NucleotideName("uracil"), new NucleotideSymbol('U'));

  private final NucleotideName name;
  private final NucleotideSymbol symbol;

  Nucleotide(NucleotideName name, NucleotideSymbol symbol) {
    this.name = requireNonNull(name);
    this.symbol = requireNonNull(symbol);
  }

  public NucleotideName getName() {
    return name;
  }

  public NucleotideSymbol getSymbol() {
    return symbol;
  }
}
