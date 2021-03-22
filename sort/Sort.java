package sort;

public class Sort {
    protected void swap(int[] attrs, int l, int r) {
        int tmp = attrs[l];
        attrs[l] = attrs[r];
        attrs[r] = tmp;
    }

    public int[] sort(int[] attrs){return attrs;}
}
