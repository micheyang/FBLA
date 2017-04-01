/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import yang.database.model.Member;

	@XmlRootElement(name = "members")

public class MemberListWrapper {

		//Helper class that wraps the list of members into an outer class
		private List<Member> members;

		public MemberListWrapper(){

		}

		@XmlElement(name = "member")
		public List<Member> getMembers() {
			return members;
		}

		public void setMembers(List<Member> members){
			this.members = members;
		}

}
