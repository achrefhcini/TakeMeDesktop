package model.entities;

/**
 * Created by Green on 03/02/2017.
 */
public class Membre {
    public static Integer IdUserConnected=0;
    private Integer id_membre;
    private String role;
    private String nom;
    private String prenom;
    private String num_tel;
    private String email;
    private String photo;
    private Integer age;
    private String sexe;
    private String password;
    private Boolean verifMail;
    private Boolean verifTel;
    private Integer CodeVerifMail;
    private Integer CodeVerifTel;
    private Boolean isActif;



    public Membre (){}

    public Membre(String nom, String prenom, String email, String sexe, String password) {

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "id_membre=" + id_membre +
                ", role=" + role +
                ", nom=" + nom +
                ", prenom=" + prenom  +
                ", num_tel=" + num_tel +
                ", email=" + email  +
                ", photo=" + photo +
                ", age=" + age +
                ", sexe=" + sexe  +
                ", password=" + password  +
                ", verifMail=" + verifMail +
                ", verifTel=" + verifTel +
                ", CodeVerifMail=" + CodeVerifMail +
                ", CodeVerifTel=" + CodeVerifTel +
                ", isActif=" + isActif +
                '}';
    }




    public Integer getId_membre() {
        return id_membre;
    }

    public void setId_membre(Integer id_membre) {
        this.id_membre = id_membre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isVerifMail() {
        return verifMail;
    }

    public void setVerifMail(Boolean verifMail) {
        this.verifMail = verifMail;
    }

    public Boolean isVerifTel() {
        return verifTel;
    }

    public void setVerifTel(Boolean verifTel) {
        this.verifTel = verifTel;
    }

    public Boolean isActif() {
        return isActif;
    }

    public void setActif(Boolean actif) {
        isActif = actif;
    }

    public Integer getCodeVerifMail() {
        return CodeVerifMail;
    }

    public void setCodeVerifMail(Integer codeVerifMail) {
        CodeVerifMail = codeVerifMail;
    }

    public Integer getCodeVerifTel() {
        return CodeVerifTel;
    }

    public void setCodeVerifTel(Integer codeVerifTel) {
        CodeVerifTel = codeVerifTel;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Membre)) return false;

        Membre Membre = (Membre) o;

        return id_membre == Membre.id_membre;
    }

    @Override
    public int hashCode() {
        return id_membre;
    }
}
