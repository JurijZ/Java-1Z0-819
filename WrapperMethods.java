class WrapperMethods {

    public static void main(String[] args) {

        // ---- Autoboxing instantiations of Wrappers ----
        Boolean bWrapper = true;
        Character cWrapper = 'a';

        // Note that autoboxing and type conversion can occur
        Short sWrapper = 10;
        Integer iWrapper = 0b00100001;  // binary representation of 33

        Integer iWrapper2 = 0xABC;
        Double dWrapper = 20.0D;
        Float fWrapper = 2.0e2f;
        Character cWrapper2 = '\u0041';

        printWrappers("Autoboxed Assignments", bWrapper, cWrapper,
                sWrapper, iWrapper, dWrapper, fWrapper,
                iWrapper2, cWrapper2);

        // ---- Using valueOf methods to create instances ----
        // valueOf methods can accept a String or primitive

        printWrappers("Boolean.valueOf Instances",
                Boolean.valueOf(true),
                Boolean.valueOf("FALSE"),
                Boolean.valueOf(null));

        // Character does NOT support a valueOf with a String parameter.
        printWrappers("Character.valueOf Instances",
                Character.valueOf('a'),
                Character.valueOf('\u0041'));

        printWrappers("Integer valueOf Instances",
                Integer.valueOf(100),
                Integer.valueOf('a'),
                Integer.valueOf("100")
        );

        printWrappers("Float valueOf Instances",
                Float.valueOf(10),
                Float.valueOf('a'),
                Float.valueOf(12.5f),
                Float.valueOf("100.0"),
                Float.valueOf("15.0F"),
                Float.valueOf("250.0D")
        );

        testExceptions();

        printWrappers("Integer.valueOf with Radix",
                Integer.valueOf("100", 2),
                Integer.valueOf("100", 8),
                Integer.valueOf("100", 16)
        );

    }

    // Method to help print output consistently,  Note that wrappers can be
    // passed generically to a method as Objects.  The 8 wrappers only have
    // Object in common.
    public static void printWrappers(String title, Object... wrappers) {
        System.out.println("------------" + title + " -----------------");
        for (Object o : wrappers) {
            System.out.println(o.getClass().getSimpleName() + " : " + o);
        }
    }

    // This method isolates the exceptions for valueOf
    public static void testExceptions() {

        // Use a local class that allows us to test many samples.
        class WrapIt {
            String type;
            String value;

            WrapIt(String type, String value) {
                this.type = type;
                this.value = value;
            }

            // Tests restricted to Float and Integer
            public Object getWrapper() {
                switch (type) {
                    case "Float":
                        return Float.valueOf(value);
                    case "Integer":
                        return Integer.valueOf(value);
                }
                return null;
            }
            public String toString() {
                return type+".valueOf("+value+")";
            }
        }

        // The test scenarios
        WrapIt[] tests = {
                new WrapIt("Float", null),
                new WrapIt("Integer", "10.0"),
                new WrapIt("Integer", "10f"),
                new WrapIt("Integer", "100_000"),
                new WrapIt("Integer", "0b00100001"),
                new WrapIt("Integer", "0xABC")

        };

        // Loop through test scenarios
        for (WrapIt w : tests ) {
            try {
                w.getWrapper();
                System.out.println(w+"  worked");
            } catch (Exception e) {
                System.out.println(w+" " +e);
            }
        }
    }
}