/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseprado.levaetraztransporte.dao;

import com.joseprado.levaetraztransporte.factory.ConnectionFactory;
import com.joseprado.levaetraztransporte.model.Mapa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jose.prado
 */
public class MapaDAO extends ConnectionFactory{
    
    private static MapaDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe ClienteDAO (Singleton)
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:03:47
	 * @version 1.0
	 */
	public static MapaDAO getInstance(){
		if(instance == null)
			instance = new MapaDAO();
		return instance;
	}
	
        
    public void salvarMapa(Mapa mapa){
    Connection conexao = null;
		          PreparedStatement pstmt = null;
		          ResultSet rs = null;
        try {
            conexao = criarConexao();
            
            String sql = "insert into mapa (nome, origem, destino, autonomia, preco, rota, distancia) values (?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, mapa.getNome());
            stmt.setString(2, mapa.getOrigem());
            stmt.setString(3, mapa.getDestino());
            stmt.setString(4, mapa.getAutonomia());
            stmt.setString(5, mapa.getValorViagem());
            stmt.setString(6, mapa.getRota());
            stmt.setString(7, mapa.getDistancia());
            
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, pstmt, rs);
            
        }
    }
    
}
