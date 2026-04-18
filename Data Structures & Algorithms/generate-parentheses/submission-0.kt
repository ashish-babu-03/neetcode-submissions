class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val expectedSize = n*2
        val result = mutableListOf<String>()

        fun recurse (str: String, l: Int, r: Int) {
            if (str.length == expectedSize) {
                result.add(str)
                return
            }
            if (l < n) {
                recurse(str + "(", l+1, r)
            }
            if (r<l) {
                recurse (str +")", l, r+1)
            }
        }
        recurse("",0,0)
        return result
    }
}
