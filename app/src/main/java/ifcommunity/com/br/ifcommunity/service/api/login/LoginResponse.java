package ifcommunity.com.br.ifcommunity.service.api.login;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import ifcommunity.com.br.ifcommunity.service.api.register.RegisterResponse;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 15:48
 */
public class LoginResponse implements Serializable {
    @SerializedName("userId")
    private String userId;

    @SerializedName("studentId")
    private Integer studentId;

    @SerializedName("user")
    private String user;

    @SerializedName("name")
    private String name;

    @SerializedName("phone")
    private String phone;

    @SerializedName("mail")
    private String mail;

    @SerializedName("typeUser")
    private Integer typeUser;

    @SerializedName("period")
    private Integer period;

    @SerializedName("enrolledNumber")
    private String enrolledNumber;

    @SerializedName("photoHash")
    private String photoHash;


    public LoginResponse() {
    }

    public LoginResponse(String userId, Integer studentId, String user, String name, String phone, String mail, Integer typeUser, Integer period, String enrolledNumber, String photoHash) {
        this.userId = userId;
        this.studentId = studentId;
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.typeUser = typeUser;
        this.period = period;
        this.enrolledNumber = enrolledNumber;
        this.photoHash = photoHash;
    }

    public static LoginResponse transformRegisterToLogin(RegisterResponse body) {
        LoginResponse loginResponse = new LoginResponse(
                body.getUserId(),
                body.getStudentId(),
                body.getUser(),
                body.getName(),
                body.getPhone(),
                body.getMail(),
                body.getTypeUser(),
                body.getPeriod(),
                body.getEnrolledNumber(),
                body.getPhotoHash()
        );

        return null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getEnrolledNumber() {
        return enrolledNumber;
    }

    public void setEnrolledNumber(String enrolledNumber) {
        this.enrolledNumber = enrolledNumber;
    }

    public String getPhotoHash() {
        return photoHash;
    }

    public void setPhotoHash(String photoHash) {
        this.photoHash = photoHash;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userId='" + userId + '\'' +
                ", studentId=" + studentId +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", typeUser=" + typeUser +
                ", period=" + period +
                ", enrolledNumber='" + enrolledNumber + '\'' +
                ", photoHash='" + photoHash + '\'' +
                '}';
    }
}
