package com.books.bookAPI.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
