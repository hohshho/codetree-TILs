import java.util.*;
import java.io.*;

public class Main {
    static int N, s1, e1, s2, e2;
    static int[] line;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        line = new int[N];
        for(int i=0; i<N; i++){
            line[i] = sc.nextInt();
        }

        s1 = sc.nextInt()-1;
        e1 = sc.nextInt()-1;
        s2 = sc.nextInt()-1;
        e2 = sc.nextInt()-1;

        int cnt = 0;
        for(int i=s1; i<=e1; i++){
            cnt += 1;
            line[i] = 0;
        }
        int[] temp = new int[N-cnt];
        int tempIdx = 0;
        for(int i=0; i<N; i++){
            if(line[i] == 0) continue;

            temp[tempIdx++] = line[i];
        }
        line = new int[N-cnt];
        for(int i=0; i<line.length; i++){
            line[i] = temp[i];
        }
        
        cnt = 0;
        for(int i=s2; i<=e2; i++){
            cnt += 1;
            line[i] = 0;
        }
        temp = new int[line.length - cnt];
        tempIdx = 0;
        for(int i=0; i<line.length; i++) {
            if(line[i] == 0) continue;

            temp[tempIdx++] = line[i];
        }
        line = new int[line.length-cnt];
        for(int i=0; i<line.length; i++){
            line[i] = temp[i];
        }

        System.out.println(line.length);
        for(int i=0; i<line.length; i++) {
            System.out.println(line[i]);
        }
    }
}