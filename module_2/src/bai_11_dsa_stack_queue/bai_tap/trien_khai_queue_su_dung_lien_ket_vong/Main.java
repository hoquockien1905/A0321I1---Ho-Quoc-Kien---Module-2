package bai_11_dsa_stack_queue.bai_tap.trien_khai_queue_su_dung_lien_ket_vong;

public class Main {
    public static void main(String[] args) {
        Solution queue = new Solution();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
    }
}
