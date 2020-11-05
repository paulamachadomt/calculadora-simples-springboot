package edu.usj.calculadoraHistorico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Calculadora {

    List<String> historico = new ArrayList<>();

    @PostMapping(value="/calcular")
    public ModelAndView postCalcular(@RequestParam String a, String b, String sinal) {
        
        ModelAndView modelAndView = new ModelAndView("index");

        String resultado = "";
       
        switch(sinal) {
            case "+":
                resultado = somar(a, b);
                break;
            case "-":
                resultado = diminuir(a, b);
                break;
            case "*":
                resultado = multiplicar(a, b);
                break;
            case "/":
                resultado = dividir(a, b);
                break;  
            default:
                break;  
        }

        historico.add(resultado);

        modelAndView.addObject("resultado", resultado);

        modelAndView.addObject("historico", historico);
        
        return modelAndView;
    }

    /**
     * FUNÇÕES
     */

    public String somar(String a, String b) {
        Double aDouble = Double.valueOf(a);
        Double bDouble = Double.valueOf(b);
        Double resultado = aDouble + bDouble;
        String operacao = a + " + " + b + " = " + resultado;
        return operacao;
    }

    public String diminuir(String a, String b) {
        Double aDouble = Double.valueOf(a);
        Double bDouble = Double.valueOf(b);
        Double resultado = aDouble - bDouble;
        String operacao = a + " - " + b + " = " + resultado;
        return operacao;
    }

    public String multiplicar(String a, String b) {
        Double aDouble = Double.valueOf(a);
        Double bDouble = Double.valueOf(b);
        Double resultado = aDouble * bDouble;
        String operacao = a + " * " + b + " = " + resultado;
        return operacao;
    }

    public String dividir(String a, String b) {
        Double aDouble = Double.valueOf(a);
        Double bDouble = Double.valueOf(b);
        Double resultado = aDouble / bDouble;
        String operacao = a + " / " + b + " = " + resultado;
        return operacao;
    }
       
    
}
