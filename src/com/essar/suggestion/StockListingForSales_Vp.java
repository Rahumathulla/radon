/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.essar.suggestion;
import com.essar.dao.StockDAO;
import com.essar.dao.VpStockDAO;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author rahumathulla
 */


public class StockListingForSales_Vp {
    
   // public static void main(String[] args) {
    VpStockDAO stockDAO = null;
    public StockListingForSales_Vp(){
          stockDAO = new VpStockDAO();
    }

    public static void populateItemNames(JFrame frame, JTextField textField) {

        SuggestionDropDownDecorator.decorate(textField,
                new TextComponentSuggestionClient(StockListingForSales_Vp::getSuggestions));

        frame.setVisible(true);
        

    }
    
    private static List<String> words = VpStockDAO.retrieveItemNames();
    
            //RandomUtil.getWords(2, 400).stream().map(String::toLowerCase).collect(Collectors.toList());
    
    

    private static List<String> getSuggestions(String input) {
        //the suggestion provider can control text search related stuff, e.g case insensitive match, the search  limit etc.
        if (input.isEmpty()) {
            return null;
        }
        return words.stream()
                    .filter(s -> s.toLowerCase().contains(input.toLowerCase()))
                    .limit(20)
                    .collect(Collectors.toList());
    }

}
