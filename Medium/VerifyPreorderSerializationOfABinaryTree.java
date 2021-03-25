package Medium;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int legalNum = 0;
        for (int i = 0; i < nodes.length; i++) {
            String node = nodes[i];
            if (i == 0) {
                if (node.equals("#"))
                    return nodes.length == 1;
                legalNum += 2;
            } else {
                if (node.equals("#"))
                    legalNum--;
                else
                    legalNum++;
            }
            if (i == nodes.length - 1)
                break;
            if (legalNum <= 0)
                return false;
        }
        return legalNum == 0;
    }

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(new VerifyPreorderSerializationOfABinaryTree().isValidSerialization(preorder));
    }
}
