import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class O{
    private Optional<Float> P1 = Optional.empty(); // Best practice for optional variable never be null
    public String P2;

    O(String p2){
        P2 = p2;
    }

    // getter
    public Optional<Float> getP1(){
        return P1;
    }

    //setter
    public void setP1(Float v){
        this.P1 = Optional.ofNullable(v); // This will not throw a null exception if v is null
    }

    public static void main(String[] args) {
        var o = new O("test");
        o.setP1(null);

        var p2 = o.getP1();
        if (!o.getP1().isPresent()){
            System.out.print("P1 value: " + o.getP1());
            //System.out.print("\nP1 value: " + o.getP1().get()); //NoSuchElementException: No value present
        }

        o.setP1(5.1f);
        if (o.getP1().isPresent()){
            System.out.print("\nP1 value: " + o.getP1());
            System.out.print("\nP1 value: " + o.getP1().get());
        }

        // We can use stream methods to do it more elegant
        Stream.of(o).filter(s -> s.getP1().isPresent())
                .forEach(s -> System.out.println("\nP1 value: " + s.getP1().get()));
    }
}
