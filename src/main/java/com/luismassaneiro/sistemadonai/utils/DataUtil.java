/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luismassaneiro.sistemadonai.utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Nando
 */
public class DataUtil {
     
    public static final Date zeraHora(Date data) {
        if(data == null) 
            return null;
            
        Calendar dataHoraZerada = Calendar.getInstance();
        dataHoraZerada.setTime(data); //colocando o objeto Date no Calendar
        dataHoraZerada.set(Calendar.HOUR_OF_DAY, 0); //zerando as horas, minuots e segundos..
        dataHoraZerada.set(Calendar.MINUTE, 0);
        dataHoraZerada.set(Calendar.SECOND, 0);
        return dataHoraZerada.getTime();
    }    
    
    public static final int compareTo(Date data1, Date data2) {
        Calendar data1Aux = zeraHoraReturnCalendar(data1);
        Calendar data2Aux = zeraHoraReturnCalendar(data2);
        return data1Aux.compareTo(data2Aux);
    }
    
     public static final Calendar zeraHoraReturnCalendar(Date data) {
        if(data == null) 
            return null;
            
        Calendar dataHoraZerada = Calendar.getInstance();
        dataHoraZerada.setTime(data); //colocando o objeto Date no Calendar
        dataHoraZerada.set(Calendar.HOUR_OF_DAY, 0); //zerando as horas, minuots e segundos..
        dataHoraZerada.set(Calendar.MINUTE, 0);
        dataHoraZerada.set(Calendar.SECOND, 0);
        return dataHoraZerada;
    }
     
     
}
