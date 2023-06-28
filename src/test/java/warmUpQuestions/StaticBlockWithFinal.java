//package warmUpQuestions;
//
//public class StaticBlockWithFinal {
//
//    public static void main(String[] args) {
//        //eger final yaparsak value hic bir sekilde degismeyecegi icin sadece var ekrana yansir
//        //ama final yapmazsak once before loadig the class static block calisir sonra var ekrana yansir
//        System.out.println(Main.x);
//        System.out.println(Main2.x);
//    }
//
//    class Main {
//        public static final int x = 100;
//
//        static {
//            System.out.print("::main class static");
//        }
//    }
//
//    class Main2 {
//        public static int x = 200;
//
//        static {
//            System.out.print("main class static::");
//        }
//    }
//}
