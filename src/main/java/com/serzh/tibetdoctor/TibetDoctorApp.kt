package com.serzh.tibetdoctor

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class TibetDoctorApp
//thanks to
//https://habrahabr.ru/post/343364/.com[iz-pesochnitsy]-naiprosteyshiy-restful-ser
fun main(args: Array<String>) {
    SpringApplication.run(TibetDoctorApp::class.java, *args)
}