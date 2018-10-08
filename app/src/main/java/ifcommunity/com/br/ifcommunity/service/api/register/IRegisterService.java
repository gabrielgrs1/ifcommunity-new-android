package ifcommunity.com.br.ifcommunity.service.api.register;

public interface IRegisterService {

    void verify(String verifyString);

    void register(RegisterRequest registerRequest);
}
