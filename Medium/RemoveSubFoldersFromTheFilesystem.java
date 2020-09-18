package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveSubFoldersFromTheFilesystem {
    /**
     * 排序+startWith
     */
    public List<String> removeSubfolders2(String[] folder) {
        Arrays.sort(folder);
        Set<String> heads = new HashSet<>();
        boolean[] folderTag = new boolean[folder.length];
        Arrays.fill(folderTag, true);
        for (int j = 0; j < folder.length; j++) {
            String folderName = folder[j];
            for (int i = 1; i < folderName.length(); i++) {
                if (folderName.charAt(i) == '/' ) {
                    if (heads.contains(folderName.substring(0, i))) {
                        folderTag[j] = false;
                        break;
                    }
                }
                if(i == folderName.length() - 1){
                    heads.add(folderName);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if (folderTag[i])
                res.add(folder[i]);
        }
        return res;
    }

    /**
     * 传统哈希
     */
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Set<String> folderSet = Arrays.stream(folder).collect(Collectors.toSet());
        boolean[] resTag = new boolean[folder.length];
        Arrays.fill(resTag, true);
        for (int i = 0; i < folder.length; i++) {
            String f = folder[i];
            String[] folderName = f.split("/");
            String head = "";
            for (int j = 1; j < folderName.length - 1; j++) {
                head += '/' + folderName[j];
                if (folderSet.contains(head)) {
                    resTag[i] = false;
                    break;
                }
            }
        }
        for (int i = 0; i < folder.length; i++) {
            if (resTag[i])
                res.add(folder[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveSubFoldersFromTheFilesystem remove = new RemoveSubFoldersFromTheFilesystem();
        String[] folder = {"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(remove.removeSubfolders2(folder));
    }
}
