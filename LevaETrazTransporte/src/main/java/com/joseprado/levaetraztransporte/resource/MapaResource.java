/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joseprado.levaetraztransporte.resource;

import com.joseprado.levaetraztransporte.controller.MapaController;
import com.joseprado.levaetraztransporte.model.Mapa;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author jose.prado
 */
@Path("/mapa")
public class MapaResource {

    /**
     *
     * Método responsável por fazer chamada ao controller
     *
     * @param nomeMapa
     * @param origem
     * @param destino
     * @param autonomia
     * @param precoCombust
     * @return 
     * @author jose.prado
     */
    @GET
    @Path("/calculo") 
    @Consumes   
    @Produces("application/json")
    public Mapa listarTodos(@QueryParam("nomeMapa") String nomeMapa,
                                       @QueryParam("origem") String origem,
                                       @QueryParam("destino") String destino,
                                       @QueryParam("autonomia") String autonomia,
                                       @QueryParam("precoCombust") String precoCombust) {
        
        return new MapaController().listaMapa(nomeMapa, origem, destino, autonomia, precoCombust);
    }
}
