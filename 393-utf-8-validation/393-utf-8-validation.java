class Solution {
    public boolean validUtf8(int[] data) {
        int byteCount=0;
        for(int i:data){
            String s=Integer.toBinaryString(i);
            s=s.length()>=8?s.substring(s.length()-8):("00000000"+s).substring(s.length());
            System.out.println(s);
            if(byteCount==0){
                for(int j=0;j<8;j++){
                    if(s.charAt(j)=='1')
                        byteCount++;
                    else
                        break;
                }
                if(byteCount!=0 && (byteCount<2 || byteCount>4))
                    return false;
                if(byteCount!=0)
                    byteCount--;
            }
            else{
                if(s.charAt(0)=='1' && s.charAt(1)=='0')
                    byteCount--;
                else
                    return false;
            }
        }
        return byteCount==0;
    }
}