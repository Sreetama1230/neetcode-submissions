class Solution {
    public boolean validTree(int n, int[][] edges) {


        //adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];

        if(hasCycleWithDFS(visited , adj , -1  , 0 )){
               return false; 
        }
       
       for(boolean b : visited ){
        if(!b){
            return false;
        }
       }


        return true;
       
        
    }

    public static boolean hasCycleWithDFS(boolean[] visited , List<List<Integer>> adj , int prev , int curr ){
        visited[curr] = true;

        for(int node : adj.get(curr)){
            if(!visited[node]){
                if(hasCycleWithDFS(visited , adj , curr , node )){
                        return true;
                 }
            }else{
                // check whether the node is the source/parent node or not
                // think when we are not bother about the loop
                //if and only if the prev == curr , if the node is coming from the parent
                // 2-->3 , 3<---2
                //2->{3} 3->{2}
                if(prev != node ){
                        return true;
                }

            }
           
        }

        return false;

    }

 

}
