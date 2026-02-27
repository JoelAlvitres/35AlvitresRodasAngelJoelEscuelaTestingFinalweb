package utils;

import java.util.HashMap;
import java.util.Map;

public class CredencialesHelper {

    private static final Map<String, Credencial> USUARIOS = new HashMap<>();

    static {
        USUARIOS.put("standard", new Credencial("standard_user", "secret_sauce"));
        USUARIOS.put("locked", new Credencial("locked_out_user", "secret_sauce"));
        USUARIOS.put("problem", new Credencial("problem_user", "secret_sauce"));
        USUARIOS.put("performance", new Credencial("performance_glitch_user", "secret_sauce"));
        USUARIOS.put("error", new Credencial("error_user", "secret_sauce"));
        USUARIOS.put("visual", new Credencial("visual_user", "secret_sauce"));
        USUARIOS.put("invalid", new Credencial("usuario_invalido", "password_incorrecto"));
    }

    public static String obtenerUsername(String tipoUsuario) {
        Credencial c = USUARIOS.get(normalizar(tipoUsuario));
        if (c == null) throw new IllegalArgumentException("Tipo de usuario no configurado: " + tipoUsuario);
        return c.username;
    }

    public static String obtenerPassword(String tipoUsuario) {
        Credencial c = USUARIOS.get(normalizar(tipoUsuario));
        if (c == null) throw new IllegalArgumentException("Tipo de usuario no configurado: " + tipoUsuario);
        return c.password;
    }

    private static String normalizar(String tipo) {
        return tipo == null ? "" : tipo.toLowerCase().trim();
    }

    private static class Credencial {
        final String username;
        final String password;

        Credencial(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}