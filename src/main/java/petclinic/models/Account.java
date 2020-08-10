package petclinic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    private Boolean installed;
    private String permissions;
    private String name;
    private String owner_access_token;
    private String uid;
    private String email;
    private String password;
    private String login_url;

    public Account() {
        this.installed = true;
    }

    public Account(String permissions, String name, String owner_access_token) {
        this.installed = true;
        this.permissions = permissions;
        this.name = name;
        this.owner_access_token = owner_access_token;
    }

    public Boolean getInstalled() {
        return installed;
    }

    public void setInstalled(Boolean installed) {
        this.installed = installed;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner_access_token() {
        return owner_access_token;
    }

    public void setOwner_access_token(String owner_access_token) {
        this.owner_access_token = owner_access_token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin_url() {
        return login_url;
    }

    public void setLogin_url(String login_url) {
        this.login_url = login_url;
    }


    //In metoda equals am ales ca, respectiv, compararea sa se faca doar dupa
    //nume, intrucat la get dupa id intoarce doar numele si id-ul,
    // iar id-ul se extrage gresit. O metoda ar fi cea hardcodata: sa fac
    // get pe toate instantele si dupa sa ma plimb printr-un for
    // pana gasesc instanta cu id-ul meu, sa o extrag si sa-i fac assert
    // pentru a o compara cu account-ul intiial!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return  Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissions, name, owner_access_token, uid);
    }

    @Override
    public String toString() {
        return "Account{" +
                "installed=" + installed +
                ", permissions='" + permissions + '\'' +
                ", name='" + name + '\'' +
                ", owner_access_token='" + owner_access_token + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
