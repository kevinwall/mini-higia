package br.jus.jfrn.minihigia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDTO
{
    private String type;
    private String token;
}
