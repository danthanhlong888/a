package com.demo11.a.search.linear;

import com.demo11.a.search.Search;
import java.util.List;
import java.util.Objects;

/**
 * Performs a linear (sequential) search over a collection.
 * <p>
 * Elements are scanned one&nbsp;by&nbsp;one from the start of the list until the
 * target is found or the end is reached. The algorithm stops immediately once
 * a match is detected, so the actual runtime depends on where (or whether)
 * the key occurs.
 * </p>
 *
 * <h2>Time Complexity</h2>
 * <ul>
 *   <li><b>Best&nbsp;Case:</b> <code>O(1)</code> &mdash; the key is at the first index.</li>
 *   <li><b>Worst&nbsp;Case:</b> <code>O(n)</code> &mdash; the key is at the last index or
 *       not present.</li>
 *   <li><b>Average&nbsp;Case:</b> <code>O(n)</code></li>
 * </ul>
 *
 * <h2>Auxiliary Space</h2>
 * <p><code>O(1)</code> &mdash; apart from a small, fixed number of local variables, no
 * additional space proportional to the input size is required.</p>
 */
public final class LinearSearch extends Search {

    private LinearSearch() {
        // no‑op
    }

    /**
     * Sentinel linear search.
     * <p>
     * <b>Ý tưởng:</b> Thêm một "sentinel" (giá trị mục tiêu) vào cuối mảng để loại bỏ kiểm tra ranh giới mảng.
     * <br>
     * <b>Dùng khi:</b> Cần hiệu năng tối đa và có thể thay đổi mảng tạm thời.
     * <br>
     * <b>Hiệu năng:</b> Nhanh nhất trong các biến thể — giảm được 1 lần kiểm tra điều kiện trong vòng lặp.
     * </p>
     *
     * @param arr    the array to search
     * @param target the value to find
     * @return index of the target element, or -1 if not found
     */
    public static int sentinel(int[] arr, int target) {
        int n = arr.length;
        int last = arr[n - 1];
        arr[n - 1] = target;  // Set sentinel

        int i = 0;
        while (arr[i] != target) {
            i++;
        }

        arr[n - 1] = last; // Restore original value

        if (i < n - 1 || arr[n - 1] == target) {
            return i;
        }
        return -1;
    }

    /**
     * Iterative linear search.
     * <p>
     * <b>Ý tưởng:</b> Duyệt từng phần tử từ đầu đến cuối và so sánh với mục tiêu.
     * <br>
     * <b>Dùng khi:</b> Trường hợp phổ thông, dễ hiểu, không cần tối ưu đặc biệt.
     * <br>
     * <b>Hiệu năng:</b> Ổn định và đơn giản, hiệu suất tốt trong hầu hết tình huống (trung bình O(n)).
     * </p>
     *
     * @param arr    the array to search
     * @param target the value to find
     * @return index of the target element, or -1 if not found
     */
    public static int interative(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Early exit — best case O(1)
            }
        }
        return -1;
    }

    /**
     * Iterative linear search on generic list.
     * <p>
     * <b>Ý tưởng:</b> Duyệt tuần tự danh sách và so sánh từng phần tử với khóa tìm.
     * <br>
     * <b>Dùng khi:</b> Làm việc với danh sách đối tượng, không phải mảng nguyên thủy.
     * <br>
     * <b>Hiệu năng:</b> Tương tự như tìm trong mảng — trung bình O(n), không dùng sentinel được.
     * </p>
     *
     * @param list the list to scan (must not be {@code null})
     * @param key  the element to locate (may be {@code null})
     * @param <T>  the element type
     * @return the zero‑based index of {@code key}, or {@code -1} if absent
     * @throws NullPointerException if {@code list} is {@code null}
     */
    public static <T> int interative(List<T> list, T key) {
        Objects.requireNonNull(list, "list");
        for (int i = 0, n = list.size(); i < n; i++) {
            if (Objects.equals(list.get(i), key)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Recursive linear search.
     * <p>
     * <b>Ý tưởng:</b> Duyệt từng phần tử qua lời gọi đệ quy.
     * <br>
     * <b>Dùng khi:</b> Muốn minh họa tư duy đệ quy hoặc dùng trong môi trường functional.
     * <br>
     * <b>Hiệu năng:</b> Tệ nhất — dễ gây tràn stack khi mảng lớn, không phù hợp cho sản phẩm thực tế.
     * </p>
     *
     * @param arr    the array to search
     * @param target the value to find
     * @return index of the target element, or -1 if not found
     */
    public static int recursive(int[] arr, int target) {
        return recursiveHelper(arr, target, 0);
    }

    private static int recursiveHelper(int[] arr, int target, int index) {
        if (index >= arr.length) return -1;
        if (arr[index] == target) return index;
        return recursiveHelper(arr, target, index + 1);
    }
}
