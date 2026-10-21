class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        HashMap<Integer, StringBuilder> groups = new HashMap<>();
        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            groups.putIfAbsent(freq, new StringBuilder());
            groups.get(freq).append(ch);
        }
        int maxSize = 0;
        int maxFreq = 0;
        String ans = "";

        for (int freq : groups.keySet()) {
            int size = groups.get(freq).length();

            if (size > maxSize ||
                (size == maxSize && freq > maxFreq)) {
                maxSize = size;
                maxFreq = freq;
                ans = groups.get(freq).toString();
            }
        }

        return ans;
    }
}
