class Solution {
    public int countComponents(int n, int[][] edges) {

            int[] ranks = new int[n];
            int[] parent = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
            }
            int components = n; 
            for(int[] edge : edges ){
                if(union(edge[0] , edge[1] , parent , ranks )){
                      components--;  
                }
            }

            return components;


    }

    public static boolean union(int x , int y , int[] parent,int[] rank){
        
        int x_parent = find(x , parent);
        int y_parent = find(y , parent);


        if(x_parent == y_parent ){
            return false;
        }
        if(rank[x_parent] > rank[y_parent] ){
            // x will be the parent
            parent[y_parent] = x_parent;
           
        }else{
            if(rank[y_parent] > rank[x_parent]){
                parent[x_parent] = y_parent;
               
            }else{
                parent[x_parent] = y_parent;
                rank[y_parent]++;
                
            }
        }

        return true;
      

    }
    public static int find(int node , int[] parent ){
        if(node == parent[node]){
            return node;
        }

        parent[node] = find(parent[node] , parent);
        return parent[node];
    }
}
