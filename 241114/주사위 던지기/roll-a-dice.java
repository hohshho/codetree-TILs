import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R, C;
    static Dice dice;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt() - 1;
        C = sc.nextInt() - 1;

        dice = new Dice(R, C);
        
        for(int i=0; i<M; i++){
            dice.move(sc.next().charAt(0));
        }
        System.out.println(dice.getSum());
    }

    static class Dice {
        int x, y;
        int top, bottom, north, east, west, south;
        int[][] map;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Dice(int x, int y) {
            this.map = new int[N][N];
            this.x = x;
            this.y = y;
            this.top = 1;
            this.bottom = 6;
            this.north = 5;
            this.south = 2;
            this.east = 3;
            this.west = 4;

            map[y][x] = 6;
        }

        int getSum() {
            int sum = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] > 0) sum += map[i][j];
                }
            }
            return sum;
        }

        void move(char command) {
            if(command == 'L') {
                int nx = this.x + this.dx[0];
                int ny = this.y + this.dy[0];

                if(!isInrange(nx, ny)) return;

                // 이동
                int temp = this.top;
                this.top = this.east;
                this.east = this.bottom;
                this.bottom = this.west;
                this.west = temp;                                                                                                                                                                                                                                                     

                // 결과 처리
                this.x = nx;
                this.y = ny;
                map[this.y][this.x] = this.bottom;
            }
            else if(command == 'D') {
                int nx = this.x + this.dx[1];
                int ny = this.y + this.dy[1];

                if(!isInrange(nx, ny)) return;
                
                // 이동
                int temp = this.top;
                this.top = this.north;
                this.north = this.bottom;
                this.bottom = this.south;
                this.south = temp;

                // 결과 처리
                this.x = nx;
                this.y = ny;
                map[this.y][this.x] = this.bottom;
            }
            else if(command == 'R') {
                int nx = this.x + this.dx[2];
                int ny = this.y + this.dy[2];
  
                if(!isInrange(nx, ny)) return;

                // 이동
                int temp = this.top;
                this.top = this.west;
                this.west = this.bottom;
                this.bottom = this.east;
                this.east = temp;

                // 결과 처리
                this.x = nx;
                this.y = ny;
                map[this.y][this.x] = this.bottom;
            }
            else if(command == 'U') {
                int nx = this.x + this.dx[3];
                int ny = this.y + this.dy[3];

                if(!isInrange(nx, ny)) return;

                // 이동
                int temp = this.top;
                this.top = this.south;
                this.south = this.bottom;
                this.bottom = this.north;
                this.north = temp;

                // 결과 처리
                this.x = nx;
                this.y = ny;
                map[this.y][this.x] = this.bottom;
            }
        }
    }

    public static boolean isInrange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;                                                                                                                                                                                                                                                                               
    }
}