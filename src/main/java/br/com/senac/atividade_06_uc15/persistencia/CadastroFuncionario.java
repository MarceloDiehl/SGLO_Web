package br.com.senac.atividade_06_uc15.persistencia;

import jakarta.persistence.Entity;

@Entity
public class CadastroFuncionario extends CadastroPessoa {

    private Integer idCargo;
    private Integer idEscolaridade;
    private String especialidade;
    private Integer idGenero;
    private String contatoEmergencia;
    private String CTPAS;
    private String email;
    private String senha;

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Integer getIdEscolaridade() {
        return idEscolaridade;
    }

    public void setIdEscolaridade(Integer idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getCTPAS() {
        return CTPAS;
    }

    public void setCTPAS(String CTPAS) {
        this.CTPAS = CTPAS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
