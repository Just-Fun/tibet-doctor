package com.serzh.tibetdoctor.services

import com.serzh.tibetdoctor.domain.Patient
import com.serzh.tibetdoctor.repositories.PatientRepository
import org.springframework.stereotype.Service

@Service
class PatientServiceKotlin(private val patientRepository: PatientRepository) {

    fun all(): Iterable<Patient> = patientRepository.findAll()
    // Возвращаем коллекцию сущностей, Функциональная запись с указанием типа

    fun get(id: Int): Patient = patientRepository.findOne(id)

    fun add(product: Patient): Patient = patientRepository.save(product)

//    fun edit(id: Long, product: Drug): Drug = patientRepository.save(product.copy(id = id)) // Сохраняем копию объекта с указанным id в БД

    fun remove(id: Int) = patientRepository.delete(id)

}