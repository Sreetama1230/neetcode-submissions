class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String str : strs){
            res+= str.length()+"&"+str;
        }
        return res;
    }

    public List<String> decode(String str) {
  
        List<String>  res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '&'){

                j++;
            }
          int len =   Integer.parseInt(str.substring( i , j));
          String temp = str.substring(j+1 , j+1+len);
          res.add(temp);
          i = j+1+len;
        }

        return res;
    }
}
