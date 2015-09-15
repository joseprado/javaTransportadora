/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseprado.levaetraztransporte.model;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe responsável por conter os atributos do Objeto Mapa.
 * @author jose.prado
 */
@XmlRootElement
public class Mapa {
    
    private Integer id;
    private String nome;
    private String origem;
    private String destino;
    private String autonomia;
    private String valorViagem;
    private String rota;
    private String distancia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }

    public String getValorViagem() {
        return valorViagem;
    }

    public void setValorViagem(String valorViagem) {
        this.valorViagem = valorViagem;
    }
    
        public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }
    
    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Mapa{" + "id=" + id + ", nome=" + nome + ", origem=" + origem + ", destino=" + destino + ", autonomia=" + autonomia + ", precoGas=" + valorViagem + ", rota=" +rota+""
                + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.origem);
        hash = 67 * hash + Objects.hashCode(this.destino);
        hash = 67 * hash + Objects.hashCode(this.autonomia);
        hash = 67 * hash + Objects.hashCode(this.valorViagem);
        hash = 67 * hash + Objects.hashCode(this.rota);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mapa other = (Mapa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        if (!Objects.equals(this.autonomia, other.autonomia)) {
            return false;
        }
        if (!Objects.equals(this.valorViagem, other.valorViagem)) {
            return false;
        }
        if (!Objects.equals(this.rota, other.rota)) {
            return false;
        }
        return true;
    }


    
    
}
