class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val openBraces = listOf('(', '{', '[')
        for (c in s) {
            if (c in openBraces) stack.addLast(c)
            else {
                if (stack.isEmpty()) return false
                val top = stack.removeLast()
                if (
                    (c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '{' && top != '}')
                ) return false
            }
        }

        return stack.isEmpty()

    }
}
