package GitInternal;

public class GitInt {
	static int commitCount  = 0;
	CommitNode HEAD = null;
	BranchNode crt = new BranchNode("Master");
	
	
	public class CommitNode {
		int ID;
		String txt;
		CommitNode parent;
	}
	
	public class BranchNode {
		String bname;
		CommitNode branchTo;
		BranchNode next;
		
		BranchNode(String str) {
			bname = str;
			branchTo = HEAD;
			next= null;
		}
	}
	
	
	
	
	
}
