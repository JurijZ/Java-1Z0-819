class Scratch {
    public static void main(String[] args) {
        System.out.println(WEEKDAYS.Monday);
        System.out.println(WEEKDAYS.Monday.ordinal());

        System.out.println(WEEKDAYS2.Monday.description);
        System.out.println(WEEKDAYS2.Tuesday.GetEnumInfo());
    }

    enum WEEKDAYS{
        Monday,
        Tuesday
    }

    // Enums is in fact a class and can have all the class members
    // Enum can be as complicated as any class
    enum WEEKDAYS2{
        Monday("nice mondays"),
        Tuesday("nice tuesday");

        String description;

        //Enum Constructor
        WEEKDAYS2(String description){
            this.description = description;
        }

        public String GetEnumInfo(){
            // The java.lang.Enum.ordinal() method returns the ordinal of this enumeration constant (its position in its enum declaration)
            // where the initial constant is assigned an ordinal of zero.
            return this.name() + " " + this.ordinal();
        }
    }
}