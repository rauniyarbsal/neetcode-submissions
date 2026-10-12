class Solution {

    public String encode(List<String> strs) {
        // T.C = O(N) and S.C = O(N)
        StringBuilder sb = new StringBuilder();

        for(String st: strs){
            int a = st.length();

            sb.append(Integer.toString(a)).append("#").append(st);

        }

        System.out.println(sb);

        return sb.toString();

    }

    public List<String> decode(String str) {
        // T.C = O(N) and S.C = O(N)
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while(idx < str.length()){
            int digit = 0;

            while(str.charAt(idx) != '#'){
                digit = digit * 10 + str.charAt(idx) - '0';
                idx++;

            }

            idx++;

            ans.add(str.substring(idx, idx + digit));
           // System.out.println(ans);

            idx += digit;


        }

        return ans;


    }
}
