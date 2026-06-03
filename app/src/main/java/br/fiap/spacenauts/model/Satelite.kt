package br.fiap.spacenauts.model


import java.util.Date

data class Satelite(
    val id: Int,
    val nome: String,
    val regiao: RegiaoSatelite,
    val ultimaLeitura: Date,
    val descricao: String
)