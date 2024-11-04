package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }


  @Test
  void testForGoldAtIndexThousand() {
    ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
    assertEquals("gold", fuzzies.get(7000).color);
  }

  @Test
  void testLinearForSorted() {
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    assertEquals(7000, finder.linearSearch(sortedFuzzies));
  }

  @Test
  void testBinaryForSorted() {
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    assertEquals(7000, finder.binarySearch(sortedFuzzies));
  }

  @Test
  void failureInBinaryForRandomFuzzies() {
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
    assertEquals(-1, finder.binarySearch(randomFuzzies));
  }
}
