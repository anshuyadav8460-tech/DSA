class Solution {
    public int similarPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int pairs = 0;
        for (String word : words) {
            HashSet<Character> set = new HashSet<>();
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
            List<Character> list = new ArrayList<>(set);
            Collections.sort(list);
            StringBuilder key = new StringBuilder();
            for (char ch : list) {
                key.append(ch);
            }
            String str = key.toString();
            pairs += map.getOrDefault(str, 0);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return pairs;
    }
}
