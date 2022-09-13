class Solution {
    public boolean validUtf8(int[] data) {
        int byteCount=0; //no of ones in the beginning of each num
        for(int i:data){
            String s=Integer.toBinaryString(i); //convert int to binary String
            
            //make this string of 8 bits
            s=s.length()>=8?s.substring(s.length()-8):("00000000"+s).substring(s.length());
            
            if(byteCount==0){ // beginning of an n-byte character
                
                for(int j=0;j<8;j++){ //calculate no of ones in the beginning
                    if(s.charAt(j)=='1')
                        byteCount++;
                    else
                        break;
                }
                
                //as valid value of byte count is 0,2,3 and 4 so we return false otherwise
                if(byteCount!=0 && (byteCount<2 || byteCount>4)) 
                    return false;
                
                //as we have to check for presense of "10xxxxxx" n-1 times
                if(byteCount!=0)
                    byteCount--;
            }
            else{//means it is not starting point of n-byte character, we check for "10xxxxxx"
                if(s.charAt(0)=='1' && s.charAt(1)=='0')
                    byteCount--;
                else
                    return false;
            }
        }
        
        //if byteCount is not 0, means it is expecting some more numbers, hence false, otherwise true
        return byteCount==0;
    }
}