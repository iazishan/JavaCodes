import java.util.*;


public class Music {



    int size=10;
    int[] music =new    int[size];
    int count=0;    //3
    

    void growArray() {

        
        int[] newMusic = new int[music.length*2];
        for (int i = 0; i < count; i++) {
            newMusic[i] = music[i];
        }
        music = newMusic;            //8,3,4,5
                                    
    }

    void insert(int n){

        if(count>=music.length){
            growArray();
        }
       music[count]=n;
       count++;    

    
    }
    void insertStart(int n){

        if(count>=music.length){
            growArray();

        }   
        for(int i=count;i>0;i--){
            music[i]=music[i-1];
        }
        music[0]=n;
        count++;


    }
    void Display(){



        for(int i=0;i<count;i++){

            System.out.println(music[i]+"  ");
        }

    }




    void insertAtPos(int pos,int n){           ///      0,1,2,3,4,5,6,7,8,9
                                               /// count:   10  
                                               /// pos    3
                                               /// 10>3
                                               /// 9

        if(count>=music.length){
            growArray();
        }

        for(int i=count;i>pos;i--){
            music[i]=music[i-1];
        }
        music[pos]=n;
        count++;


    }
                                          //// 3 4 5 6 7 
                                          /// 6

   void search(int n){                    ////                 0<5

        for(int i=0;i<count;i++){
            if(music[i]==n){
                System.out.println("Found at index: "+i);
                return;
            }
        }
        System.out.println("Not Found");

    }
   

    void delete(){                                       //1,2,3,4,5,6,7,8
                                                        // count: 9

        if(count==0){
            System.out.println("Array is empty");
        } 
            count--;
        }


        void BackShift(int pos){                       // 0,1,2,3,4,5,6,7,8
                                                        // count: 9
            for(int i=pos;i<count-1;i++){
                music[i]=music[i+1];
            }
        }
     
        void deleteAtPos(int pos){ 



            if(count==0){
                System.out.println("Array is empty");
            }else{
                BackShift(pos);
                count--;
            }
         
        }





    
    
   























    
    public static void main(String[] args) {
        Music m = new Music();
        m.insert(1);
        m.insert(2);
        m.insert(3);
       
       m.insertStart(4);
       m.Display();
    }

}
