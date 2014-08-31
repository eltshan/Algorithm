
public class BinarySearchStuff {
    static public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(target < matrix[0][0] || target > matrix[m-1][n-1])
            return false;
        int lo = 0;
        int hi = m-1;
        int mid= 0;
        int row = 0;
        int col = -1;
        while(lo <= hi){
            mid = (hi+lo)/2;
            if(mid == 0)
            {
                row = mid;
                break;
            }
            else if(matrix[mid-1][0] <= target && matrix[mid][0] >= target)
            {
                row = mid;
                break;
            }
            if( matrix[mid-1][0] < target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        
        lo = 0;
        hi = n-1;
        
        while(lo <= hi){
            mid = (hi+lo)/2;

            if(matrix[row][mid] == target)
            {
                col = mid;
                return true;
            }
            if( matrix[row][mid] < target)
                lo = mid+1;
            else
                hi = mid-1;
        }

        return false;
    }
    
    public static void main(String args[]){
    	int[][] matrix = new int[1][2];
    	matrix[0][0] = 1;
    	matrix[0][1] = 3;
    	System.out.println(searchMatrix(matrix, 3));
    }
}
