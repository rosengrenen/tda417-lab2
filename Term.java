import java.util.Comparator;

public class Term {
  private String query;
  private long weight;

  // Initializes a term with the given query string and weight.
  public Term(String query, long weight) {
    if (query == null) {
      throw new NullPointerException("lmao skriv ett ord lol");
    }

    if (weight < 0) {
      throw new IllegalArgumentException("lmao this cant exist");
    }

    this.query = query;
    this.weight = weight;

  }

  // Compares the two terms in lexicographic order by query.
  public static Comparator<Term> byLexicographicOrder() {
    return new Comparator<Term>() {
      @Override
      public int compare(Term leftTerm, Term rightTerm) {
        return leftTerm.query.compareTo(rightTerm.query);
      }
    };
  }

  // Compares the two terms in descending order by weight.
  public static Comparator<Term> byReverseWeightOrder() {
    return new Comparator<Term>() {
      @Override
      public int compare(Term leftTerm, Term rightTerm) {
        if (leftTerm.weight < rightTerm.weight) {
          return -1;
        } else if (leftTerm.weight > rightTerm.weight) {
          return 1;
        }

        return 0;
      }
    };
  }

  // Compares the two terms in lexicographic order,
  // but using only the first k characters of each query.
  public static Comparator<Term> byPrefixOrder(int k) {
    if (k < 0) {
      throw new IllegalArgumentException("LMAOOOOOO<3");
    }

    return new Comparator<Term>() {
      @Override
      public int compare(Term leftTerm, Term rightTerm) {
        return leftTerm.query.substring(0, k).compareTo(rightTerm.query.substring(0, k));
      }
    };
  }

  // Returns a string representation of this term in the following format:
  // the weight, followed by whitespace, followed by the query.
  public String toString() {
    return String.format("%12d    %s", this.weight, this.query);
  }
}