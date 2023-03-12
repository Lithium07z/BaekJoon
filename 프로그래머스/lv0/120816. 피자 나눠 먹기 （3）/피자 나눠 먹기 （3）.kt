class Solution {
    fun solution(slice: Int, n: Int): Int {
        var count = 1
        var s = slice
        while (s < n) {
            s = ++count * slice
        }
        return count
    }
}