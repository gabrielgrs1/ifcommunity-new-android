package ifcommunity.com.br.ifcommunity.service.api.matter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MMarafelli.
 * Date: 15/12/18
 * Time: 15:48
 */
public class MatterResponse implements Serializable {
    @SerializedName("matterId")
    private int matterId;

    @SerializedName("matterName")
    private String matterName;

    @SerializedName("period")
    private int period;


    public MatterResponse() {
    }

    public int getMatterId() {
        return matterId;
    }

    public void setMatterId(int matterId) {
        this.matterId = matterId;
    }

    public String getMatterName() {
        return matterName;
    }

    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
