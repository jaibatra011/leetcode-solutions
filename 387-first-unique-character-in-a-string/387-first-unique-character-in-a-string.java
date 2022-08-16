class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> h = new HashMap<Character,Integer>();
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
        return -1;
    }
}