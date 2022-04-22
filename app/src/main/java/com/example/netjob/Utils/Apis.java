package com.example.netjob.Utils;

public class Apis {

    public static final String URL_001="http://172.22.32.1:8080/";

    public static RegistroService getRegisterService(){
        return Cliente.getCliente(URL_001).create(RegistroService.class);
    }

    public static LoginService getLoginService(){
        return Cliente.getCliente(URL_001).create(LoginService.class);
    }



}
