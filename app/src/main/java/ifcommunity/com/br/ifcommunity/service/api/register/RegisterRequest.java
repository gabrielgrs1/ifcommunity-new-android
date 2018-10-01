package ifcommunity.com.br.ifcommunity.service.api.register;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegisterRequest implements Serializable {
    @SerializedName("user")
    private String user;

    @SerializedName("name")
    private String name;

    @SerializedName("phone")
    private String phone;

    @SerializedName("mail")
    private String mail;

    @SerializedName("password")
    private String password;

    @SerializedName("period")
    private Integer period;

    @SerializedName("enrolledNumber")
    private String enrolledNumber;


    public RegisterRequest(String user, String name, String phone, String mail, String password, Integer period, String enrolledNumber) {
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.password = password;
        this.period = period;
        this.enrolledNumber = enrolledNumber;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", period=" + period +
                ", enrolledNumber='" + enrolledNumber + '\'' +
                '}';
    }
}
