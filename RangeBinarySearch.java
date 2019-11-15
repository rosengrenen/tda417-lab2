import java.util.Comparator;

public class RangeBinarySearch {
  // Returns the index of the first key in a[] that equals the search key, or -1
  // if no such key.
  // Complexity: O(log N), where N is the length of the array
  public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    if (a == null) {
      throw new NullPointerException("array is null");
    }

    if (key == null) {
      throw new NullPointerException("key is null");
    }

    if (comparator == null) {
      throw new NullPointerException("comparator is null");
    }

    int lo = 0;
    int hi = a.length - 1;
    int foundIndex = -1;

    while (lo <= hi) {
      int middle = (lo + hi) / 2;
      int value = comparator.compare(a[middle], key);
      if (value < 0) {
        lo = middle + 1;
      } else if (value > 0) {
        hi = middle - 1;
      } else {
        if (hi - lo <= 1) {
          foundIndex = middle;
          break;
        }
        hi = middle;
      }
    }

    if (foundIndex < 0) {
      return -1;
    }

    return foundIndex;
  }

  // Returns the index of the last key in a[] that equals the search key, or -1 if
  // no such key.
  // Complexity: O(log N)
  public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    if (a == null) {
      throw new NullPointerException("array is null");
    }

    if (key == null) {
      throw new NullPointerException("key is null");
    }

    if (comparator == null) {
      throw new NullPointerException("comparator is null");
    }

    int lo = 0;
    int hi = a.length - 1;
    int foundIndex = -1;

    while (lo <= hi) {
      int middle = (int) Math.ceil((double) (lo + hi) / 2.0);
      int value = comparator.compare(a[middle], key);
      if (value < 0) {
        lo = middle + 1;
      } else if (value > 0) {
        hi = middle - 1;
      } else {
        if (hi - lo <= 1) {
          foundIndex = middle;
          break;
        }
        lo = middle;
      }
    }

    if (foundIndex < 0) {
      return -1;
    }

    return foundIndex;
  }
}
