import java.util.Arrays;

public class Autocomplete {
  private Term[] terms;

  // Initializes the data structure from the given array of terms.
  // Complexity: O(N log N), where N is the number of terms
  public Autocomplete(Term[] terms) {
    if (terms == null) {
      throw new NullPointerException("bad input");
    }

    Arrays.sort(terms, Term.byLexicographicOrder());

    this.terms = terms;
  }

  // Returns all terms that start with the given prefix, in descending order of
  // weight.
  // Complexity: O(log N + M log M), where M is the number of matching terms
  public Term[] allMatches(String prefix) {
    if (prefix == null) {
      throw new NullPointerException("bad input");
    }

    int firstIndex = RangeBinarySearch.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    int lastIndex = RangeBinarySearch.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));

    if (firstIndex == -1) {
      return new Term[0];
    }

    Term[] matches = new Term[lastIndex - firstIndex + 1];

    for (int index = 0; index < lastIndex - firstIndex + 1; ++index) {
      matches[index] = terms[firstIndex + index];
    }

    Arrays.sort(matches, Term.byReverseWeightOrder());

    return matches;
  }

  // Returns the number of terms that start with the given prefix.
  // Complexity: O(log N)
  public int numberOfMatches(String prefix) {
    if (prefix == null) {
      throw new NullPointerException("bad input");
    }

    int firstIndex = RangeBinarySearch.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    int lastIndex = RangeBinarySearch.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));

    if (firstIndex < 0) {
      return 0;
    }

    return lastIndex - firstIndex + 1;
  }
}