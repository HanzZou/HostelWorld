package factory;

import service.LoginService;
import service.LoginServiceImpl;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
public class ServiceFactory {
    public static LoginService getLoginService() {
        return LoginServiceImpl.getInstance();
    }
}
