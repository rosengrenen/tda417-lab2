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

    int foundIndex = indexOf(a, key, comparator);

    if (foundIndex < 0) {
      return -1;
    }

    while (foundIndex > 0 && comparator.compare(a[foundIndex], a[foundIndex - 1]) == 0) {
      foundIndex = foundIndex - 1;
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

    int foundIndex = indexOf(a, key, comparator);

    if (foundIndex < 0) {
      return -1;
    }

    while (foundIndex < a.length - 1 && comparator.compare(a[foundIndex], a[foundIndex + 1]) == 0) {
      foundIndex = foundIndex + 1;
    }

    return foundIndex;
  }

  private static <Key> int indexOf(Key[] a, Key key, Comparator<Key> comparator) {
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
        foundIndex = middle;
        break;
      }
    }

    return foundIndex;
  }
}
