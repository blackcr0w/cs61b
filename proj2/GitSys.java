import java.io.*;
import java.nio.*;
import java.util.*;
import java.text.SimpleDateFormat;
//AG
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

	public void checkout(String cmd) {
		int ckType = parseCheckout(cmd);
		switch (ckType) {
			case 1://[file name]

			String outFile = cmd;
			String inFile = (this.currCommit).folderName + "/" + cmd;
			if (outFileName.indexOf("/")!= -1) {
				String[] directory = parseDir(outFile);
				String folderName = directory[0];
				outFile = directory[1];
				makeFolder(folderName);
			}
			copyFiles(inFile, outFile);

			break;

			case 2://[commit id] [file name]
			break;

			case 3://[branch name]
			break;
		}
	}

	public int parseCheckout(String cmd) {
		return 1;
	}

	public void copyFiles(String inFileName, String outFileName) {

		InputStream inStream = null;
		OutputStream outStream = null;
		try{
    	    File inFile =new File(inFileName);
    	    File outFile =new File(outFileName);
 
    	    inStream = new FileInputStream(inFileName);
    	    outStream = new FileOutputStream(outFileName);
 
    	    byte[] buffer = new byte[2048];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }

    	    inStream.close();
    	    outStream.close();
 
    	    //System.out.println("File is copied successful!");///comment out
 
    		}catch(IOException e){
    		System.out.println("fail to checkout file.");///comment out
    		e.printStackTrace();
    		}
	}

	public static String[] parseDir(String name) {

	}

	public static void makeFolder (String folderName) {

	}
 



}