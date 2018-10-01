package ifcommunity.com.br.ifcommunity.service.api.register;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

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

    public RegisterResponse(String userId, Integer studentId, String user, String name, String phone, String mail, Integer typeUser, Integer period, String enrolledNumber) {
        this.userId = userId;
        this.studentId = studentId;
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.typeUser = typeUser;
        this.period = period;
        this.enrolledNumber = enrolledNumber;
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
}
