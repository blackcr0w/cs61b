public class Gitlet {

	String gitCmd;

	public static void main(String[] args) {
		gitCmd = args[0];
		switch gitCmd {

		case "init": 
			init();
			break;

		case "add": 
			add(args[1]);
			break;

		case "commit":
			commit(args[1]); 
			break;

		case "rm":
			remove(args[1]);
			break;
		case "log":
			log();
			break;


		}



	}

	public void init() {
		
	}	






}