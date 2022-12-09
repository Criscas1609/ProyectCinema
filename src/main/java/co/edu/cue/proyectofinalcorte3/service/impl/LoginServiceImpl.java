package co.edu.cue.proyectofinalcorte3.service.impl;

import co.edu.cue.proyectofinalcorte3.model.Login;
import co.edu.cue.proyectofinalcorte3.service.LoginService;

import java.util.ArrayList;
import java.util.Objects;

public class LoginServiceImpl implements LoginService {

    ArrayList<Login> listLoginUser = new ArrayList<Login>();

   public void test(){
       listLoginUser.add(new Login("cristhian","123"));
   }
    public Boolean login(String userRegis, String passwordRegis) {
       test();
       boolean x = false;
        for (Login login : listLoginUser) {
            if (Objects.equals(login.getUsername(), userRegis) && Objects.equals(login.getPassword(), passwordRegis)) {
                x = true;
                break;
            }
        }
        return x;

    }

}
