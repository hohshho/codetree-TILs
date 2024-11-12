import java.util.*;
import java.io.*;

public class Main {
    static int N, M, Q;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        Q = sc.nextInt();

        map = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        while(Q-- > 0) {
            int row = sc.nextInt() - 1;
            char command = sc.next().charAt(0);

            run(row, command, 0);
        }

        for(int[] row : map){
            for(int item : row){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    // move : 0 -> 위아래, 1 -> 아래, 2 ->위
    public static void run(int row, char command, int move){
        if(command == 'L') {
            // 1. 밀기
            int temp = map[row][M - 1];
            for(int i=M-1; i>0; i--){
                map[row][i] = map[row][i - 1];
            }
            map[row][0] = temp;
        }
        else if(command == 'R') {
            int temp = map[row][0];
            for(int i=0; i<M-1; i++){
                map[row][i] = map[row][i + 1];
            }
            map[row][M-1] = temp;
        }

        // 2. 0인 경우는 1,2추가
        if(move == 0) {
            boolean topCheck = false;
            boolean bottomCheck = false;
            int topNext = row - 1;
            int bottomNext = row + 1;

            for(int i=0; i<M; i++) {
                // top검사
                if(topNext >= 0)
                    if(map[row][i] == map[topNext][i]) topCheck = true;
                // bottom검사
                if(bottomNext < N)
                    if(map[row][i] == map[bottomNext][i]) bottomCheck = true;
            }
            if(topCheck && topNext >= 0) run(row - 1, command == 'L' ? 'R' : 'L', 2);
            if(bottomCheck && bottomNext < N) run(row + 1, command == 'L' ? 'R' : 'L', 1);
        }
        // 2.1 아래
        else if(move == 1) {
            boolean bottomCheck = false;
            int bottomNext = row + 1;

            for(int i=0; i<M; i++) {
                // bottom검사
                if(bottomNext < N)
                    if(map[row][i] == map[bottomNext][i]) bottomCheck = true;
            }
            if(bottomCheck && bottomNext < N) run(row + 1, command == 'L' ? 'R' : 'L', 1);
        }
        // 2.2 위
        else if(move == 2){
            boolean topCheck = false;
            int topNext = row - 1;

            for(int i=0; i<M; i++) {
                // top검사
                if(topNext >= 0)
                    if(map[row][i] == map[topNext][i]) topCheck = true;
            }
            if(topCheck && topNext >= 0) run(row - 1, command == 'L' ? 'R' : 'L', 2);
        }
    }
}

/*
0 3 
3 5

*/