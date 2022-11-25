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

   private static final Supplier<Usuario> criarUsuarioValidoUm = () -> {
        Usuario usuarioValido = null;
        try {
            usuarioValido = criarUsuarioValido();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return usuarioValido;

    };

    private static final Supplier<Usuario> criarUsuarioValidoDois= () -> {
        Usuario usuarioValido = null;
        try {
            usuarioValido = criarUsuarioValido();
            usuarioValido.setNome("Lauro Souza");
            usuarioValido.setEmail("lauro.souza@teste.com.br");
            usuarioValido.setSenha("teste");
            usuarioValido.setId(35110);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return usuarioValido;

    };

    private static final Supplier<Usuario> criarUsuarioSemEmail = () -> {
        Usuario usuarioSemSenha = null;
        try {
            usuarioSemSenha = criarUsuarioValido();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        usuarioSemSenha.setEmail("");
        return usuarioSemSenha;

    };
    private static final Supplier<Usuario> criarUsuarioSemSenha = () -> {
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
        MAP.put("usuario valido um",criarUsuarioValidoUm);
        MAP.put("usuario valido dois",criarUsuarioValidoDois);
        MAP.put("usuario sem email",criarUsuarioSemEmail);
        MAP.put("usuario sem senha",criarUsuarioSemSenha);

    }
    public static Usuario getUsuario(String usuario){
        return MAP.get(usuario).get();
    }

}
