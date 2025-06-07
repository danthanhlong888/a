package com.demo11.a.search.logarithmic;
/**
 * Implements various binary search methods with different styles and use cases.
 *
 * <p><b>Khi nào nên áp dụng Binary Search?</b></p>
 * <ul>
 *   <li>**Dữ liệu đã được sắp xếp** (array hoặc list).</li>
 *   <li>Cần tìm kiếm nhanh với độ phức tạp O(log n) thay vì O(n) như Linear Search.</li>
 *   <li>Size lớn, search nhiều lần trên cùng bộ dữ liệu đã sắp xếp.</li>
 *   <li>Khi cần tìm vị trí chèn (lower bound, upper bound) trong các thuật toán liên quan đến khoảng hoặc dãy tăng.</li>
 * </ul>
 *
 * <h2>Độ phức tạp thời gian và không gian</h2>
 * <ul>
 *   <li><b>Best Case:</b> O(1) &mdash; khi phần tử cần tìm trùng với phần tử ở giữa ngay lần kiểm tra đầu tiên.</li>
 *   <li><b>Average Case:</b> O(log n)</li>
 *   <li><b>Worst Case:</b> O(log n)</li>
 * </ul>
 * <p><b>Auxiliary Space:</b> O(1) đối với các cách triển khai iterative.
 * Nếu tính cả bộ nhớ gọi đệ quy thì auxiliary space là O(log n).</p>
 */
public final class BinarySearch extends Search{
    private BinarySearch() {
        // no-op
    }

    /**
     * Iterative binary search with left-closed right-closed interval [left, right].
     * <p>
     * <b>Ý tưởng:</b> Thu hẹp khoảng tìm kiếm bao gồm cả chỉ số left và right.
     * <br>
     * <b>Dùng khi:</b> Cần hiệu năng cao, tránh đệ quy, và muốn kiểm soát dễ dàng.
     * <br>
     * <b>Hiệu năng:</b> O(log n), tốt nhất trong các cách iterative.
     * </p>
     */
    public static int binarySearchClosedInterval(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Iterative binary search with left-closed right-open interval [left, right).
     * <p>
     * <b>Ý tưởng:</b> Thu hẹp khoảng tìm kiếm bao gồm left, nhưng không bao gồm right.
     * <br>
     * <b>Dùng khi:</b> Phù hợp với API Java Collections, nơi khoảng tìm kiếm kiểu này được ưu tiên.
     * <br>
     * <b>Hiệu năng:</b> O(log n), tương đương cách trên.
     * </p>
     */
    public static int binarySearchOpenInterval(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    /**
     * Recursive binary search with left-closed right-closed interval [left, right].
     * <p>
     * <b>Ý tưởng:</b> Đệ quy thu hẹp khoảng tìm kiếm từ cả 2 đầu.
     * <br>
     * <b>Dùng khi:</b> Cần code ngắn gọn, dễ đọc, học thuật, không dùng với dữ liệu lớn.
     * <br>
     * <b>Hiệu năng:</b> O(log n), nhưng tốn stack và có nguy cơ stack overflow.
     * </p>
     */
    public static int recursiveBinarySearch(int[] arr, int target) {
        return recursiveBinarySearchHelper(arr, target, 0, arr.length - 1);
    }

    private static int recursiveBinarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;

        if (arr[mid] < target) {
            return recursiveBinarySearchHelper(arr, target, mid + 1, right);
        } else {
            return recursiveBinarySearchHelper(arr, target, left, mid - 1);
        }
    }

    /**
     * Binary search on generic List&lt;T&gt;.
     * <p>
     * <b>Ý tưởng:</b> Áp dụng binary search trên danh sách với Comparator hoặc Comparable.
     * <br>
     * <b>Dùng khi:</b> Làm việc với List, không phải mảng nguyên thủy.
     * <br>
     * <b>Hiệu năng:</b> O(log n), tương tự mảng.
     * </p>
     */
    public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T target) {
        Objects.requireNonNull(list, "list");
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = target.compareTo(list.get(mid));
            if (cmp == 0) return mid;
            else if (cmp > 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * Lower bound: tìm vị trí đầu tiên mà phần tử >= target (chèn được target vào đây).
     * <p>
     * <b>Ý tưởng:</b> Biến thể binary search tìm vị trí chèn phù hợp.
     * <br>
     * <b>Dùng khi:</b> Cần tìm khoảng hoặc xử lý các bài toán dãy tăng, khoảng bao phủ.
     * <br>
     * <b>Hiệu năng:</b> O(log n).
     * </p>
     */
    public static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    /**
     * Upper bound: tìm vị trí đầu tiên mà phần tử > target.
     * <p>
     * <b>Ý tưởng:</b> Biến thể binary search tìm vị trí chèn lớn hơn target.
     * <br>
     * <b>Dùng khi:</b> Xử lý bài toán với khoảng hoặc tìm phạm vi đặc biệt.
     * <br>
     * <b>Hiệu năng:</b> O(log n).
     * </p>
     */
    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    /**
     * Exponential search followed by binary search.
     * <p>
     * <b>Ý tưởng:</b> Khi không biết độ dài mảng, tăng phạm vi tìm kiếm theo cấp số nhân,
     * sau đó dùng binary search trên phạm vi đã xác định.
     * <br>
     * <b>Dùng khi:</b> Mảng có kích thước rất lớn hoặc không biết trước độ dài.
     * <br>
     * <b>Hiệu năng:</b> O(log n), nhưng có overhead từ bước tìm phạm vi.
     * </p>
     */
    public static int exponentialSearch(int[] arr, int target) {
        if (arr.length == 0) return -1;
        int bound = 1;
        while (bound < arr.length && arr[bound] < target) {
            bound *= 2;
        }
        int left = bound / 2;
        int right = Math.min(bound, arr.length - 1);
        return binarySearchClosedInterval(arr, target, left, right);
    }

    // Helper for exponentialSearch with custom bounds
    private static int binarySearchClosedInterval(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
