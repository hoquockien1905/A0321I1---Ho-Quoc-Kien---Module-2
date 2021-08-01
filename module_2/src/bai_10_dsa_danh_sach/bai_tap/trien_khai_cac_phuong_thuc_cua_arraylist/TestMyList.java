package bai_10_dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_cua_arraylist;

public class TestMyList {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        list.add("2.1");
        list.add("2.4");
        list.add("5.3");
        System.out.println(list.size());
//        System.out.println(list.remove(0));
//        System.out.println(list.remove(0));
//        System.out.println(list.size());
//        System.out.println(list.remove(0));

//        list.add(5,"3.1");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println("Remove: " + list.remove(0));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println(list.size());
//        System.out.println("Remove: " + list.remove(0));
//        System.out.println(list.indexOf("5"));

        MyList<String> list1 = list.clone();
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }
}
