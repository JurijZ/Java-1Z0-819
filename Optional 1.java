import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class O{
    private Optional<Float> P1 = Optional.empty(); // Best practice for optional variable never be null

    // getter
    public Optional<Float> getP1(){
        return P1;
    }

    // setter
    public void setP1(Float v){
        this.P1 = Optional.ofNullable(v); // This will not throw a null exception if v is null
    }

    public static void main(String[] args) {
        // orXXX methods are executed when Optional is empty, otherwise they are simply skipped

        // or - method returns alternative Optional value if the original value is empty
        // or is not executed if the Optional is not empty
        var o1 = new O();
        var f = o1.getP1().or(()-> Optional.of(10f)); // must also be Optional
        System.out.println("\nAlternative value: " + f);

        // orElse
        var o2 = new O(); //P1 remains Optional.Empty
        var o3 = new O(); o3.setP1(20.0f);
        List.of(o2, o3).stream().forEach(s -> {
            var t = s.getP1().orElse(1.0f);
            System.out.println("orElse: " + t);
        });

        // orElse also can accept a function and NOTE - this function will always be executed even if the
        // result of this function is not used
        List.of(o2, o3).stream().forEach(s -> {
            var t = s.getP1().orElse(O.getFloat());
            System.out.println("orElse with function: " + t);
        });

        // orElseGet uses Supplier functional interface (signature - T get(), note there is no input argument)
        List.of(o2, o3).stream().forEach(s -> {
            var t = s.getP1().orElseGet(() -> 30.0f);
            System.out.println("orElseGet: " + t);
        });
    }

    private static float getFloat(){
        System.out.println("Executing getFloat()");
        return 40.0f;
    }
}
