package ifcommunity.com.br.ifcommunity.service.api.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import ifcommunity.com.br.ifcommunity.service.api.register.RegisterResponse;

/**
 * Created by gabrielgrs.
 * Date: 11/08/18
 * Time: 15:48
 */
public class LoginResponse implements Parcelable {
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

        return loginResponse;
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

    protected LoginResponse(Parcel in) {
        userId = in.readString();
        studentId = in.readByte() == 0x00 ? null : in.readInt();
        user = in.readString();
        name = in.readString();
        phone = in.readString();
        mail = in.readString();
        typeUser = in.readByte() == 0x00 ? null : in.readInt();
        period = in.readByte() == 0x00 ? null : in.readInt();
        enrolledNumber = in.readString();
        photoHash = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userId);
        if (studentId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(studentId);
        }
        dest.writeString(user);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(mail);
        if (typeUser == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(typeUser);
        }
        if (period == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(period);
        }
        dest.writeString(enrolledNumber);
        dest.writeString(photoHash);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<LoginResponse> CREATOR = new Parcelable.Creator<LoginResponse>() {
        @Override
        public LoginResponse createFromParcel(Parcel in) {
            return new LoginResponse(in);
        }

        @Override
        public LoginResponse[] newArray(int size) {
            return new LoginResponse[size];
        }
    };
}
