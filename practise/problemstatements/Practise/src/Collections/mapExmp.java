package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class mapExmp {
    public static void main(String[] args) {
//        Map<Integer,String> map=new HashMap<>();
//        map.put(1,"Santhosh");
//        map.put(2,"Pranith");
//        map.put(3, "Kodi");
//        map.put(4,"Loki");
//
//        for(int key:map.keySet()){
//            System.out.println(key+" "+map.get(key));
//        }

        Map<Character,Integer> m1=new TreeMap<>();
        String res="Santhosh chekuri";
        for(int i=0;i<res.length();i++){
            char c= res.charAt(i);
            c=Character.toLowerCase(c);
            if(c==' ') continue;
            if(m1.containsKey(c)){
                int count=m1.get(c)+1;
                m1.put(c,count);
            }else{
                m1.put(c,1);
            }
        }

        for(Character key: m1.keySet()){
            System.out.println(key+" -> "+ m1.get(key));
        }
    }
}
