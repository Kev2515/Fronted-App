package com.example.netjob.Utils;

public class Apis {

    public static final String URL_001 = "http://192.168.56.1:8080/api/";

    public static RegistroService getRegisterService() {
        return Cliente.getCliente(URL_001).create(RegistroService.class);
    }

    public static LoginService getLoginService() {
        return Cliente.getCliente(URL_001).create(LoginService.class);
    }

    public static RecuperarService getRecuperarService() {
        return Cliente.getCliente(URL_001).create(RecuperarService.class);
    }

    public static CategoriaService getCategoriaService() {
        return Cliente.getCliente(URL_001).create(CategoriaService.class);
    }

    public static ServicioService getServicioService() {
        return Cliente.getCliente(URL_001).create(ServicioService.class);
    }
}
