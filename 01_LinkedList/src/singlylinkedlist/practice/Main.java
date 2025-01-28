package singlylinkedlist.practice;


class EmployeeNode{
    int id;
    String name;
    String department;
    double salary;
    EmployeeNode next;

    EmployeeNode head;

    public EmployeeNode(int id , String name , String department , double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.next = null;

    }
    void print(){
        EmployeeNode curr = head;
        while(curr != null){
            System.out.print(curr.id + " ");
            System.out.print(curr.name + " ");
            System.out.print(curr.department + " ");
            System.out.print(curr.salary + " ");
            curr = curr.next;
            System.out.println();
        }
    }
    void addEnd (int id , String name , String department , double salary){
        EmployeeNode node = new EmployeeNode(id , name , department , salary);
        if(head == null){
            head = node;
            return;
        }
        EmployeeNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }
    void addbegin (int id , String name , String department , double salary){
        EmployeeNode node = new EmployeeNode(id , name , department , salary);
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    void delete(int id ){
        if(head.id == id) {
            head = head.next;
            return;
        }
        EmployeeNode curr = head;

        while(curr.next.id != id){
            curr = curr.next;
        }
        if(curr.next.next == null){
            curr.next = null;
        } else{
            curr.next = curr.next.next;
        }


    }
    void update( int id , int newid){
        EmployeeNode curr = head;

        while(curr!=null){
           if(curr.id == id) {
               curr.id = newid;
               return;
           }
           curr=curr.next;
        }
    }


}

public class Main{
    public static void main(String[] args) {
        EmployeeNode node = new EmployeeNode(01,"Mousam","maths" , 234.900);
        node.addEnd(01,"Mousam","maths" , 234.900);
        node.addEnd(02,"goutam","maths" , 234.900);
        node.print();
        node.delete(02);
        node.print();
        node.addbegin(04,"goutam","maths" , 234.900);
        node.print();
        node.update(04,00);
        node.print();
    }
}



