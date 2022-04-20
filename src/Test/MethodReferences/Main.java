package Test.MethodReferences;

interface Parser{
    String parse(String str);
}

class StringParser{
    static String convert(String s){
        if(s.length()<=3){
            s = s.toUpperCase();
        }else{
            s = s.toLowerCase();
        }
        return s;
    }
}

class MyPrinter{
    public void print(String str, Parser p){
        str = p.parse(str);
        System.out.println(str);
    }
}

public class Main {
    public static void main(String[] args) {
        String name = "Sidharth";
        MyPrinter mp = new MyPrinter();
//        mp.print(name, new Parser() {
//            @Override
//            public String parse(String str) {
//                return StringParser.convert(str);
//            }
//        });

        mp.print(name, StringParser::convert); // passing method reference because StringParser.convert is compatible with Parser.parse method

        Parser p = StringParser::convert; // method reference
        mp.print(name, p);

        mp.print(name, (str)->str.length()<=3?str.toUpperCase():str.toLowerCase());

        Parser p2 = (str) -> str.length()<=3?str.toUpperCase():str.toLowerCase(); // lambda expression
        mp.print(name, p2); // passing lambda expression p
    }
}
