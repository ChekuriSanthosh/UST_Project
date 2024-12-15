package com.ust.practise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collectionsframeworks {

    public static void main(String[] args) {
        List res=new ArrayList();
        res.add(2);
        res.add("sam");
        res.add(4.77);
        res.add(true);

        res.remove(2);

        for(var item:res){
            System.out.println(item);
        }

    }
}
