package com.example.cote;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest(classes = CoteApplication.class)
class CoteApplicationTests {

    int[] taret = new int[]{1,2,3};
    boolean[] visited = new boolean[taret.length];
    int[] result = null;

    @Test
    void contextLoads() {


        Integer[] arr = new Integer[]{1, 26, 17, 25, 99, 44, 303};

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println("Sorted arr[] : " + Arrays.toString(arr));

//        int n = 23;
//        String n_ = String.valueOf(n);
//        System.out.println(n_);
//
//        for(int i=0;i<n_.length();i++) {
//            int num = n_.charAt(i)-'0';
//            System.out.println(num);
//        }
//
//        int pick = 2;
//        result = new int[pick];

        //조합
        // 순서에 상관 없음 예) 123과 321은 동일 취급
        //comb(0, 0, pick);

        //순열
        // 순서에 상관 있음 예) 123과 321은 다르게 취급
        //permutation(0, 2);

    }

    void comb(int cnt, int idx, int pick) {
        if(cnt == pick) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i=idx;i<taret.length;i++) {

            result[cnt] = taret[i];
            comb(cnt+1, i+1, pick);
        }
    }

    void permutation(int cnt, int pick) {
        if(cnt == pick) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i=0;i<taret.length;i++) {
            if(visited[i] == true) {
                continue;
            }
            visited[i] = true;
            result[cnt] = taret[i];
            permutation(cnt+1, pick);
            visited[i] = false;

        }
    }

}
