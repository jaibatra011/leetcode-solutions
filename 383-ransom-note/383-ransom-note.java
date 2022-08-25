class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[26];
        for(int i=0;i<magazine.length();i++){
            arr[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            if(arr[c-'a']<1)
                return false;
            else
                arr[c-'a']--;
        }
        return true;
    }
}