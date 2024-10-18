//TC : O(5^N) - where N is number of digits
//SC : O(N) - where N is number of digits
class ConfusingNumberII {
    int count;
    HashMap<Integer, Integer> map;
    public int confusingNumberII(int n) {
        this.count = 0;
        this.map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        dfs(0l, n);
        return count;
    }

    private void dfs(long currNum, int n) {
        // base
        if(currNum > n)
            return;
        //logic
        if(isConfusingNumber(currNum))count++;
        for(int digit : map.keySet()){
            long newNum = currNum*10+digit;
            if(newNum != 0){
                dfs(newNum, n);
            }
        }
    }

    private boolean isConfusingNumber(long currNum) {
        long result = 0l;
        long temp = currNum;
        while(temp > 0) {
            int digit = (int)(temp%10);
            result = result*10+map.get((digit));
            temp = temp/10;
        }
        return currNum != result;
    }
}