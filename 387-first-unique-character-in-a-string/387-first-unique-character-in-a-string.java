class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
        //HashMap
        /*HashMap<Character, Integer> h = new HashMap<Character,Integer>();
        for(char c : s.toCharArray()){
            if(h.containsKey(c))
                h.put(c,h.get(c)+1);
            else
                h.put(c,1);
        }
        for(int i=0;i<s.length();i++){
            if(h.get(s.charAt(i))==1)
                return i;
        }
        return -1;*/
    }
}