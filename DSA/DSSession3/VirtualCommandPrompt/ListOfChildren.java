package GET2018.DSA.DSSession3.VirtualCommandPrompt;

import java.util.Date;

/**
 * This class stores nodeData and their dateOfCreation
 * 
 * @author Mohit Sharma
 *
 */
public class ListOfChildren {
	private Date dateOfCreation;
	private String nodeData;

	public ListOfChildren(Date dateOfCreation, String nodeData) {
		this.dateOfCreation = dateOfCreation;
		this.nodeData = nodeData;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public String getNodeData() {
		return nodeData;
	}
}
