package com.serzh.tibetdoctor.services

import com.serzh.tibetdoctor.domain.Drug
import com.serzh.tibetdoctor.repositories.DrugsRepository
import org.springframework.stereotype.Service

@Service
class DrugsServiceKotlin(private val drugsRepository: DrugsRepository) {

    fun all(): Iterable<Drug> = drugsRepository.findAll()
    // Возвращаем коллекцию сущностей, Функциональная запись с указанием типа

    fun get(id: Int): Drug = drugsRepository.findOne(id)

    fun save(product: Drug): Drug = drugsRepository.save(product)

//    fun edit(id: Long, product: Drug): Drug = drugsRepository.save(product.copy(id = id)) // Сохраняем копию объекта с указанным id в БД

    fun delete(id: Int) = drugsRepository.delete(id)
}