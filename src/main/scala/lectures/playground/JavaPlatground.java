package lectures.playground;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class JavaPlatground {

        public static void main(String[] args){
            String s1 = "foo";
            String s2 = "foo";

            LinkedList<Integer> arr = new LinkedList<>();
//            singleton
            String s3 = new String("foo");
            System.out.println(s1 == s2);
            System.out.println(s1.equals(s2));
            System.out.println(s1 == s3);
            System.out.println(s1.equals(s3));

        }
    }

