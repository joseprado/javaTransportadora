/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseprado.levaetraztransporte.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsável por conter os métodos de controle com a base.
 *
 * @author jose.prado
 */
public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/levaetraz";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    /**
     *
     * Método responsável por criar uma conexao com o banco
     *
     * @return
     * @author jose.prado
     */
    public Connection criarConexao() {

        Connection conexao = null;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (Exception e) {
            System.out.println("Erro ao criar conexão com o banco: " + URL);
            e.printStackTrace();
        }
        return conexao;
    }

    /**
     * Método responsável por fechar as conexões.
     *
     * @param conexao
     * @param pstmt
     * @param rs
     */
    public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs) {

        try {

            if (conexao != null) {
                conexao.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }

        } catch (Exception e) {
            System.out.println("Erro ao fechar conexão com o banco: " + URL);
        }
    }

}
