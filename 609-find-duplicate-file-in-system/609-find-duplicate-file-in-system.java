class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans=new ArrayList<>();
        Map<String,List<String>> h = new HashMap<>();
        for(String s:paths){
            String dir="";
            int i=0;
            for(;i<s.length();i++){ //take out directory from input list
                if(s.charAt(i)==' '){
                    dir=s.substring(0,i);
                    break;
                }
            }
            i++;
            while(i<s.length()){ // take out n files from input list
                String path="", content="";
                int j=i;
                for(;j<s.length();j++){// take out file name, add dir name and make full path
                    if(s.charAt(j)=='('){
                        path=dir+"/"+s.substring(i,j);
                        break;
                    }
                }
                i=j+1;
                for(;j<s.length();j++){ // take out content
                    if(s.charAt(j)==')'){
                        content=s.substring(i,j);
                        break;
                    }
                }
                i=j+2; // prepare index for next file name
                List<String> pathList=h.getOrDefault(content,new ArrayList<>());
                pathList.add(path);
                h.put(content,pathList); // add (content,path) in hashmap
            }
        }
        for(String s:h.keySet()){
            if((h.get(s).size())>1)
                ans.add(h.get(s)); // if content has more than 1 path in list, add it in ans
        }
        return ans;
    }
}