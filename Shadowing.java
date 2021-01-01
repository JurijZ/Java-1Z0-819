class Scratch {
    public static void main(String[] args) {
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        System.out.println(innerClass.getVariables());
        System.out.println(staticInnerClass.getVariables());
    }
}

class OuterClass {

    String a = "A";

    class InnerClass{
        String a = "B";

        public String getVariables(){
            String a = "C";

            // Shadowing example
            return a + " - " + this.a + " - " + OuterClass.this.a;
        }
    }

    static class StaticInnerClass{
        String a = "B";

        public String getVariables(){
            String a = "C";

            // Shadowing example
            return a + " - " + this.a + " - " + new OuterClass().a;
        }
    }
}