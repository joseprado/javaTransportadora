/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseprado.levaetraztransporte.controller;

import com.joseprado.levaetraztransporte.dao.MapaDAO;
import com.joseprado.levaetraztransporte.factory.RotaFactory;
import com.joseprado.levaetraztransporte.model.Mapa;
import com.joseprado.levaetraztransporte.util.Util;

/**
 *Classe responsáveis por conter os metodos de controle dos mapas
 * @author jose.prado
 */
public class MapaController {

    RotaFactory rota = new RotaFactory();
    
    Util util = new Util();
    
    /**
     * Metodo responsável por listar o mapa.
     * @param nomeMapa
     * @param origem
     * @param destino
     * @param autonomia
     * @param precoCombust
     * @return 
     */
    public Mapa listaMapa(String nomeMapa, String origem, String destino, String autonomia, String precoCombust) {
        
        Mapa mapa = new Mapa();
        
        if(nomeMapa != null || !nomeMapa.equals("") && 
           origem != null || !origem.equals("") &&
           destino != null || !destino.equals("") &&
           autonomia != null || !autonomia.equals("") &&
           precoCombust != null || !precoCombust.equals("")) {
        
                origem = util.removerAcentos(origem);
                destino = util.removerAcentos(destino);
                
                mapa = retornaMapa(nomeMapa, origem, destino, autonomia, precoCombust, mapa);
        }
        
        MapaDAO.getInstance().salvarMapa(mapa);
        
        return mapa;
    } 

    /**
     * Metodo responsável por retornar o objeto Mapa preenchido
     * @param nomeMapa
     * @param origem
     * @param destino
     * @param autonomia
     * @param precoCombust
     * @param mapa
     * @return 
     */
    private Mapa retornaMapa(String nomeMapa, String origem, String destino, String autonomia, String precoCombust, Mapa mapa) {
        
        mapa = rota.calcular(origem, destino, mapa);
        
        mapa.setValorViagem(valorViagem(precoCombust, autonomia, mapa.getDistancia()));
        
        mapa.setNome(nomeMapa);
        mapa.setOrigem(origem);
        mapa.setDestino(destino);
        
        
        
        return mapa;
    }
    
    /**
     * Metodo responsável por retornar o valor total da viagem
     * @param preco
     * @param autonomia
     * @param distanciaDestino
     * @return 
     */
    private String valorViagem(String preco, String autonomia, String distanciaDestino){
    
        double precoCombust = Double.parseDouble(preco);
        double autonomiaCaminhao = Double.parseDouble(autonomia);
        
        String[] caminho = distanciaDestino.split(" ");
        double distancia = Double.parseDouble(caminho[0]);
        
        double valorViagem = (distancia / autonomiaCaminhao) * precoCombust;
        
        
        return String.valueOf(valorViagem);
    }
}
