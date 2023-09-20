public class oops_1 {
    public static void main(String[] args) {
        //this not work in static function&varables
        student s1=new student("rishab");//s1 is reference to the object
        s1.get_roll(2110991157);
        s1.print();
        student s2=new student("vishal",1209911882);
        s2.print();
        System.out.println(student.get_num_student());   
    }
    

}
class student{
    //access modifiers
        //static  shared by all objects and it belongs to class not object
        //final   value is assingned only once(at constructer,at declaration)
        //private within class
        //default within class,inside pakage
        //public  within class,inside pakage,outside pakage
    String name;
    private int roll;
    double CGPA;
    final static double conversion_factor=0.95;
    private static int num_students;
    student(String name){
        //constructor1
        this.name=name;
        num_students++;
    }   
    student(String name,int roll){
        //constructor2
        this.name=name;
        this.roll=roll;
        num_students++;
    } 



    public void get_roll(int roll){
        if(roll<=0)return;
        this.roll=roll;
    }
    //function using static variable is also static 
    //use static properties in satatic func(not non_static properties in satatic func)
    public static int get_num_student(){
        return num_students;
    }
    public void print(){
        System.out.println("name : "+name+" roll_no : "+roll);
    }
}