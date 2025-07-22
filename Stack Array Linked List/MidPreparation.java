


class MidPreparation{

    int [] array = new int[10];

    int count = 0;

void insertion(int value){


    if(count>=array.length){
        System.out.println("Array is full");
        return;
    }
    array[count] = value;   
    count++;

    
}


void display(){

    for(int i=0; i<count; i++){
        System.out.print(array[i] + " ");
    }
    System.out.println();
}
    void deletion(int value){

        int i;
        for(i=0; i<count; i++){
            if(array[i] == value){
                break;
            }
        }
        if(i == count){
            System.out.println("Element not found");
            return;
        }
        for(int j=i; j<count-1; j++){
            array[j] = array[j+1];
        }
        count--;
    }

    void insertAt(int index, int value){

        if(index<0 || index>count){
            System.out.println("Invalid index");
            return;
        }
        if(count>=array.length){
            System.out.println("Array is full");
            return;
        }
        for(int i=count; i>index; i--){
            array[i] = array[i-1];
        }
        array[index] = value;
        count++;
    }

    int search(int value){

        for(int i=0; i<count; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }

    void deleteAt(int index){

        if(index<0 || index>=count){
            System.out.println("Invalid index");
            return;
        }
        for(int i=index; i<count-1; i++){
            array[i] = array[i+1];
        }
        count--;
    }

    void growArray(){

        int [] newArray = new int[array.length*2];
        for(int i=0; i<array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }












public static void main(String[] args) {

    MidPreparation mp = new MidPreparation();
    while(true){
    System.out.println("Enter 1 for insertion, 2 for deletion, 3 for display, 4 for insert at index, 5 for search, 6 for delete at index, 7 for grow array, 8 to exit");
    mp.insertion(10);
    mp.insertion(20);
    mp.insertion(30);
    mp.insertion(40);
    mp.insertion(50);
    mp.display();
    System.out.println("Now Deletion");
    mp.deletion(30);
    mp.display();
    System.out.println("Now Deletion At Index");
    mp.insertAt(2, 25);
    mp.display();
    System.out.println("Now Searching");
    System.out.println(mp.search(20));
    System.out.println(mp.search(25));
    mp.deleteAt(2);
    mp.display();
}
    }



}




