package factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.Usuario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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


}
