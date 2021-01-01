class Scratch {
    public static void main(String[] args) {
        var c = new OuterClass();

        System.out.println(c.getX());
    }
}

class OuterClass {

    int a = 5;

    public int getX(){
        class localClass{

            int x;
            private localClass(int i){
                x = i;
            }

            public int getX(){
                return x + a;
            }
        }

        var c = new localClass(10);
        return c.getX();
    }
}