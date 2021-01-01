class Scratch {
    public static void main(String[] args) {
        C c = new C();
        var rez = c.compareMatchingTypes(new Apple(1), new Apple(1));
        System.out.println(rez);

        // Generic method implementation will not allow me to mix incompatible/incomparable types
        // This will show a compile type error
        //var rez2 = c.<Apple>compareMatchingTypes(new Orange(1), new Apple(1));

        // But note, if I skip the generic notation then it's not a compile time error, but the runtime
        var rez3 = c.compareMatchingTypes(new Orange(1), new Apple(1));
    }
}

class C {

    // Method to compare any type of object passed
    public int compareObjects(Object a, Object b) {

        // Include custom type checking, not extensible or easily maintainable
        if (a instanceof Comparable && b instanceof Comparable) {
            return compareComparables((Comparable) a, (Comparable) b);
        }
        return -1;
    }

    // Method to compare any object implementing Comparable
    public int compareComparables(Comparable a, Comparable b) {
        // Include custom type checking, but does not work with subclasses
        if (a instanceof Apple)
            return ((Apple) a).compareTo((Apple) b);
        else if (a instanceof Orange)
            return ((Orange) a).compareTo((Orange) b);
        else
            return -1;
    }

    // Method type parameters used in arguments enforce objects passed are
    // the same (or subclasses of) the same type and implement Comparable
    public <T extends Comparable> int compareMatchingTypes(T a, T b) {
        return a.compareTo(b);
    }
}

// Apple class, equal if val is same int
class Apple implements Comparable<Apple> {
    private int val;

    Apple(int val) {
        this.val = val;
    }

    public int compareTo(Apple o) {
        return o.val - this.val;
    }
}

// Orange class, equal if val is same int
class Orange implements Comparable<Orange> {
    private int val;

    Orange(int val) {
        this.val = val;
    }

    public int compareTo(Orange o) {
        return o.val - this.val;
    }
}