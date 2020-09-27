package Easy;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int curDepth = 0;
        for (String operation : logs) {
            switch (operation) {
                case "../":
                    curDepth -= curDepth == 0 ? 0 : 1;
                    break;
                case "./":
                    break;
                default:
                    curDepth += 1;
            }
        }
        return curDepth;
    }

    public static void main(String[] args) {
        CrawlerLogFolder folder = new CrawlerLogFolder();
        String[] logs = {};
        System.out.println(folder.minOperations(logs));
    }
}
