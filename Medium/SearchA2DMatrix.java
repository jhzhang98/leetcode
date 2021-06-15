package Medium;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = 0;
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (matrix[mid][0] < target) {
                rowIndex = mid;
                left = mid + 1;
            } else if (matrix[mid][0] == target) return true;
            else right = mid - 1;
        }

        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (matrix[rowIndex][mid] == target) return true;
            else if (matrix[rowIndex][mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int target = 0;
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, target));
    }
}
