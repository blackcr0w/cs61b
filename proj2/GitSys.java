import java.io.*;
import java.nio.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class GitSys implements Serializable {

	public Commit currCommit;

	public Set<String> filesToCommit;

	public List<Branch> branchList;

	class Branch implements Serializable {
		String branchName;
		Commit headPtr;

		public Branch(String _branchname, Commit _currcommit) {
			branchName = _branchname;
			headPtr = _currcommit;
		}
	}

	public Branch currBranch;

	public void initGitlet() {
		//System.out.println("entering initGitlet");
		Commit cmt = new Commit("initial commit");
		currCommit = cmt;
		filesToCommit = new HashSet<String>();
		currBranch  = new Branch("master", cmt);
		branchList = new ArrayList<Branch>();
		branchList.add(currBranch);
		filesToCommit = new HashSet<String>();
		this.saveGitlet();
	}

	public void doCommit(String commitMsg) {
		//System.out.println(filesToCommit);
		Commit cmt = new Commit(commitMsg, filesToCommit);
		//currCommit.
		currBranch.headPtr = cmt;
		currCommit = cmt;
		this.saveGitlet();
	}

	public void addFile(String fileName) {
		File newAddFile = new File(fileName);
		if (!newAddFile.exists()) {
			System.out.println("File does not exist.");
			return;
		}

		if (!filesToCommit.contains(fileName)) {
			filesToCommit.add(fileName);
			this.saveGitlet();
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
		try {
			File newFile = new File(fileName);
			File oldFile = (currBranch.headPtr).getFile(fileName);
			InputStream inStream1 = null;
		    InputStream inStream2 = null;
		    inStream1 = new FileInputStream(oldFile);
		    inStream2 = new FileInputStream(newFile);
		    byte[] buffer1 = new byte[2048];
		    byte[] buffer2 = new byte[2048];
		    inStream2.read(buffer2);
		    inStream1.read(buffer1);

		    for (int i = 0; i < buffer2.length; i ++){
		    	if (buffer1[i] != buffer2[i])
		    		return false;
		    }
		   return true;
		} catch (IOException e){
            //jSystem.out.println("io exception fail");
            e.printStackTrace();
            }

            return true;		
	}

	public void pirntlog(){
		while(currCommit != null) {
			System.out.println("====");
			System.out.println("Commit " + currCommit.commitID + ".");
			System.out.println(currCommit.commitTime);
			System.out.println(currCommit.commitMsg + "\n");
			currCommit = currCommit.prevCommit;
		}
	}


/*	public void clearFiles() {
		filesToCommit.clear();
	}*/
}