package io.github.ianfairman.bio.nt;

import java.util.Objects;

public class NucleotideSymbol implements Comparable<NucleotideSymbol> {

  private final char value;

  public NucleotideSymbol(char value) {
    if (value < 'A' || value > 'Z') {
      throw new IllegalArgumentException("invalid character: " + value);
    }
    this.value = value;
  }

  public char getValue() {
    return value;
  }

  @Override
  public String toString() {
    return Character.toString(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NucleotideSymbol that = (NucleotideSymbol) o;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public int compareTo(NucleotideSymbol nucleotideSymbol) {
    return Character.compare(value, nucleotideSymbol.value);
  }
}
