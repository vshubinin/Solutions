 //**
 //* Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 //**
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // фиктивная нода чтобы проще управлять указателями
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        // остаток при сложении, который переносится на следующий разряд
        int carry = 0;
        // пока есть что складывать крутим цикл
        while (l1 != null || l2 != null || carry != 0) {
            // получаем значения текущих нод, если они есть, иначе 0
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            // считаем сумму с учётом остатка 
            int sum = x + y + carry;
            // обновляем остаток: если сумма ≥ 10, он будет 1, иначе 0
            carry = sum / 10;
            // создаём новую ноду с остатком от деления на 10
            current.next = new ListNode(sum % 10);
            // перемещаем указатель на следующую ноду
            current = current.next;
            // переходим к следующему элементу в l1 и l2, если они не null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
         // возвращаем следующий элемент от фиктивной ноды — это и будет начало результата
        return dummy.next;
    }
    
}
