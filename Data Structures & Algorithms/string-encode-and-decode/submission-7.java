class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String st: strs){
            sb.append(Integer.toString(st.length())).append("#").append(st);

        }

        System.out.println(sb.toString());

        return sb.toString();

    }

    public List<String> decode(String str) {
        int digit = 0;
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){

            while(str.charAt(i) != '#'){
                digit = digit * 10 + (str.charAt(i) - '0');

                i++;
            }
            
            ans.add(str.substring(i+1, i + 1 + digit));
            i = i + digit;
            digit = 0;

        }

        return ans;
    }   
}
