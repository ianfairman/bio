package io.github.ianfairman.bio.nt;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

public class NucleotideName implements Comparable<NucleotideName>, CharSequence {

  private final String value;

  public NucleotideName(String value) {
    this.value = requireNonNull(value);
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NucleotideName that = (NucleotideName) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public int length() {
    return value.length();
  }

  @Override
  public char charAt(int i) {
    return value.charAt(i);
  }

  @Override
  public CharSequence subSequence(int i, int i1) {
    return value.subSequence(i, i1);
  }

  @Override
  public String toString() {
    return value;
  }

  @Override
  public int compareTo(NucleotideName nucleotideName) {
    return value.compareTo(nucleotideName.value);
  }
}
