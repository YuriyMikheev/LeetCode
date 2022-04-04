import java.util.*;

public class Solution {


    /**
     * Roman to Integer problem @see <a href="https://leetcode.com/problems/roman-to-integer/"> https://leetcode.com/problems/roman-to-integer </a>
     *
     * @param s
     * @return
     */

    public static int romanToInt(String s) {

        char[] roman = new char[]{'I','V','X','L','C','D','M'};
        int[] ints = new int[]{1,5,10,50,100,500,1000};
        int[] table = new int[255];

        for (int i = 0; i < roman.length; i++)
            table[(byte) roman[i]] = ints[i];

        int r = 0, d = 0, d1 = 0;

        byte[] ds = s.getBytes();

        for (int i = 0; i < ds.length; i++){
            d = table[ds[i]];
            d1 = 0;
            if (i != ds.length - 1) {
                if (d < (d1 = table[ds[i+1]])) {
                    d = -d;
                    i++;
                } else d1 = 0;
            }

            r = r + d + d1;
        }



        return r;
    }


    /**
     * 3sum problem @see <a href="https://leetcode.com/problems/3sum/"> https://leetcode.com/problems/3sum </a>
     *
     *
     * The solutions complexity is O(n^2) in case of all different input numbers and
     * in case of repeated numbers the complexity could be much lower O(n + unique(nums)^2)
     *
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums) {

        HashSet<Integer> hs;
        HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
        int j = 0;
        for (int i: nums) {
            if (g.containsKey(i)) hs = g.get(i);
            else g.put(i, hs = new HashSet<>());
            hs.add(j++);
        }
        LinkedList<Integer> integers = new LinkedList<>();

        for (Map.Entry<Integer, HashSet<Integer>> entry: g.entrySet()){
            for (int i = 0; i < Math.min(3, entry.getValue().size()); i++)
                integers.add(entry.getKey());
        }

        Integer[] numbs = integers.toArray(new Integer[0]);

        Arrays.sort(numbs);

        g.clear(); j = 0;

        for (int i: numbs) {
            if (g.containsKey(i)) hs = g.get(i);
            else g.put(i, hs = new HashSet<>());
            hs.add(j++);
        }


        HashMap<String, int[]> found = new HashMap<>();

        for (int i = 0; i < numbs.length; i++){
            for (int k = numbs.length - 1; k >= i; --k){
                int r = numbs[i] + numbs[k];
                int rn = 0;
                if (-r == numbs[i]) rn++;
                if (-r == numbs[k]) rn++;
                {

                    if (g.containsKey(-r))
                        if ((hs = g.get(-r)).size() > rn)

                        {
                            Iterator<Integer> iterator = hs.iterator();
                            int c = iterator.next();

                            while (iterator.hasNext() & c == i & c == k)
                                c = iterator.next();
                            if (c != i & c != k & i!=k) {
                                int[] r1 = new int[]{numbs[i], numbs[k], numbs[c]};
                                Arrays.sort(r1);
                                found.put(r1[0] + "," + r1[1] + "," + r1[2], r1);
                            }
                        }
                }
            }
        }

        List<List<Integer>> r = new LinkedList<>();
        for (int[] d: found.values()){
            List<Integer> r1 = new LinkedList<>();
            r1.add(d[0]); r1.add(d[1]); r1.add(d[2]);
            r.add(r1);
        }

        return r;


        /**
         *
         */

    }




}
