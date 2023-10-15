package javasolutionsforalgorithms.revision_v2.google.unstructured;

/**
 * <a href="https://leetcode.com/problems/first-bad-version/">...</a>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class TheFirstBadVersion extends VersionControl {

    /**
     * The firstBadVersion() method takes an integer n as input and returns the first bad version.
     *
     * Inside the method, we initialize two variables: left and right. left represents the leftmost version in the search range, which is initially set to 1 (the first version). right represents the rightmost version in the search range, which is initially set to n (the last version).
     *
     * We enter a while loop with the condition left < right.
     * This loop continues until the search range is narrowed down to a single version.
     *
     * Inside the while loop, we calculate the middle version using the formula mid = left + (right - left) / 2.
     * This ensures that we avoid integer overflow when calculating the middle version.
     *
     * We call the isBadVersion() method with the mid version.
     * This method, which is assumed to be implemented in a separate class called VersionControl, returns true if the version is bad and false otherwise.
     *
     * If isBadVersion(mid) returns true, it means the current version mid is either bad or a later version is bad.
     * In this case, we update right = mid to search for the first bad version in the left half of the range.
     *
     * If isBadVersion(mid) returns false, it means the current version mid is good. In this case, we update left = mid + 1 to search for the first bad version in the right half of the range.
     *
     * The loop continues until left and right are equal, which indicates that the search range has been narrowed down
     * to a single version. At this point, we have found the first bad version, and we return either left or right.
     *
     * Note that the code assumes that the isBadVersion() method is implemented in a class called VersionControl,
     * which you will need to define separately. The implementation of the isBadVersion() method will depend on your specific logic for determining whether a version is bad or not.
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left)/2; // to prevent stackoverflow

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}
