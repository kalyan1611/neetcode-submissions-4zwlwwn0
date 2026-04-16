class Solution {

    public boolean isValidChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public boolean isPalindrome(String s) {

        int len = s.length();
        int left = 0;
        int right = len - 1;

        while (left < right) {

            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!isValidChar(leftChar)) {
                left++;
                continue;
            }
            if (!isValidChar(rightChar)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            
            left++;
            right--;
        }

        return true;
    }
}
