
package BackEnd;

import java.io.Serializable;

public class Utilizador implements Serializable{
    
    private String username;
    private String password;
    
    public Utilizador() {}
    
    public Utilizador(String novoUsername, String novaPassword) {
        setUsername(novoUsername);
        setPassword(novaPassword);
    }
    
    public void setUsername(String novoUsername) {
        username = novoUsername;
    }
    
    public void setPassword(String novaPassword) {
        password = novaPassword;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}
