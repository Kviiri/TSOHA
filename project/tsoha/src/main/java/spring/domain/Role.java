package spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity(name = "ROLES")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String rolename;
    @ManyToOne
    private User user;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if ((this.rolename == null) ? (other.rolename != null) : !this.rolename.equals(other.rolename)) {
            return false;
        }
        return true;
    }

 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 59 * hash + (this.rolename != null ? this.rolename.hashCode() : 0);
        return hash;
    }
    
    
}

