class Scratch {
    public static void main(String[] args) {
        var c = new OuterClass();
        System.out.println(c.NormalMethod());
    }
}

interface Doable{
    public int MyMethod();
}

class OuterClass {
    int a = 5;
    public int NormalMethod(){
        // Define anonymous class without assigning to a variable, instead just execute it inline
        return new Doable(){
            public int MyMethod(){ return a; }
        }.MyMethod(); // immediate call to execute the method
    }
}