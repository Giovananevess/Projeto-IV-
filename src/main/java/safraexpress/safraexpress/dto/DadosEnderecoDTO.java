package safraexpress.safraexpress.dto;


public record DadosEnderecoDTO(

        String logradouro,

        String bairro,

        String cep,

        String cidade,

        String uf,
        String complemento,
        String numero
) {
}
