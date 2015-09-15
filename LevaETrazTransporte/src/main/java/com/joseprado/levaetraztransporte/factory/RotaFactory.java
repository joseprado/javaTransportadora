/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseprado.levaetraztransporte.factory;

import com.joseprado.levaetraztransporte.model.Mapa;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Classe responsável por fazer as conexao e trabalho com os dados na API da Google Maps Directory
 * @author jose.prado
 */
public class RotaFactory {

    /**
     * Metodo responsável por invocar o webservice e retornar o mapa.
     * @param origem
     * @param destino
     * @param mapa
     * @return 
     */
    public Mapa calcular(String origem, String destino, Mapa mapa) {
        URL url;
        try {
            url = new URL(
                    "http://maps.google.es/maps/api/directions/xml?origin="
                    + origem + "&destination=" + destino
                    + "&sensor=false");

            Document document = getDocumento(url);

            mapa.setDistancia(retornaKM(document));

            mapa.setRota(retornaRota(document));

            return mapa;
        } catch (MalformedURLException | DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo responsável em converter os dados retornados pelo webservice
     * @param url
     * @return
     * @throws DocumentException 
     */
    public static Document getDocumento(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

    /**
     * Metodo responsável por retornar o valor em distancia entre as cidades.
     * @param document
     * @return 
     */
    @SuppressWarnings("rawtypes")
    public static String retornaKM(Document document) {
        String textoXml = document.getText();

        List list = document
                .selectNodes("//DirectionsResponse/route/leg/distance/text");

        Element element = (Element) list.get(list.size() - 1);

        return element.getText();
    }

    /**
     * Método responsável por trazer a rota que deve ser seguida no caminho.
     * @param document
     * @return 
     */
    private String retornaRota(Document document) {
        List listCaminho = document.selectNodes("//DirectionsResponse/route/leg/step/html_instructions");
        String rota = "";

        for (Object listCaminho1 : listCaminho) {
            Element element = (Element) listCaminho1;
            
            rota += element.getText().concat("\n");
        }

        return rota;
    }
}
