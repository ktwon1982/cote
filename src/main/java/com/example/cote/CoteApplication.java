package com.example.cote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//@SpringBootApplication
public class CoteApplication {


    public static void main(String[] args) {

        // 순열
        //permutation(0);

        //조합
        //combination(0, 0);

        permutation_(0);

    }

    // 선택하고자 하는 대상 집합.
    static int[] target = new int[] { 1, 2, 3 };
    // 대상 숫자를 담아둘 배열.
    static int[] result = new int[2];

    // 조합 메서드(cnt는 선택 횟수, idx는 다음 대상을 선택할때 집합에서 탐색을 시작할 인덱스).
    private static void permutation_(int cnt) {
        // 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
        if (cnt == 2) {
            System.out.println(Arrays.toString(result));
            return;
        }
        // 대상 집합을 주어진 인덱스부터 순회하며 숫자를 하나 선택한다.
        for (int i = 0; i < 3; i++) {
            // 숫자를 담는다.
            result[cnt] = target[i];
            permutation_(cnt + 1);
        }
    }


    /*** 조합 ***/
    // 선택하고자 하는 대상 집합.
    static int[] combination_target = new int[] { 1, 2, 3 };
    // 대상 숫자를 담아둘 배열.
    static int[] combination_result = new int[2];

    // 조합 메서드(cnt는 선택 횟수, idx는 다음 대상을 선택할때 집합에서 탐색을 시작할 인덱스).
    private static void combination(int cnt, int idx) {
        // 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
        if (cnt == 2) {
            System.out.println(Arrays.toString(combination_result));
            return;
        }
        // 대상 집합을 주어진 인덱스부터 순회하며 숫자를 하나 선택한다.
        for (int i = idx; i < 3; i++) {
            // 숫자를 담는다.
            combination_result[cnt] = combination_target[i];
            // 자신을 재귀 호출한다(자신 이전의 수를 중복 선택하지 않도록 인덱스를 +1하여 재귀를 호출한다).
            combination(cnt + 1, i + 1);
        }
    }

    /*** 순열 ***/
    // 선택하고자 하는 대상 집합.
    static int[] permutation_target = new int[] { 1, 2, 3 };
    // 대상 숫자를 선택했는지를 알려주는 집합.
    static boolean[] permutation_visited = new boolean[3];
    // 대상 숫자를 담아둘 배열을 만든다.
    static int[] permutation_result = new int[2];

    // 순열 메서드(cnt는 선택 횟수)
    private static void permutation(int cnt) {
        // 2개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
        if (cnt == 2) {
            System.out.println(Arrays.toString(permutation_result));
            return;
        }
        // 대상 집합을 순회하며 숫자를 하나 선택한다.
        for (int i = 0; i < 3; i++) {
            // 이미 해당 숫자를 선택한 경우에는 스킵.
            if (permutation_visited[i]) {
                continue;
            }
            // 선택하지 않은경우, 선택했다는 표시를 해준다.
            permutation_visited[i] = true;
            // 숫자를 담는다.
            permutation_result[cnt] = permutation_target[i];
            // 자신을 재귀 호출한다.
            permutation(cnt + 1);
            // 선택을 해제한다.
            permutation_visited[i] = false;
        }
    }

}
