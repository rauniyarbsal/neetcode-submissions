class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for(String st: strs){
            String key = helper(st);


            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(st);
        }

        return new ArrayList<>(mp.values());
    }

    public static String helper(String word){
        int []freq = new int[26];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < word.length(); i++){
            freq[word.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            sb.append("#").append(freq[i]);
        }

        return sb.toString();
    }
}
