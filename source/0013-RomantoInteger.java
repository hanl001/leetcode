class Solution {

    private static final Map<String, Integer> romanToInt = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            }};

    public int romanToInt(String s) {
        int total = 0;
        int latestNum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char roman = s.charAt(i);
            int num = romanToInt.get(String.valueOf(roman));
            if (latestNum > num) {
                total -= num;
            } else {
                total += num;
            }
            latestNum = num;
        }
        return total;
    }
}
