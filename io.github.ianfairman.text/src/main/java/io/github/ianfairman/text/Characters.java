package io.github.ianfairman.text;

import java.util.function.Function;
import java.util.stream.Stream;

public class Characters {

  public static <T> Stream<T> parse(String text, Function<Character, T> lookupFunction) {
    return text.chars().mapToObj(c -> lookupFunction.apply((char) c));
  }
}
