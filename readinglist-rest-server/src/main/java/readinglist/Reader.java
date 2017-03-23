package readinglist;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reader  {

	@Id
    private String username;
    private String fullname;
    
    @JsonIgnore
    private String password;
    
    //@OneToMany(mappedBy = "reader")
    //private List<ReadingList> readingList = new ArrayList<ReadingList>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

	@Override
	public String toString() {
		return "Reader [username=" + username + ", fullname=" + fullname + ", password=" + password + "]";
	}

}
