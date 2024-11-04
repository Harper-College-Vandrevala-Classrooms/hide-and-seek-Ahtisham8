package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {
  // Your code goes here!
  public static void main(String args[]) {
    FuzzyListGenerator generator = new FuzzyListGenerator();
    FuzzyFinder finder = new FuzzyFinder();

    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

    int testOne = finder.linearSearch(sortedFuzzies);
    int testTwo = finder.binarySearch(sortedFuzzies);
    int testThree = finder.linearSearch(randomFuzzies);
    int testFour = finder.binarySearch(randomFuzzies);

    System.out.println(testOne);
    System.out.println(testTwo);
    System.out.println(testThree);
    System.out.println(testFour);

  }

  public int linearSearch(ArrayList<Fuzzy> array) {
    for(int i = 0; i < array.size(); i++)
    {
      if (array.get(i).color == "gold") {
        return i;
      }
    }

    return -1;
  }

  public int binarySearch(ArrayList<Fuzzy> array) {
    int low = 0;
    int high = array.size() - 1;
    String gold = "gold";

    while (low <= high) {
      int middlePosition = low + (high - low) / 2;
      int res = gold.compareTo(array.get(middlePosition).color);

      if (res == 0) {
        return middlePosition;
      }
      if (res > 0) {
        low = middlePosition + 1;
      }
      else
        high = middlePosition -1;
      
    }

    return -1;
  }


}
