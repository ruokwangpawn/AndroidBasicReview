package com.pawn.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(6);
        BigDecimal divide = bigDecimal.divide(new BigDecimal(8),BigDecimal.ROUND_HALF_UP);
        int s = 21 / 8;
        System.out.println(Math.ceil(6.0/8.0));

        List<Long> list = new ArrayList<>();
        list.add(1545895093000L);
        list.add(0L);
        list.add(1545888993000L);
        list.add(2L);
        list.add(5L);
        list.add(4L);
        list.add(9L);
        list.add(0L);
        list.add(1L);
        list.add(2L);
        System.out.println(list);
        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long l1, Long l2) {
                return (int) (l2 - l1);
            }
        });
        System.out.println(list);

        String url = "<img id='img' src=\"http://121.43.71.128:8380/cdatas/2/2018/12/27/2b23de99-4abc-4e00-8036-d2a7bc358b8c.jpg\"/>";
        String replace = url.replace("<img id='img' src=\"", "").replace("\"/>", "");
        System.out.println(replace);
    }
}
