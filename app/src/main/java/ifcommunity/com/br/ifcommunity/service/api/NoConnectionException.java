package ifcommunity.com.br.ifcommunity.service.api;

import java.io.IOException;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;

public class NoConnectionException extends IOException {

    @Override
    public String getMessage() {
        return IfcommunityApplication.getInstance().getString(R.string.no_connection_exception_msg);
    }
}
