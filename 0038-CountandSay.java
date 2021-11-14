class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = count(result);
        }
        return result;
    }

    private String count(String string) {
        StringBuilder sb = new StringBuilder();
        char latestChar = string.charAt(0);
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (currentChar == latestChar) {
                count += 1;
            } else {
                sb.append(count);
                sb.append(latestChar);
                count = 1;
                latestChar = currentChar;
            }
        }
        sb.append(count);
        sb.append(latestChar);
        return sb.toString();
    }
}
