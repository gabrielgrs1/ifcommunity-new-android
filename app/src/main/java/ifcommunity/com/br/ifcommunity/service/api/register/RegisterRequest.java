package ifcommunity.com.br.ifcommunity.service.api.register;

import com.google.gson.annotations.SerializedName;

import ifcommunity.com.br.ifcommunity.service.api.login.LoginRequest;

public class RegisterRequest {

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

    public RegisterRequest(String userId, Integer studentId, String user, String name, String phone, String mail, Integer typeUser, Integer period, String enrolledNumber) {
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

    public Integer getStudentId() {
        return studentId;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public Integer getTypeUser() {
        return typeUser;
    }

    public Integer getPeriod() {
        return period;
    }

    public String getEnrolledNumber() {
        return enrolledNumber;
    }
}
