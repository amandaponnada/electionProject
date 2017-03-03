package electionProject;

public class electionDB {

	private int electionID;
	private int candidatesID;
	private String electionName;
	private String eCandidate1Name;
	private String eCandidate2Name;
	private String eCandidate3Name;
	private int eCandidate1Votes;
	private int eCandidate2Votes;
	private int eCandidate3Votes;
	private int eTotalVotesPolled;
	
	public electionDB() {
		setElectionID(0);
		setElectionName("");
		setCandidatesID(0);
		seteCandidate1Name("");
		seteCandidate2Name("");
		seteCandidate3Name("");
		seteCandidate1Votes(0);
		seteCandidate2Votes(0);
		seteCandidate3Votes(0);
		seteTotalVotesPolled(0);

	}
	
	public electionDB(int eID, String eName) {
		this.electionID = eID;
		this.electionName = eName;
	}
	
	public electionDB(int e_id, String eName, int c_id, String C1Name, String C2Name, String C3Name, int C1Vote, int C2Vote, int C3Vote) {
		// TODO Auto-generated constructor stub
		setElectionID(e_id);
		setElectionName(eName);
		setCandidatesID(c_id);
		seteCandidate1Name(C1Name);
		seteCandidate2Name(C2Name);
		seteCandidate3Name(C3Name);
		seteCandidate1Votes(C1Vote);
		seteCandidate2Votes(C2Vote);
		seteCandidate3Votes(C3Vote);
		seteTotalVotesPolled(C1Vote+C2Vote+C3Vote);
		
	}

	
	public electionDB( int eID, String eName, String eC1Name, String eC2Name, String eC3Name) {
		// TODO Auto-generated constructor stub
		this.electionID = eID;
		this.electionName = eName;
		this.eCandidate1Name = eC1Name;
		this.eCandidate2Name = eC2Name;
		this.eCandidate3Name = eC3Name;
	}
	
	public void eInitialize() {
		setElectionID(0);
		setElectionName("");
		setCandidatesID(0);
		seteCandidate1Name("");
		seteCandidate2Name("");
		seteCandidate3Name("");
		seteCandidate1Votes(0);
		seteCandidate2Votes(0);
		seteCandidate3Votes(0);
		seteTotalVotesPolled(0);

	}

	public int getElectionID() {
		return electionID;
	}

	public void setElectionID(int electionID) {
		this.electionID = electionID;
	}
	
	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

	public String geteCandidate1Name() {
		return eCandidate1Name;
	}

	public void seteCandidate1Name(String eCandidate1Name) {
		this.eCandidate1Name = eCandidate1Name;
	}

	public String geteCandidate2Name() {
		return eCandidate2Name;
	}

	public void seteCandidate2Name(String eCandidate2Name) {
		this.eCandidate2Name = eCandidate2Name;
	}

	public String geteCandidate3Name() {
		return eCandidate3Name;
	}

	public void seteCandidate3Name(String eCandidate3Name) {
		this.eCandidate3Name = eCandidate3Name;
	}

	public String toString() {
		String eList = String.valueOf(this.electionID);
		eList = eList + " : " + this.electionName;
		return eList;
	}

	public int getCandidatesID() {
		return candidatesID;
	}

	public void setCandidatesID(int candidatesID) {
		this.candidatesID = candidatesID;
	}

	public int geteCandidate1Votes() {
		return eCandidate1Votes;
	}

	public void seteCandidate1Votes(int eCandidate1Votes) {
			this.eCandidate1Votes = eCandidate1Votes;
	}

	public int geteCandidate2Votes() {
		return eCandidate2Votes;
	}

	public void seteCandidate2Votes(int eCandidate2Votes) {
			this.eCandidate2Votes = eCandidate2Votes;
	}

	public int geteCandidate3Votes() {
		return eCandidate3Votes;
	}

	public void seteCandidate3Votes(int eCandidate3Votes) {
			this.eCandidate3Votes = eCandidate3Votes;
	}

	public int geteTotalVotesPolled() {
		return eTotalVotesPolled;
	}

	public void seteTotalVotesPolled(int eTotalVotesPolled) {
		this.eTotalVotesPolled = this.geteCandidate1Votes() + this.geteCandidate2Votes() + this.geteCandidate3Votes();
	}
	
	public String electionWinner() {
		String winner="";
		
		if (geteCandidate1Votes() > geteCandidate2Votes()) {
			if (geteCandidate1Votes() > geteCandidate3Votes()) {
				winner = geteCandidate1Name();
			} else {
				winner = geteCandidate3Name();
			}
		} else {
			if (geteCandidate2Votes() > geteCandidate3Votes()) {
				winner = geteCandidate2Name();
			} else {
				winner = geteCandidate3Name();
			}

		}
		
		return winner;
	}
	
}
