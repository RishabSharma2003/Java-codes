public class vehicleUse_1 {
    public static void main(String[] args) {
        //inheritence
            //subclasses also have parent property with their own property as well
            //firstly super class constructor is called after tha subclass constructor is called
            //protected within class,pakage friendly+also be in subclasses(of diff pakages)of derived class
            //protected is only linient to derived classes of subclass dosn't matter at what pakage they belong
            //super prints the function of super class when called in sub class
        vehicle v=new vehicle(50);
        v.setColor("red");
        //v.maxSpeed=50;
        v.print();

        car c=new car(4,50);
        c.setColor("blue");
        c.maxSpeed=100;
        //c.numDoors=4;
        c.printcar();
        c.printMaxSpeed();


        //POLYMORPHISM
        vehicle v1=new car(5,180);
        v1.maxSpeed=200;
        //cars print func is called
        //as v is pointing to car
        v1.print();
    }
}
 
class vehicle {
    private String color;
    int maxSpeed;
    vehicle(int maxSpeed){
        System.out.println("vehicle constructor");
        this.maxSpeed=maxSpeed;
    }

    
    public void setColor(String color){this.color=color;}
    public String getColor(){return color;}
    //no sub class cannot overide the print function of vehicle only vehicle func is used in subclasses
    public final void print(){
        System.out.println("vehicle color "+color+":maxspeed "+maxSpeed);
    }
}

//no body can inherit vehicle class
final class car extends vehicle{
    int numDoors;
    // two max speed variables 
        //1: vehicle class
        //2: car class
    int maxSpeed;
    //constructor of numDoors here
    car(int numDoors,int maxSpeed){
        //syntx if super class dosn't contain default constructor
        super(maxSpeed);
        //IMP point(super call to the constructor is to be first call to constructor(first call should made to parent))
        System.out.println("car constructor");
        this.numDoors=numDoors;
    }


    public void printcar(){
        super.print();
        System.out.println("numDoors "+numDoors);
    }
    public void printMaxSpeed(){
        super.maxSpeed=150;
        System.out.println("max speed of car "+maxSpeed+":max speed of vehicle "+super.maxSpeed);
    }
}