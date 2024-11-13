import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] line;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        // 왼쪽부터 상단
        line = new int[N];
        for(int i=0; i<N; i++){
            line[i] = sc.nextInt();
        }

        bomb();

        System.out.println(line.length);
        if(line.length > 0) {
            for(int item : line) {
                System.out.println(item);
            }
        }
    }

    public static void bomb() {
        while(true) {
            if(line.length == 0) return;

            int cnt = 1;
            int prev = line[0];
            boolean[] bombs = new boolean[line.length];

            // 돌면서 터져야 할 위치 찾기
            for(int i=1; i<line.length; i++){
                int cur = line[i];

                if(cur != prev) {
                    if(cnt >= M) {
                        for(int j=1; j<=cnt; j++){
                            bombs[i - j] = true;
                        }
                    }
                    cnt = 1;
                }
                else {
                    cnt += 1;
                }
                prev = cur;
            }

            // 마지막 계산 한번 더
            if(cnt >= M) {
                for(int j=0; j<cnt; j++){
                    bombs[line.length - 1 - j] = true;
                }
            }

            // for(boolean item : bombs) {
            //     System.out.println(item);
            // }

            boolean check = false;

            for(boolean item : bombs) {
                if(item) check = true;
            }

            if(!check) return;
            else {
                cnt = 0;
                // 1. 터지고
                for(int i=0; i<line.length; i++){
                    if(bombs[i]) line[i] = 0;
                    else cnt += 1;
                }

                // 2. 이동
                int[] tempLine = new int[cnt];
                int tempIdx = 0;
                for(int i=0; i<line.length; i++){
                    if(line[i] == 0) continue;

                    tempLine[tempIdx++] = line[i];
                }

                // 3. 갱신
                line = tempLine;
            }
        }
    }
}