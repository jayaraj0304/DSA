class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length - 1;

        while (index >= 0 && carry > 0) {
            int sum = digits[index] + carry;
            digits[index] = sum % 10;
            carry = sum / 10;
            index--;
        }

        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }

        return digits;
    }
}