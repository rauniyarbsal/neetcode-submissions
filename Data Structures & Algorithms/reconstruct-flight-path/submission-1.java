class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        // Build adjacency map
        Map<String, List<String>> adjMap = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < tickets.size(); i++) {
            String src = tickets.get(i).get(0);
            String dest = tickets.get(i).get(1);

            adjMap.computeIfAbsent(src, k -> new ArrayList<>())
                  .add(dest);
        }

        // Lexicographical order
        for (List<String> destinations : adjMap.values()) {
            Collections.sort(destinations);
        }

        // DFS always starts from JFK
        helperDFS("JFK", adjMap, ans);

        // DFS generated itinerary backwards
        Collections.reverse(ans);

        return ans;
    }


    public void helperDFS(String currAirport, Map<String, List<String>> adjMap,
List<String> ans) {

        // Consume every outgoing ticket
        while (adjMap.containsKey(currAirport)
                && !adjMap.get(currAirport).isEmpty()) {

            // Smallest lexical destination
            String nextAirport = adjMap.get(currAirport).remove(0);

            // Explore that airport
            helperDFS(nextAirport, adjMap, ans);
        }

        // Add airport AFTER all its outgoing tickets are used
        ans.add(currAirport);
    }
}
