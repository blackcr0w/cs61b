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

	public List<Commit> childCommitList;

	//constructor
	public Commit (String commitMsg){


		commitID = 0;
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String editTime = sdf.format(cal.getTime());
        commitTime = editTime;
        this.commitMsg = commitMsg;
        folderName = "./.gitlet/commit0:initial commit";
        storedFiles = new HashSet<String>();
		prevCommit = null;
		childCommitList = new ArrayList<Commit>();

		this.initCommit();
		this.saveCommit();		
	}

	public Commit (String commitMsg, Set<String> storedFiles) {

		Commit oldCommit = loadingCommit();
		//System.out.println(oldCommit);
		(oldCommit.childCommitList).add(this);////????

		commitID = oldCommit.commitID + 1;

		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String editTime = sdf.format(cal.getTime());
        commitTime = editTime;

        this.commitMsg = commitMsg;
        folderName = "./.gitlet/" + "commit" + commitID + ":" + commitMsg;
        this.storedFiles = new HashSet<String>();
		(this.storedFiles).addAll(storedFiles);
		
		prevCommit = oldCommit;
		childCommitList = new ArrayList<Commit>();

        //System.out.println("commit with set.");////comment out
		this.saveFiles();
		//System.out.println("save files wocao ");
		this.saveCommit(); 
	}

	public void initCommit() {
		String rootFolderName = "./.gitlet";
		File rootFolder = null;
    	File saveFolder = null;
    	//System.out.println("init commit in commit.java");		
		if (storedFiles.isEmpty()) {//????
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
		        //System.out.folderName = "./.gitlet/commit0:initial commit";println("Directory created? "+boolDirectory);
		    }
    		catch(Exception e){
		         System.out.println("init folder create failed. ");
		         e.printStackTrace();
		     }			
			return;
		}
	}		
	


	public void saveFiles() {

		for (String inFileName:(this.storedFiles)) {
			String outFileName = folderName + "/" + inFileName;

			if (inFileName.indexOf("/") != -1) {
				String[] directory = parseDir(inFileName);

				folderName = folderName +"/" + directory[0];

				//inFileName = directory[1];
				//makeFolder(folderName);
			}


			//System.out.println(inFileName);
			//String outFileName = folderName + "/" + inFileName;

			InputStream inStream = null;
			OutputStream outStream = null;



			try{
				File folder = new File(folderName);

    			boolean flag3 = folder.mkdirs();    			

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
            File commitSerFile = new File("./.gitlet/commitSerFile.ser");
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
        File commitSer = new File("./.gitlet/commitSerFile.ser");

        //if myCatiFile already exists, executing the next line
        //如果cat不存在， 返回null

        if (commitSer.exists()) {
        	//System.out.println("ser exists.");
            try {
                
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

	public File getFile(String fileName) {
		String stroedFileName = folderName + "/" + fileName;
		File oldFile = new File(stroedFileName);
		if (oldFile.exists())
			return oldFile;
		else System.out.println("fail to get the old file version.");////
		return null;
	}

	public static String[] parseDir(String name) {
		String[] parts = name.split("/");
		return parts;
	}

	/*public static void makeFolder (String folderName) {

	}*/
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

