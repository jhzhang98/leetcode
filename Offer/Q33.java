package Offer;

public class Q33 {
    private boolean search(int[] postorder, int start, int end) {
        if (start >= end)
            return true;
        int root = postorder[end];
        int mid = start;
        while (postorder[mid] <= root) mid++;
        int chekRight = mid;
        while (postorder[chekRight] > root) chekRight++;
        if (chekRight != end)
            return false;
        return search(postorder, start, mid - 1) && search(postorder, mid, end - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        return search(postorder, 0, postorder.length - 1);
    }

    public static void main(String[] args) {
        int[] postorder= {1,6,3,2,5};
        System.out.println(new Q33().verifyPostorder(postorder));
    }
}
