class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        Boolean isPrefixCommon=true;
        int i=0;
        while(isPrefixCommon){
            Character c='\u0000'; //empty Character
            if(i<strs[0].length())
                c=strs[0].charAt(i);
            for(String s:strs){
                if(i>=s.length() || c!=s.charAt(i))
                    isPrefixCommon=false;
            }
            if(isPrefixCommon)
                ans+=c.toString();
            i++;
            
        }
        return ans;
    }
}