class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String,Integer> h=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String morseCode="";
            for(Character c:words[i].toCharArray()){
                morseCode+=morse[c-'a'];
            }
            h.put(morseCode,1);
        }
        return h.size();
    }
}