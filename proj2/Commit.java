import java.io.*;
import java.nio.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class Commit implements Serializable{

	public int commitID;
	public String commitTime;
	public String commitMsg;
	//public Map<Integer, Commit> commitMap;
	public String folderName;
	public Set<String> storedFiles;
	public Commit prevCommit;

	public List<Commit> commitList;

	//constructor
	public Commit (String commitMsg){

		prevCommit = null;

		this.commitMsg = commitMsg;
		commitID = 0;
		folderName = "./.gitlet/commit0:initial commit";
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String editTime = sdf.format(cal.getTime());
        commitTime = editTime;
		initCommit();
		saveCommit();		
	}

	public Commit (String commitMsg, Set<String> storedFiles) {

		Commit oldCommit = loadingCommit();
		prevCommit = oldCommit;
		this.storedFiles = oldCommit.storedFiles;
		//this.storedFiles.addAll(storedFiles);
		this.storedFiles.addAll(storedFiles);

		this.commitMsg = commitMsg;
		commitID = this.commitID + 1;
		folderName = "./.gitlet/" + "commit" + commitID + ":" + commitMsg;
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String editTime = sdf.format(cal.getTime());
        commitTime = editTime;
        //System.out.println("commit with set.");////comment out
		this.saveFiles();
		//System.out.println("save files wocao ");
		this.saveCommit(); 
	}

	public void initCommit() {
		String rootFolderName = ".gitlet";
		File rootFolder = null;
    	File saveFolder = null;		
		if (storedFiles == null) {//????
			try{
				rootFolder = new File(rootFolderName);

    			saveFolder = new File(folderName);
    			
    			if (rootFolder.exists())
    			{
    				System.out.println("A gitlet version control system already exists in the current directory.");
    				return;
    			}

    			boolean flag2 = rootFolder.mkdir();    			
		        boolean flag1 = saveFolder.mkdir();
		        //System.out.println("Directory created? "+boolDirectory);
		    }
    		catch(Exception e){
		         //System.out.println("init folder create failed. ");
		         e.printStackTrace();
		     }			
			return;
		}
	}		
	


	public void saveFiles() {

		for (String inFileName:(this.storedFiles)) {
			//System.out.println(inFileName);
			String outFileName = folderName + "/" + inFileName;

			InputStream inStream = null;
			OutputStream outStream = null;

			try{
				File folder = new File(folderName);

    			boolean flag3 = folder.mkdir();    			

		        //System.out.println("Directory created? "+boolDirectory);
		    }
    		catch(Exception e){
		         System.out.println("commit folder create failed. ");
		         e.printStackTrace();
		     }	

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
    		//System.out.println("Saving file to disk failed.");///comment out
    		e.printStackTrace();
    		}
  	 }
	}
	

	public void saveCommit() {

		try {
			
            //这里是写入想要保存的cat类,每次覆盖原来的ser文件
            File commitSerFile = new File("commitSerFile.ser");
            FileOutputStream fileOut = new FileOutputStream(commitSerFile);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            //System.out.println("save commit");
        } 
        catch (IOException e) {
            String msg = "fail to store the ser file.";
            //System.out.println(msg);
            e.printStackTrace();
        }
	}

	public Commit loadingCommit() {
		Commit cmt = null;
        File commitSer = new File("commitSerFile.ser");

        //if myCatiFile already exists, executing the next line
        //如果cat不存在， 返回null

        if (commitSer.exists()) {
            try {
                //这里是读取出之前保存的cat类
                FileInputStream fileIn = new FileInputStream(commitSer);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                cmt = (Commit) objectIn.readObject();
                //System.out.println(myCatFile);
            } catch (IOException e) {
                String msg = "IOException while loading myDog.";
                //System.out.println(msg);
            } catch (ClassNotFoundException e) {
                String msg = "ClassNotFoundException while loading myDog.";
                //System.out.println(msg);
            }
        }
        return cmt;		
	}
}


/*public class CommitMain {
	public static void main(String[] args) {

		Set<String> files = new HashSet<String>();
		files.add("file1.txt");
		files.add("file2.txt");
		files.add("file3.txt");

		for (String ffile:files)
			System.out.println(ffile);
		Commit cmt = new Commit("init");

		Commit cmt2 = new Commit("first init", files);

		Set<String> files2 = new HashSet<String>();

		files2.add("file4.txt");
		files2.add("file5.txt");
		files2.add("file6.txt");
		Commit cmt3 = new Commit("second init", files2);

	}	
}*/

