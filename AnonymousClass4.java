class Scratch {
    public static void main(String[] args) {
        var c = new OuterClass();

        // Here we supply an anonymous implementation of the ISummable interface directly into the method call
        int a = c.NormalMethod(new ISummable() {
            @Override
            public int SumIntegers(int[] array) {
                int sum = 0;
                for( int num : array) {
                    sum = sum + num;
                }
                return sum;
            }
        }, new int[]{1, 3, 6, 5});
        System.out.println(a);
    }
}

interface ISummable{
    int SumIntegers(int[] array);
}

class OuterClass {
    public int NormalMethod(ISummable summable, int[] array){
        return summable.SumIntegers(array);
    }
}