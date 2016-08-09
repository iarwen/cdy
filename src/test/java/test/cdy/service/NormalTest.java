package test.cdy.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by wentao_chang on 2016/8/9.
 */
public class NormalTest {

    @Test
    public void lambdaTest() {
        List<String> list = new ArrayList<>();
        list.add("20");
        list.add("31");
        list.add("30");

        list.stream()
                .filter(s -> s.startsWith("3"))
                .forEach( System.out::println);

        System.out.println("-----------------------");
        for (String i : list) {
            System.out.println(i);
        }
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        list.forEach((val) -> System.out.println(val));
        list.forEach(System.out::println);

        list.sort(String::compareTo);


        Map<String,String> map = new HashMap<>();
        map.put("k10","v10");
        map.put("k1","v20");
        map.put("k30","v3");

        //BEFORE：
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String val) {
                System.out.println(key+"-"+val);
            }
        });

        map.forEach((key, val) -> System.out.println(key + "-" + val));
    }

}
