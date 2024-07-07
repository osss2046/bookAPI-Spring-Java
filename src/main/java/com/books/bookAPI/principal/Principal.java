package com.books.bookAPI.principal;

import com.books.bookAPI.model.Datos;
import com.books.bookAPI.model.DatosLibros;
import com.books.bookAPI.service.ConsumoAPI;
import com.books.bookAPI.service.ConvierteDatos;

import java.util.Comparator;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    
    public void muestraMenu() {
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        // Top 10 de los libros más descargados

        System.out.println("Top 10 de los libros más descargados");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

    }
}
