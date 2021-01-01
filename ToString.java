class Scratch {
    public static void main(String[] args) {
        C c = new C();
        Object o = new Object();
        System.out.println(c);
    }
}

class C{
    int i;
    int x = 5;
    C(){
        i = 10;
    }
    public String toString(){
        return Integer.toString(i + x);
    }
}