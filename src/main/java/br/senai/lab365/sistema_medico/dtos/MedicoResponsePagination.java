package br.senai.lab365.sistema_medico.dtos;

import java.util.List;

public class MedicoResponsePagination {
    private List<MedicoGetRequest> conteudo;
    private int totalPaginas;
    private int tamanhoPagina;
    private int paginaAtual;
    private int totalElementos;
    private boolean ultima;

    public List<MedicoGetRequest> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<MedicoGetRequest> conteudo) {
        this.conteudo = conteudo;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public int getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(int totalElementos) {
        this.totalElementos = totalElementos;
    }

    public boolean isUltima() {
        return ultima;
    }

    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }
}
