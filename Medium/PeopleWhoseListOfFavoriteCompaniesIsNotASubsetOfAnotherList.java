package Medium;

import java.util.*;

public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> favorites = new ArrayList<>();
        for (List<String> favoriteCompany : favoriteCompanies) favorites.add(new HashSet<>(favoriteCompany));

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favorites.size(); i++) {
            boolean dominate = false;
            Set<String> flst = favorites.get(i);
            for (int j = 0; j < favorites.size(); j++) {
                if (j == i)
                    continue;
                if (favorites.get(j).containsAll(flst)) {
                    dominate = true;
                    break;
                }
            }
            if (!dominate)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList list = new PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList();
        List<String> l1 = new ArrayList<>(Arrays.asList("leetcode", "google", "facebook"));
        List<String> l2 = new ArrayList<>(Arrays.asList("google", "microsoft"));
        List<String> l3 = new ArrayList<>(Arrays.asList("google", "facebook"));
        List<String> l4 = new ArrayList<>(Arrays.asList("google"));
        List<String> l5 = new ArrayList<>(Arrays.asList("amazon"));
        System.out.println(list.peopleIndexes(new ArrayList<>(Arrays.asList(l1, l2, l3, l4, l5))));
        ;
    }
}
