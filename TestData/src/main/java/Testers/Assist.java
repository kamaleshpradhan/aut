package testbox;

public class Assist {

	
	public String getSQLQuery(int opt,int row){
		
		String q=null;
	switch(opt){
	
	case 1:
		q="select fst_name from siebel.s_contact where rownum<"+row;
		break;
	case 2:
		q="select fst_name from siebel.s_contact where rownum<"+row;
		break;
	default:
		System.out.println("Please choose a valid option...");
		
	}
	return(q);
	}
	
}
