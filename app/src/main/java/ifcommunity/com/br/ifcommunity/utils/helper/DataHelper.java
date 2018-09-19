package ifcommunity.com.br.ifcommunity.utils.helper;

/**
 * Created by gabrielgrs
 * Date: 12/08/2018
 * Time: 12:42
 * Project: vainoracha
 */
public class DataHelper {

    public static String changeEmpytForHyphen(String string) {
        return string.equals("") ? "-" : string;
    }

    public static String maskTelephone(String string) {
        String ddd = string.substring(0, 2);
        String telephone = string.substring(2);
        telephone = telephone.replace(telephone.substring(3, 4), telephone.substring(3, 4) + "-");
        return ddd.replace(ddd, "(" + ddd + ") ") + telephone;
    }
}
