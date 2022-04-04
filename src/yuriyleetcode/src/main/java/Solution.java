public class Solution {



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


}
