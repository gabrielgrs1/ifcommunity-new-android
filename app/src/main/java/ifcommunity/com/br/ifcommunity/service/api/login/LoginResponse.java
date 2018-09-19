package ifcommunity.com.br.ifcommunity.service.api.login;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 15:48
 */
public class LoginResponse implements Serializable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("cpfOrCnpj")
    private String cpfOrCnpj;

    @SerializedName("userName")
    private String userName;

    @SerializedName("profiles")
    private ArrayList profiles;

    @SerializedName("rentalHistory")
    private ArrayList<Rental> rentalHistory;

    public LoginResponse() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList getProfiles() {
        return profiles;
    }

    public ArrayList<Rental> getRentalHistory() {
        return rentalHistory;
    }

    private class Rental {

        @SerializedName("id")
        private Integer id;

        @SerializedName("blockRentStatus")
        private String blockRentStatus;

        @SerializedName("date")
        private String date;

        public Integer getId() {
            return id;
        }

        public String getBlockRentStatus() {
            return blockRentStatus;
        }

        public String getDate() {
            return date;
        }

        @Override
        public String toString() {
            return "Rental{" +
                    "id=" + id +
                    ", blockRentStatus='" + blockRentStatus + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpfOrCnpj='" + cpfOrCnpj + '\'' +
                ", userName='" + userName + '\'' +
                ", profiles=" + profiles +
                ", rentalHistory=" + rentalHistory +
                '}';
    }
}
