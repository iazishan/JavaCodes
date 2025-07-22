 


 class Node1{



    int age;
    String name;
    Node1 head;
    Node1 next;

    Node1(String name,int age0){
      this.name=name;
      this.age=age;
      this.next=null;
    }

void insertAtStart(String name,int age){
Node1 d=new Node1(name, age) ;
if(head==null){
    head=d;
}
else{
    d.next=head;
    head=d;
}
}






void insertAtEnd(String name,int age){


    Node1 d=new Node1(name, age);



    if(head==null){head=d;}
    else{
        
    }
}



 }