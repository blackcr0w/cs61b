
public class CommitLauncher {
	public static void main(String args[]) {
		Commit cmt = new Commit("inti commits.");
		cmt.branchMap.put(0, cmt);
		System.out.println(cmt.commitMsg);
		System.out.println(cmt.branchMap);

	}
}