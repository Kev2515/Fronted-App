package com.example.netjob.Utils;

import com.example.netjob.RecuperarC;

public class Apis {

    public static final String URL_001="http://172.22.32.1:8080/api/";

    public static RegistroService getRegisterService(){
        return Cliente.getCliente(URL_001).create(RegistroService.class);
    }

    public static LoginService getLoginService(){
        return Cliente.getCliente(URL_001).create(LoginService.class);
    }
    public static RecuperarService getRecuperarService(){
        return Cliente.getCliente(URL_001).create(RecuperarService.class);
    }



}
