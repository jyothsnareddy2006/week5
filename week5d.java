#include <vector>
#include <numeric>
#include <algorithm>

class Solution {
public:
    int maxSubarraySumCircular(std::vector<int>& nums) {
        int total_sum = 0;
        int max_sum = nums[0], current_max = 0;
        int min_sum = nums[0], current_min = 0;

        for (int num : nums) {
            // Standard Kadane's for Maximum Subarray
            current_max = std::max(num, current_max + num);
            max_sum = std::max(max_sum, current_max);

            // Kadane's for Minimum Subarray
            current_min = std::min(num, current_min + num);
            min_sum = std::min(min_sum, current_min);

            total_sum += num;
        }

        // If all numbers are negative, max_sum is the largest negative element
        if (max_sum < 0) {
            return max_sum;
        }

        return std::max(max_sum, total_sum - min_sum);
    }
};