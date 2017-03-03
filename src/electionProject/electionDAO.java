package electionProject;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class electionDAO {
	
	Connection con=null;
	
	public electionDAO() {
		// TODO Auto-generated constructor stub
		makeConnection();
	}

	public void makeConnection() {
		String url = "jdbc:mysql://localhost:3306/db_election";
		String user="root";
		String password="DIAD2016";
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, user,password);
			System.out.println("Connection Made");
		} catch (Exception e){
			System.out.println("Connection cannot be made : SQL Exception");
		}
	
	}

	//UPDATE THE CANDIDATE TABLE WITH VOTE COUNTS
	
	public void updateCandidates(electionDB cDB) {
		int temp_cid=cDB.getCandidatesID();
		int temp_c1votes=cDB.geteCandidate1Votes();
		int temp_c2votes=cDB.geteCandidate2Votes();
		int temp_c3votes=cDB.geteCandidate3Votes();
		
		String q_candidate = "Update candidate_dt set c_votes1 = " + temp_c1votes + ", c_votes2 =" + temp_c2votes + ",c_votes3 = " + temp_c3votes + " where c_id = " + temp_cid + "";
		System.out.println(q_candidate);
		try {
			Statement st_c = (Statement) con.createStatement();
			st_c.executeUpdate(q_candidate);

			} catch (SQLException ce){
				System.out.println("Error updating records from Candidate Table : " + ce.getSQLState() + " " + ce.getMessage());
			}
		
	}
	
	//FOR A GIVEN ELECTION ID, RETRIEVE THE CANDIDATE DETAILS
	public electionDB getAllCanddidates(int c_electionid) {
		System.out.println("Candidate Election ID : " + c_electionid);
		int temp_cid=0;
		String temp_c1name="";
		String temp_c2name="";
		String temp_c3name="";
		String temp_ename="";
		int temp_c1votes=0;
		int temp_c2votes=0;
		int temp_c3votes=0;
		int temp_ceid=0;

		String q_candidate = "Select * from candidate_dt where c_eid = '" + c_electionid+"'";
		try {
			Statement st_c = (Statement) con.createStatement();
			ResultSet rs_c = st_c.executeQuery(q_candidate);
			
			while (rs_c.next()) {
				temp_cid = rs_c.getInt(1);
				temp_c1name = rs_c.getString(2);
				temp_c2name = rs_c.getString(3);
				temp_c3name = rs_c.getString(4);
				temp_c1votes = rs_c.getInt(5);
				temp_c2votes = rs_c.getInt(6);
				temp_c3votes = rs_c.getInt(7);
				temp_ceid = rs_c.getInt(8);

			}
			
		} catch (SQLException ce){
			System.out.println("Error retrieving records from Candidate Table");
		}
		
		String q_election = "Select * from election_dt where election_id = '" + c_electionid + "'";
		
		try {
			Statement st_e = (Statement) con.createStatement();
			ResultSet rs_e = st_e.executeQuery(q_election);
			
			while (rs_e.next()) {
				temp_ename = rs_e.getString(2);
			}
			
		} catch (SQLException ce){
			System.out.println("Error retrieving records from Candidate Table for Election");
		}
		
		electionDB cEDB = new electionDB(c_electionid, temp_ename,temp_cid,temp_c1name,temp_c2name,temp_c3name,temp_c1votes,temp_c2votes,temp_c3votes);
		return cEDB;
	}
	
	
	//RETRIEVE ROWS FROM ELECTION TO DISPLAY ON THE LIST
	public ArrayList<electionDB> getAllElections() {
		
		ArrayList<electionDB> allElections = new ArrayList<electionDB>();
		String q_elections = "Select * from election_dt";
				
		try {
			Statement st_e = (Statement) con.createStatement();
			ResultSet rs_e = st_e.executeQuery(q_elections);
			
			while (rs_e.next()) {
				int rsEID = rs_e.getInt(1);
				String rsEName = rs_e.getString(2);
				//System.out.println("Election ID : " + rsEID + " Election Name : " + rsEName);
				electionDB tempeDB = new electionDB(rsEID, rsEName);
				allElections.add(tempeDB);
			}
			
		} catch (SQLException qe) {
			System.out.println("SQL Error in getAllElections method");
		}
		
		return allElections;
	}
	
	
	//INSERT INTO ELECTION & CANDIDATE TABLES
	public void insertNewElection(electionDB eDB){
		makeConnection();
		System.out.print("In Insert DAO");
		//INSERT ROW IN ELECTION TABLE
		int tempe_id = eDB.getElectionID();
		String tempe_name = eDB.getElectionName();
		
		String e_ins_query = "insert into election_dt(election_id, election_name) values('" + tempe_id + "','" + tempe_name + "')";
		System.out.println(e_ins_query);
		
		try {
			Statement ins_st = (Statement) con.createStatement();
			ins_st.executeUpdate(e_ins_query);
		} catch (SQLException e){
			System.out.println("Exception in Election Insert Query");
			e.printStackTrace();
		}
		
		//INSERT ROW IN CANDIDATE TABLE
		String tempc_name1 = eDB.geteCandidate1Name();
		String tempc_name2 = eDB.geteCandidate2Name();
		String tempc_name3 = eDB.geteCandidate3Name();
		int tempc_votes1 = 0;
		int tempc_votes2 = 0;
		int tempc_votes3 = 0;
		
		String c_ins_query = "insert into candidate_dt(c_name1, c_name2, c_name3, c_votes1,c_votes2,c_votes3,c_eid) values('" + tempc_name1 + "','" + tempc_name2 + "','" + tempc_name3 + "','" + tempc_votes1 + "','" + tempc_votes2 + "','" + tempc_votes3 + "','" + tempe_id + "')";		
		System.out.println(c_ins_query);
		
		try {
			Statement c_ins_st = (Statement) con.createStatement();
			c_ins_st.executeUpdate(c_ins_query);
		} catch (SQLException e){
			System.out.println("Exception in Candidate Insert Query");
			e.printStackTrace();
		}	
	}
	
}
