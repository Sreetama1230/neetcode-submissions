class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0] > target){
                continue;
            }
            if(target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]  ){

                int i1 = 0;
                int j1 = matrix[i].length - 1;

                while(i1 <= j1){

                    int mid = (i1 + j1) / 2;
                    if(matrix[i][mid] == target){
                        return true;
                    }else{
                        if(matrix[i][mid] > target){
                            j1 = mid - 1;
                        }else{
                            i1 = mid + 1;
                        }
                    }
                }

            }
        }

        return false;

    }
}
