package br.com.alura.screenmatch.service;


public interface IConveterDados {
    <T> T obterDados(String json, Class<T> classe);
}