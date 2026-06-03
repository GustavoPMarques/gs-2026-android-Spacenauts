package br.fiap.spacenauts.data

import br.fiap.spacenauts.model.RegiaoSatelite
import br.fiap.spacenauts.model.Satelite

import java.util.Date

val satelites = listOf(
    Satelite(
        id = 1,
        nome = "Jason-3",
        regiao = RegiaoSatelite.SP,
        ultimaLeitura = Date(),
        descricao = "Lançado em janeiro de 2016, o Jason-3 monitora o nível dos oceanos com precisão milimétrica. Em 2020, seus dados foram essenciais para prever a ressaca que atingiu o litoral de São Paulo, permitindo que autoridades evacuassem comunidades costeiras horas antes do desastre."
    ),
    Satelite(
        id = 2,
        nome = "Jason-CS",
        regiao = RegiaoSatelite.AL,
        ultimaLeitura = Date(),
        descricao = "Lançado em 2022 como sucessor do Jason-3, o Jason-CS ampliou a cobertura orbital sobre o Atlântico Sul. Em 2023, identificou uma elevação anômala do nível do mar no litoral de Alagoas com 48 horas de antecedência, evitando perdas materiais em dezenas de municípios costeiros."
    ),
    Satelite(
        id = 3,
        nome = "Sentinel-6A",
        regiao = RegiaoSatelite.RR,
        ultimaLeitura = Date(),
        descricao = "Lançado em novembro de 2020 pela Agência Espacial Europeia em parceria com a NASA, o Sentinel-6A é um dos satélites mais modernos de monitoramento oceânico. Opera sobre Roraima coletando dados climáticos da região amazônica."
    ),
    Satelite(
        id = 4,
        nome = "TOPEX-1",
        regiao = RegiaoSatelite.SC,
        ultimaLeitura = Date(),
        descricao = "Inspirado na missão TOPEX/Poseidon dos anos 90, o TOPEX-1 brasileiro foi lançado em 2019 com foco no monitoramento do Sul do país. Seus dados ajudaram a mapear as enchentes que assolaram Santa Catarina em 2023, contribuindo para o planejamento de rotas de evacuação."
    ),
    Satelite(
        id = 5,
        nome = "Cryosat-2",
        regiao = RegiaoSatelite.DF,
        ultimaLeitura = Date(),
        descricao = "Lançado originalmente pela ESA em 2010, o Cryosat-2 monitora variações de temperatura e gelo polar. Sua estação de controle no Distrito Federal coordena as leituras sobre o Brasil Central, fornecendo dados sobre ondas de calor e variações climáticas no Cerrado."
    )
)

fun getAllSatelites(): List<Satelite> {
    return satelites
}