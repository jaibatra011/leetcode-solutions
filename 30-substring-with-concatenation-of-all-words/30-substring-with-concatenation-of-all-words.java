class Solution {
    public boolean checkConcatenation(String s, String[] words){
        Map<String,Integer> h = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(h.containsKey(words[i]))
                h.put(words[i], h.get(words[i])+1);
            else
                h.put(words[i],1);
        }
        for(int i=0;i<=s.length()-words[0].length();i+=words[0].length()){
            String word=s.substring(i,i+words[0].length());
            if(!h.containsKey(word) || h.get(word)==0)
                return false;
            else
                h.put(word,h.get(word)-1);
        }
        for(String word:h.keySet()){
            if(h.get(word)!=0)
                return false;
        }
        return true;
    }
    public boolean checkFirstLetter(Character c, Map<Character,Integer> h){
        return h.containsKey(c)?true:false;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans=new ArrayList<>();
        Map<Character,Integer> h1 = new HashMap<>();
        for(int i=0;i<words.length;i++){
            h1.put(words[i].charAt(0),1);
        }
        for(int i=0;i<=s.length()-(words.length*words[0].length());i++){
            String r=s.substring(i,i+(words.length*words[0].length()));
            if(checkFirstLetter(r.charAt(0),h1) &&
                checkConcatenation(r,words)){
                ans.add(i);
            }
        }
        return ans;
    }
}