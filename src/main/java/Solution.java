import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    long res =0;
    Map<Integer, Long> map;
    public int combinationSum4(int[] nums, int target) {

        map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        res = solve(nums, 0, list, target);

        return (int)res;
    }

    private long solve(int[] nums,  int i, List<Integer> list, int target) {
        if(i >= nums.length)
            return 0;

        /*int key = 1001 * i + target ;
        if(map.containsKey(key))
            return map.get(key);*/

        if(target == 0) {
            return findNumberOfComb(list);
        }


        if(target < 0)
            return 0;
        else {
            long sum = 0;
            for(int j=i; j<nums.length; j++) {
                list.add(nums[j]);
                sum += solve(nums, j, list, target-nums[j]);
                list.remove(list.size()-1);
            }
            //map.put(key, sum);
            return sum;
        }
    }

    private long findNumberOfComb(List<Integer> list) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxNum = 0;
        for (int num : list) {
            int f = map.getOrDefault(num, 0);
            map.put(num, f+1);
            if(f+1 > map.getOrDefault(maxNum, 0))
                maxNum = num;
        }
        long numerator = mul( map.get(maxNum)+1, list.size());
        map.remove(maxNum);
        long denominator = denominator(map);
        return (numerator/denominator);
    }

    private long denominator(Map<Integer, Integer> map) {
        long r = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            r *= mul(1, entry.getValue());
        }
        return r ;
    }

    private long mul(int i, Integer value) {
        long r = 1;
        while (i <= value) {
            r *= i;
            i++;
        }
        return r;
    }


}