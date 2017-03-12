package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.LoginUserEntity;
import entity.UserEntity;
import service.LoginService;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
public class LoginAction extends ActionSupport implements ModelDriven<LoginUserEntity> {

    private LoginService loginService;

    private LoginUserEntity user = new LoginUserEntity();

    @Override
    public LoginUserEntity getModel() {
        return user;
    }

    public String login() {

        return user.getRole().toString();
    }

    public void setLoginService(service.LoginServiceImpl loginService) {
    }
}
