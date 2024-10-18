//TC : O(4^N)
//SC : O(N)
class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int match : matchsticks) {
            sum += match;
        }
        if (sum % 4 != 0)
            return false;
        int side = sum / 4;
        for (int match : matchsticks) {
            if (match > side)
                return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, 0, new int[4], side);
    }

    private boolean backtrack(int[] matchsticks, int idx, int[] square, int side) {
        // base
        if (idx == matchsticks.length) {
            if (square[0] == side && square[1] == side && square[2] == side)
                return true;
            else
                return false;
        }

        // logic
        for (int i = 0; i < 4; i++) {
            if (square[i] + matchsticks[idx] <= side) {
                // action
                square[i] += matchsticks[idx];

                // Recurse
                if (backtrack(matchsticks, idx + 1, square, side))
                    return true;

                // backtrack
                square[i] -= matchsticks[idx];
            }
        }
        return false;
    }

    private void reverse(int[] matchsticks) {
        int left = 0;
        int right = matchsticks.length - 1;
        while(left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }
    }
}