package br.jus.jfrn.minihigia.controller;

import br.jus.jfrn.minihigia.dto.LoginDTO;
import br.jus.jfrn.minihigia.dto.TokenDTO;
import br.jus.jfrn.minihigia.dto.request.DoencaRequestDTO;
import br.jus.jfrn.minihigia.dto.response.DoencaResponseDTO;
import br.jus.jfrn.minihigia.model.Doenca;
import br.jus.jfrn.minihigia.model.Usuario;
import br.jus.jfrn.minihigia.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AutenticationController
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping()
    public ResponseEntity<TokenDTO> auth(@RequestBody @Validated LoginDTO loginDTO){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                loginDTO.getPassword());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.generateToken(authentication);

        return ResponseEntity.ok(new TokenDTO("Bearer", token));
    }
}
