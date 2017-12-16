package com.serzh.tibetdoctor.services

import com.serzh.tibetdoctor.domain.DrugType
import com.serzh.tibetdoctor.repositories.DrugTypeRepository
import org.springframework.stereotype.Service

@Service
class DrugTypeServiceKotlin(private val drugTypeRepository: DrugTypeRepository) {

    fun all(): Iterable<DrugType> = drugTypeRepository.findAll()
    // Возвращаем коллекцию сущностей, Функциональная запись с указанием типа

    fun get(id: Int): DrugType = drugTypeRepository.findOne(id)

    fun add(product: DrugType): DrugType = drugTypeRepository.save(product)

//    fun edit(id: Long, product: DrugType): DrugType = drugTypeRepository.save(product.copy(id = id)) // Сохраняем копию объекта с указанным id в БД

    fun remove(id: Int) = drugTypeRepository.delete(id)
}