/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.web.webservice;

import com.supinfo.supmarket.entity.Sales;
import com.supinfo.supmarket.service.SalesService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Vincent
 */
@WebService(serviceName = "SOAPWebService")
public class SOAPWebService {
    
    @EJB
    private SalesService salesService;

    @WebMethod(operationName = "getLastSales")
    public List<Sales> getLastSales() {
        return salesService.get100LastSales(52779); //France
    }
}
