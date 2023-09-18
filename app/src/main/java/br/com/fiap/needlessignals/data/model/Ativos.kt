package br.com.fiap.needlessignals.data.model

data class Ativos(
    val activeId: Long,
    val name: String,
    val description: String,
    val categoryId: Long,
    val createAt: String,
    val updateAt: String,
    val value: Int,
    val signalId: Long,
    val isBuy: Boolean,
    val timeOffer: String
)
