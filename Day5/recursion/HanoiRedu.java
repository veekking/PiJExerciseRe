
public class HanoiRedu {
	
	public int count;
	
	public static void main(String[] args) {
	
	
	}
	
	
	public void solve() {
		HanoiMove(32, 32, 1, 2, 3);
		TowersOfHanoi ht = new TowersOfHanoi(32);
		ht.moveTower(32,1,2,3);
		count = ht.count;
		ht.moveTower(31,3,2,1);
		count = ht.count;
		HanoiMove(32, 31, 1, 3, 2);
	}
	
	
	
	public  void HanoiMove(int even, int odd, int leftmost, int rightmost, int mid) {
		if (odd==1) {
			moveOdd(rightmost, leftmost);
		} else {
			if (even == 1) {
				moveEven(leftmost, rightmost);
			} else {
				TowersOfHanoi h = new TowersOfHanoi(0 );
				moveOdd(rightmost, leftmost);
				h.moveTower(even+odd-1, mid, leftmost, rightmost);
				moveEven(mid, rightmost);
				h.moveTower(even+odd-2, leftmost, mid, rightmost);
				moveEven(leftmost, rightmost);
				
			}
		}
	}
	
	public  void moveOdd(int start, int end) {
		count = count+1;
		System.out.println("Move odd from" + start + "To " + end);
	}
	
	public static void moveEven(int start, int end) {
		System.out.println("Move even from " + start + "To" + end);
	}

}
