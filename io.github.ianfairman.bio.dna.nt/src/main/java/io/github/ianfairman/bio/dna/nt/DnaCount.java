package io.github.ianfairman.bio.dna.nt;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import java.util.Set;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;

public class DnaCount extends AbstractMap<DnaNucleotide, Long> {

    private final Map<DnaNucleotide, Long> counts;

    public DnaCount(Map<DnaNucleotide, Long> counts) {
        this.counts = new HashMap<>(requireNonNull(counts));
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.counts);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DnaCount other = (DnaCount) obj;
        if (!Objects.equals(this.counts, other.counts)) {
            return false;
        }
        return true;
    }
}
