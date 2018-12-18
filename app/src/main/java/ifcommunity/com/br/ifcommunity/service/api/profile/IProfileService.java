package ifcommunity.com.br.ifcommunity.service.api.profile;

public interface IProfileService {

    void verify(String verifyString);

    void profile(ProfileRequest profileRequest);
}
