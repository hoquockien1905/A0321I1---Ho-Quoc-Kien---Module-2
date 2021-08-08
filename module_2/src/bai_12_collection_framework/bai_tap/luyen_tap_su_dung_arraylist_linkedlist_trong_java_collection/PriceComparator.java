package bai_12_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPriceProduct() > o2.getPriceProduct()) {
            return 1;
        } else if (o1.getPriceProduct() < o2.getPriceProduct()) {
            return -1;
        } else {
            return 0;
        }
    }
}
