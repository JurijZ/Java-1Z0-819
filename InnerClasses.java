class Scratch {
    public static void main(String[] args) {
        OuterClass.StaticInnerClass staticClass = new OuterClass.StaticInnerClass();
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();

        System.out.println(staticClass.getA()); // This will print "A"
        System.out.println(inner.getA()); // This will print "A"
        System.out.println(inner.getAanotherWay()); // This will print "A"
    }
}

class OuterClass {

    String a = "A";

    class InnerClass{
        int x;
        public String getA(){
            return a; // non-static inner calls can access a variable from the outer class directly
        }
        public String getAanotherWay(){
            return OuterClass.this.a; // non-static inner calls can access a variable from the outer class directly
        }
    }

    public static class StaticInnerClass{
        int x;
        public String getA(){
            return new OuterClass().a; // static inner class needs an instance of the outer calss to access it's variable
        }
    }
}