/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import DAO.MesaDAO;
import Modelo.Mesa;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author dsaez
 */
@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {
     MesaDAO mdao = new MesaDAO();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListaMesaWS")
    public List<Mesa> ListaMesaWS() {
        List dato = mdao.listar();
        return dato;
    }
}
