class Solution {
    public int romanToInt(String s) {
        int[] arr = new int[26];
        arr['I'-'A'] = 1;
        arr['V'-'A'] = 5;
        arr['X'-'A'] = 10;
        arr['L'-'A'] = 50;
        arr['C'-'A'] = 100;
        arr['D'-'A'] = 500;
        arr['M'-'A'] = 1000;

        int result = 0;
        int current = arr[s.charAt(0)-'A'];

        for (int i=1;i<s.length(); i++) {
            int next = arr[s.charAt(i)-'A'];
            result += next > current ? -current : current;
            current=next;
        }
        result+=current;
        return result;
    }
}