class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String st: strs){
            int len = st.length();
            sb.append(Integer.toString(len)).append("#").append(st);

        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        int idx = 0, digit = 0;

        while(idx < str.length()){
            char ch = str.charAt(idx);
            
            if(ch == '#'){
                idx++;
                res.add(str.substring(idx, idx + digit));
                idx += digit;
                digit = 0;
                continue;

            }

            digit = digit * 10 + ch - '0';
            idx++;


        }

        return res;
    }
}
