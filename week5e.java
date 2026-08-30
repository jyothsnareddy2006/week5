class Solution {
public:
    int myAtoi(string s) {
        int i = 0, n = s.length();
        
        // 1. Skip leading whitespaces
        while (i < n && s[i] == ' ') {
            i++;
        }
        
        // 2. Check for optional sign
        int sign = 1;
        if (i < n && (s[i] == '+' || s[i] == '-')) {
            sign = (s[i] == '-') ? -1 : 1;
            i++;
        }
        
        // 3. Process digits & handle overflow
        long result = 0;
        while (i < n && isdigit(s[i])) {
            int digit = s[i] - '0';
            result = result * 10 + digit;
            
            // Check 32-bit signed integer limits
            if (sign * result <= INT_MIN) return INT_MIN;
            if (sign * result >= INT_MAX) return INT_MAX;
            
            i++;
        }
        
        return sign * result;
    }
};