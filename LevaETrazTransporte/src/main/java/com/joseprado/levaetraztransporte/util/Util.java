/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseprado.levaetraztransporte.util;

import java.text.Normalizer;

/**
 * Classe util
 * @author jose.prado
 */
public class Util {

    /**
     * Método responsável por remover os ascentos da letras.
     * @param str
     * @return 
     */
    public String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

}
