import java.util.*;
import java.awt.Point;
public class Main {
	public static int recursive_solve(int i, int j, int steps, int n, HashMap<Point, Integer> m){
		if(steps==0 && !m.containsKey(new Point(i, j))){
			m.put(new Point(i, j), 1);
			return 1;
		}

		int res=0;
		if(steps>0){
			//valid movement of knight
			int[] dx={-2, -1, 1, 2, -2, -1, 1, 2};
			int[] dy={-1, -2, -2, -1, 1, 2, 2, 1};

			//find correct position of Knight in chessboard
			for(int k=0; k<8; k++) {
				if(dx[k]+i>=0 && dx[k]+i<=n-1 && dy[k]+j>=0 && dy[k]+j<=n-1) {
					res+=recursive_solve(dx[k]+i, dy[k]+j, steps-1, n, m);
				}
			}
		}
		return res;
	}
	public static int solve(int i, int j, int steps, int n){
		HashMap<Point, Integer> m=new HashMap<>();
		return recursive_solve(i, j, steps, n, m);
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int steps=scanner.nextInt();
		int i=scanner.nextInt();
		int j=scanner.nextInt();
		int n=100;
		System.out.println(solve(i-1, j-1, steps, n));
	}
}