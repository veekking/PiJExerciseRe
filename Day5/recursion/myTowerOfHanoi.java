
public class myTowerOfHanoi {
	private  int count = 0;
	private  int disk;
	
	myTowerOfHanoi(int n) {
		disk = n;
		
	}
	
	public void solve() {
		moveDisk(disk, 1, 2, 3);
		System.out.println("The total number of steps required is " + count);
	}
	
public  void moveDisk(int numDisk, int start, int temp, int end) {
		if (numDisk == 1) {moveOneDisk(start, end);
		} else {
		
		moveDisk(numDisk-1, start, end, temp);
		moveOneDisk(start, end);
		moveDisk(numDisk-1, temp, end, start);
		}
	}

private  void moveOneDisk(int start, int end){
	count++;
	System.out.println("The disk is moved from T"+start + " to T" + end);
}

public static void main(String[] args) {
	myTowerOfHanoi mt = new myTowerOfHanoi(5);
	mt.solve();
}
}
