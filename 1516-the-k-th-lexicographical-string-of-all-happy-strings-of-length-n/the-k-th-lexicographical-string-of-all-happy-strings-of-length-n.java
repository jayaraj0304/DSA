class Solution {
    public String getHappyString(int n, int k) {
        List<String> curr = new ArrayList<>();
        curr.add("a");
        curr.add("b");
        curr.add("c");

        if (n == 1) {
            return k <= 3 ? curr.get(k - 1) : "";
        }

        for (int len = 2; len <= n; len++) {
            List<String> next = new ArrayList<>();

            for (String s : curr) {
                for (char ch : new char[]{'a', 'b', 'c'}) {
                    if (s.charAt(s.length() - 1) != ch) {
                        next.add(s + ch);
                    }
                }
            }

            curr = next;
        }

        return k <= curr.size() ? curr.get(k - 1) : "";
    }
}
