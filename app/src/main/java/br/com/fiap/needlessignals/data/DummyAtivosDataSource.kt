package br.com.fiap.needlessignals.data

import br.com.fiap.needlessignals.data.model.Ativos

object DummyAtivosDataSource {
    val ativosList = listOf(
        Ativos(
            activeId = 0,
            name = "EUR/USD",
            description = "Forex",
            categoryId = 1,
            createAt = "18/09/2023",
            updateAt = "18/09/2023",
            value = 1002,
            isBuy = true,
            signalId = 1,
            timeOffer = "SAVE"
        ),
        Ativos(
            activeId = 0,
            name = "EUR/JPY",
            description = "Forex",
            categoryId = 1,
            createAt = "18/09/2023",
            updateAt = "18/09/2023",
            value = 1002,
            isBuy = false,
            signalId = 1,
            timeOffer = "SAVE"
        ),
        Ativos(
            activeId = 0,
            name = "EUR/CAD",
            description = "Forex",
            categoryId = 1,
            createAt = "18/09/2023",
            updateAt = "18/09/2023",
            value = 1002,
            isBuy = true,
            signalId = 1,
            timeOffer = "SAVE"
        ),
        Ativos(
            activeId = 0,
            name = "GBP/USD",
            description = "Forex",
            categoryId = 1,
            createAt = "18/09/2023",
            updateAt = "18/09/2023",
            value = 1002,
            isBuy = true,
            signalId = 1,
            timeOffer = "SAVE"
        ),
        Ativos(
            activeId = 0,
            name = "AUD/CAD",
            description = "Forex",
            categoryId = 1,
            createAt = "18/09/2023",
            updateAt = "18/09/2023",
            value = 1002,
            isBuy = false,
            signalId = 1,
            timeOffer = "SAVE"
        ),
        Ativos(
            activeId = 0,
            name = "BTCUSD",
            description = "Cryptocoin",
            categoryId = 1,
            createAt = "18/09/2023",
            updateAt = "18/09/2023",
            value = 1002,
            isBuy = true,
            signalId = 1,
            timeOffer = "SAVE"
        )
    )
}