class Solution {
    private static final Map<Integer, String> intToRoman = new HashMap<Integer, String>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
            }};

    private static final int[] denominators = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < denominators.length; i++) {
            int denominator = denominators[i];
            int count = num / denominator;
            for (int j = 0; j < count; j++) {
                String roman = intToRoman.get(denominator);
                stringBuilder.append(roman);
            }

            num = num % denominator;
            if (num == 0) {
                break;
            }
        }

        return stringBuilder.toString();
    }
}
