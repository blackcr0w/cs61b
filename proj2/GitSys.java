import java.io.*;
import java.nio.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class GitSys implements Serializable {

	public Commit currCommmit;

	public Set<String> filesToCommit;

	public List<Branch> branchList;

	class Branch {
		String branchName;
		Commit headPtr;

		public Branch(String _branchname, Commit _currcommmit) {
			branchName = _branchname;
			headPtr = _currcommmit;
		}
	}

	public Branch currBranch;

	public void initCommit() {
		Commit cmt = new Commit("initial commit");
		currBranch  = new Branch("master", cmt);
		branchList = new ArrayList<Branch>();
		branchList.add(currBranch);
		filesToCommit = new HashSet<String>();
		this.saveGitlet();
	}

	public void doCommit(String commitMsg) {
		Commit cmt = new Commit(commitMsg, filesToCommit);
		currBranch.headPtr = cmt;
	}

	public void addFile(String fileName) {
		File newAddFile = new File(fileName);
		if (!newAddFile.exists()) {
			System.out.println("File does not exist.");
			return;
		}

		if (!filesToCommit.contains(fileName)) {
			filesToCommit.add(fileName);
			return;
		}

		if (!checkFileModified(fileName)) {
			System.out.println("File has not been modified since the last commit.");
			return;
		}
	
	}

	public void removeFile(String fileName) {
		return;
	}

/*	public Commit loadOldCommit() {

		return (branch.currCommit).loadingCommit;
	}*/

	public void saveGitlet() {
		try {
			
            //这里是写入想要保存的cat类,每次覆盖原来的ser文件
            File gitletSerFile = new File("./.gitlet/gitlet.ser");
            FileOutputStream fileOut = new FileOutputStream(gitletSerFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            //System.out.println("save commit");
        } 
        catch (IOException e) {
            String msg = "fail to store the gitlet ser file.";
            //System.out.println(msg);
            e.printStackTrace();
        }
	}

	public boolean checkFileModified(String fileName) {
		File newFile = new File(fileName);
		File oldFile = currCommmit.getFile(fileName);
		if (newFile.lastModified() > oldFile.lastModified())
			return true;
		return false;
	}

	public void pirntlog(){
		while(currCommmit.prevCommit != null) {
			System.out.println("====");
			System.out.println("Commit " + currCommmit.commitID + ".");
			System.out.println(currCommmit.commitTime);
			System.out.println(currCommmit.commitMsg + "\n");
			currCommmit = currCommmit.prevCommit;
		}
	}


/*	public void clearFiles() {
		filesToCommit.clear();
	}*/
}