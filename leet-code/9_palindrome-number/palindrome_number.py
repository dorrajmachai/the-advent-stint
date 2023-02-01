class Solution:
    def isPalindrome(self, x: int) -> bool:
        n = x # create a copy of x so we can work with it
        check = 0 # check is the variable we'll compare to x at the end
        last_digit = 0 # do we need this?

        # test case: x = 121
        while n > 0:                          # 121 > 0;                     12 > 0;                   1 > 0;
            check = check * 10                # check = 0 * 10 == 0;         check = 1 * 10 == 10;     check = 12 * 10 == 120;
            last_digit = n % 10               # 121 % 10 == 1;               12 % 10 == 2;             1 % 10 == 1;
            n = (n - last_digit) / 10         # n = (121 - 1) / 10 == 12;    n = (12 - 2) / 10 == 1;   n = (1 - 1) / 10 == 0; 

            check = int( check + last_digit ) # 0 + 1 = 1;                   10 + 2 = 12;              120 + 1 = 121

        return check == x

s = Solution()
s.isPalindrome(121)
