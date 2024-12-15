package stramapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StreamApi {
//    public static List<Integer> getEvens(List<Integer> list){
//        List<Integer> evens = new ArrayList<Integer>();
//        list.forEach(a->{
//            if(a%2 == 0){
//                evens.add(a);
//            }
//        });
//        return evens;
//    }
//
//    public static List<Integer> getSquare(List<Integer>list){
//        List<Integer> squares = new ArrayList<Integer>();
//        list.forEach(a->{
//            squares.add(a*a);
//        });
//        return squares;
//    }
//
//    public static int getSum(List<Integer> list){
//        int []sum=new int[1];
//        list.forEach(a -> {
//            sum[0]+=a;
//        });
//        return sum[0];
//    }
    public static void main(String[] args) {
        List<String> list=List.of("Santhosh","Loki","Pranith","Kodi","Hemanth");
//        String ans="";

//        String res=list.stream().sorted(Comparator.reverseOrder()).filter(i->i.charAt(0)=='L' || i.charAt(0)=='H').collect(Collectors.joining(", ")).toString();
//        String ans=String.join(",",res);

        String res= list.stream().sorted().filter(i->i.charAt(0)=='L' || i.charAt(0)=='H').reduce((i, sum)->sum=sum+", "+i).orElse("None Found");


        System.out.println(res);
        System.out.println();
    }
}
