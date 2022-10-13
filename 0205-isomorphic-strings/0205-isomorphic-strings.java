class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Character> h = new HashMap<>();
        for(int i=0;i<s.length();i++){
            //checking if same key value pair is present
            if((h.containsKey(s.charAt(i)) && h.get(s.charAt(i))!=t.charAt(i)))
                return false;
            
            //if first condition in else if is true, that means some char is already mapped to this, hence checking if this mapped to same character or not
            //if key isn't there or key has some other value, means it is mapped to different char
            else if(h.containsValue(t.charAt(i)) && 
                (!h.containsKey(s.charAt(i)) || h.get(s.charAt(i))!=t.charAt(i)))
               return false;
            
            else{
                h.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}