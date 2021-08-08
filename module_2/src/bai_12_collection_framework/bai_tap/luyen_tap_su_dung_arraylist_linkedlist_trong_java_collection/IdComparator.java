package bai_12_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection;

import java.util.Comparator;

public class IdComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getIdProduct().compareTo(o2.getIdProduct());
    }
}
