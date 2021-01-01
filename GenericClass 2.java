import java.util.List;

class Scratch {
    public static void main(String[] args) {
        
    }
}

class CombinedClass<T extends Comparable, U> {

    // Create some instance variables
    U instanceField;
    Number instanceNumberField;

    // Constructor is a generic method.
    // In this case the method's parameter type is upper bound to Number
    <V extends Number> CombinedClass(U instanceField, V instanceNumber) {
        this.instanceField = instanceField;
        this.instanceNumberField = instanceNumber;
        System.out.println("CombinedClass: instanceField (" +
                instanceField.getClass().getName() + ") : " + instanceField);
        System.out.println("CombinedClass: instanceNumber (" +
                instanceNumber.getClass().getName() + ") : " + instanceNumber);
    }

    // generic method declares two type parameters:
    //  -- X has no restriction but it's type is the return type of this method
    //  -- W is a List made up of X elements.
    // The method has three arguments:
    //  -- t and s which are of type T (class type parameter)
    //  -- definitions argument is a List defined by the W method type parameter.
    public <X, W extends List<X>> X getComparisonResult(T t, T s, W definitions) {
        int result = s.compareTo(t);
        if (result != 0) result = result < 0 ? -1 : 1;
        result++;

        return definitions.get(result);
    }
}