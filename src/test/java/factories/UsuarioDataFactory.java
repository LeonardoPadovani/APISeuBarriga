package factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Supplier;
import pojos.Usuario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDataFactory {

    public static Usuario criarUsuarioValido() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario usuario = objectMapper.readValue(new FileInputStream
                        ("src/test/resources/requestBody/postLogar.json"),Usuario.class);
        return usuario;
    }

    public static Usuario criarUsuarioSemSenha() throws IOException {
        Usuario usuarioSemSenha = criarUsuarioValido();
        usuarioSemSenha.setSenha("");
        return usuarioSemSenha;
    }

    private static final Supplier<Usuario> criarUsuarioValidoMap = () -> {
        Usuario usuarioValido = null;
        try {
            usuarioValido = criarUsuarioValido();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return usuarioValido;

    };
    private static final Supplier<Usuario> criarUsuarioSemSenhaMap = () -> {
        Usuario usuarioSemSenha = null;
        try {
            usuarioSemSenha = criarUsuarioValido();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        usuarioSemSenha.setSenha("");
        return usuarioSemSenha;

    };

    private static final Map<String, Supplier<Usuario>> MAP = new HashMap<>();

    static {
        MAP.put("usuario sem senha",criarUsuarioSemSenhaMap);
        MAP.put("usuario valido",criarUsuarioValidoMap);
    }
    public static Usuario getUsuario(String usuario){
        return MAP.get(usuario).get();
    }

}
