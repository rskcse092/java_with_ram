package org.example;


class Student {
    char name ;
    int id ;

    public void  disp(int id, String name)
    {
        System.out.println("hi");
        System.out.println("id is : "+ id);
        System.out.println("name is :"+ name);

    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! , i am java");
        Student s = new Student();
        s.disp(1,"ram");

        //AUTO BOX
        int i  = Integer.valueOf(5);
        System.out.println("auto unbox var is:"+ i);

        //AUTO unBOX
        int j   =   i;
        System.out.println("auto unbox var is:"+ j);


        char b  = Character.valueOf('a');
        Character charobj = 'c';
        System.out.println("auto unbox var is:"+ b);
        System.out.println("auto unbox var is:"+ charobj);

        //AUTO unBOX
        char c    =   b;
        char d = charobj;
        System.out.println("auto unbox var is:"+ c);
        System.out.println("auto unbox var is:"+ d);


    }

}
