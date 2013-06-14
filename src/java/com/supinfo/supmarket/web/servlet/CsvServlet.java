/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supmarket.web.servlet;

import com.supinfo.supmarket.entity.Sales;
import com.supinfo.supmarket.service.SalesService;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vincent
 */
@WebServlet(name = "CsvServlet", urlPatterns = {"/stats/api/export.csv"})
public class CsvServlet extends HttpServlet {

    @EJB
    private SalesService salesService;

    public static <T> void writeCsv(List<List<String>> csv, char separator, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
        for (List<String> row : csv) {
            StringBuilder line = new StringBuilder();
            for (Iterator<String> iter = row.iterator(); iter.hasNext();) {
                String field = String.valueOf(iter.next()).replace("\"", "\"\"");
                if (field.indexOf(separator) > -1 || field.indexOf('"') > -1) {
                    field = '"' + field + '"';
                }
                line.append(field);
                if (iter.hasNext()) {
                    line.append(separator);
                }
            }
            writer.write(line.toString());
            writer.newLine();
        }
        
        writer.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List allSales = new ArrayList();

        List<Sales> sales = salesService.get100LastSales(52782); // Japon

        // Make Hedaer CSV
        List<String> headerCSV = new ArrayList<String>();

        headerCSV.add(0, "saleId");
        headerCSV.add(1, "quantitySold");
        headerCSV.add(2, "amountSold");
        headerCSV.add(3, "timeId");

        headerCSV.add(4, "channelId");
        headerCSV.add(5, "channelDesc");
        headerCSV.add(6, "channelClass");
        headerCSV.add(7, "channelClassId");
        headerCSV.add(8, "channelTotal");
        headerCSV.add(9, "channelTotalId");
        
        headerCSV.add(10, "custId");
        headerCSV.add(11, "custFirstName");
        headerCSV.add(12, "custLastName");
        headerCSV.add(13, "custGender");
        headerCSV.add(14, "custYearOfBirth");
        headerCSV.add(15, "custMaritalStatus");
        headerCSV.add(16, "custStreetAddress");
        headerCSV.add(17, "custPostalCode");
        headerCSV.add(18, "custCity");
        headerCSV.add(19, "custCityId");
        headerCSV.add(20, "custStateProvince");
        headerCSV.add(21, "custStateProvinceId");
        headerCSV.add(22, "custMainPhoneNumber");
        headerCSV.add(23, "custIncomeLevel");
        headerCSV.add(24, "custCreditLimit");
        headerCSV.add(25, "custEmail");
        headerCSV.add(26, "custTotal");
        headerCSV.add(27, "custTotalId");
        headerCSV.add(28, "custSrcId");
        headerCSV.add(29, "CustEffFrom");
        headerCSV.add(30, "custEffTo");
        headerCSV.add(31, "custValid");
        headerCSV.add(32, "countryId");
        
        headerCSV.add(33, "prodId");
        headerCSV.add(34, "prodName");
        headerCSV.add(35, "prodDesc");
        headerCSV.add(36, "prodSubcategory");
        headerCSV.add(37, "prodSubcategoryId");
        headerCSV.add(38, "prodSubcategoryDesc");
        headerCSV.add(39, "prodCategory");
        headerCSV.add(40, "prodCategoryId");
        headerCSV.add(41, "prodCategoryDesc");
        headerCSV.add(42, "prodWeightClass");
        headerCSV.add(43, "prodUnitOfMeasure");
        headerCSV.add(44, "prodPackSize");
        headerCSV.add(45, "supplierId");
        headerCSV.add(46, "prodStatus");
        headerCSV.add(47, "prodListPrice");
        headerCSV.add(48, "prodMinPrice");
        headerCSV.add(49, "prodTotal");
        headerCSV.add(50, "prodTotalId");
        headerCSV.add(51, "prodSrcId");
        headerCSV.add(52, "prodEffFrom");
        headerCSV.add(53, "prodEffTo");
        headerCSV.add(54, "prodValid");
        
        headerCSV.add(55, "promoId");
        headerCSV.add(56, "promoName");
        headerCSV.add(57, "promoSubcategory");
        headerCSV.add(58, "promoSubcategoryId");
        headerCSV.add(59, "promoCategory");
        headerCSV.add(60, "promoCategoryId");
        headerCSV.add(61, "promoCost");
        headerCSV.add(62, "promoBeginDate");
        headerCSV.add(63, "promoEndDate");
        headerCSV.add(64, "promoTotal");
        headerCSV.add(65, "promoTotalId");

        allSales.add(headerCSV);

        for (int i = 0; i < sales.size(); i++) {
            Sales getSale = sales.get(i);

            List<String> currentSale = new ArrayList<String>();
            currentSale.add(0, getSale.getSaleId().toString());
            currentSale.add(1, getSale.getQuantitySold().toString());
            currentSale.add(2, getSale.getAmountSold().toString());
            currentSale.add(3, getSale.getTimeId().toString());

            currentSale.add(4, getSale.getChannelId().getChannelId().toString());
            currentSale.add(5, getSale.getChannelId().getChannelDesc().toString());
            currentSale.add(6, getSale.getChannelId().getChannelClass().toString());
            currentSale.add(7, getSale.getChannelId().getChannelClassId().toString());
            currentSale.add(8, getSale.getChannelId().getChannelTotal().toString());
            currentSale.add(9, getSale.getChannelId().getChannelTotalId().toString());
            
            currentSale.add(10, getSale.getCustId().getCustId().toString());
            currentSale.add(11, getSale.getCustId().getCustFirstName());
            currentSale.add(12, getSale.getCustId().getCustLastName());
            currentSale.add(13, getSale.getCustId().getCustGender().toString());
            currentSale.add(14, getSale.getCustId().getCustYearOfBirth().toString());
            currentSale.add(15, getSale.getCustId().getCustMaritalStatus());
            currentSale.add(16, getSale.getCustId().getCustStreetAddress());
            currentSale.add(17, getSale.getCustId().getCustPostalCode());
            currentSale.add(18, getSale.getCustId().getCustCity());
            currentSale.add(19, getSale.getCustId().getCustCityId().toString());
            currentSale.add(20, getSale.getCustId().getCustStateProvince());
            currentSale.add(21, getSale.getCustId().getCustStateProvinceId().toString());
            currentSale.add(22, getSale.getCustId().getCustMainPhoneNumber());
            currentSale.add(23, getSale.getCustId().getCustIncomeLevel());
            currentSale.add(24, getSale.getCustId().getCustCreditLimit().toString());
            currentSale.add(25, getSale.getCustId().getCustEmail());
            currentSale.add(26, getSale.getCustId().getCustTotal());
            currentSale.add(27, getSale.getCustId().getCustTotalId().toString());
            currentSale.add(28, ""); //getSale.getCustId().getCustSrcId().toString());
            currentSale.add(29, getSale.getCustId().getCustEffFrom().toString());
            currentSale.add(30, ""); //getSale.getCustId().getCustEffTo().toString());
            currentSale.add(31, getSale.getCustId().getCustValid());
            currentSale.add(32, getSale.getCustId().getCountryId().getCountryId().toString());
            
            currentSale.add(33, getSale.getProdId().getProdId().toString());
            currentSale.add(34, getSale.getProdId().getProdName());
            currentSale.add(35, getSale.getProdId().getProdDesc());
            currentSale.add(36, getSale.getProdId().getProdSubcategory());
            currentSale.add(37, getSale.getProdId().getProdSubcategoryId().toString());
            currentSale.add(38, getSale.getProdId().getProdSubcategoryDesc());
            currentSale.add(39, getSale.getProdId().getProdCategory());
            currentSale.add(40, getSale.getProdId().getProdCategoryId().toString());
            currentSale.add(41, getSale.getProdId().getProdCategoryDesc());
            currentSale.add(42, getSale.getProdId().getProdWeightClass().toString());
            currentSale.add(43, getSale.getProdId().getProdUnitOfMeasure());
            currentSale.add(44, getSale.getProdId().getProdPackSize());
            currentSale.add(45, getSale.getProdId().getSupplierId().toString());
            currentSale.add(46, getSale.getProdId().getProdStatus());
            currentSale.add(47, getSale.getProdId().getProdListPrice().toString());
            currentSale.add(48, getSale.getProdId().getProdMinPrice().toString());
            currentSale.add(49, getSale.getProdId().getProdTotal());
            currentSale.add(50, getSale.getProdId().getProdTotalId().toString());
            currentSale.add(51, ""); //getSale.getProdId().getProdSrcId().toString());
            currentSale.add(52, getSale.getProdId().getProdEffFrom().toString());
            currentSale.add(53, ""); //getSale.getProdId().getProdEffTo().toString());
            currentSale.add(54, getSale.getProdId().getProdValid());
            
            currentSale.add(55, getSale.getPromoId().getPromoId().toString());
            currentSale.add(56, getSale.getPromoId().getPromoName());
            currentSale.add(57, getSale.getPromoId().getPromoSubcategory());
            currentSale.add(58, getSale.getPromoId().getPromoSubcategoryId().toString());
            currentSale.add(59, getSale.getPromoId().getPromoCategory());
            currentSale.add(60, getSale.getPromoId().getPromoCategoryId().toString());
            currentSale.add(61, getSale.getPromoId().getPromoCost().toString());
            currentSale.add(62, getSale.getPromoId().getPromoBeginDate().toString());
            currentSale.add(63, getSale.getPromoId().getPromoEndDate().toString());
            currentSale.add(64, getSale.getPromoId().getPromoTotal());
            currentSale.add(65, getSale.getPromoId().getPromoTotalId().toString());

            allSales.add(currentSale);
        }

        response.setHeader("Content-Type", "text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=\"export.csv\"");
        writeCsv(allSales, ';', response.getOutputStream());
    }
}
