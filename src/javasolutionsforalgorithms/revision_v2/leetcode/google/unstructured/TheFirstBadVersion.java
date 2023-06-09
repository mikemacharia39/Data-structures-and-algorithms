package javasolutionsforalgorithms.revision_v2.leetcode.google.unstructured;

public class TheFirstBadVersion extends VersionControl {

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
