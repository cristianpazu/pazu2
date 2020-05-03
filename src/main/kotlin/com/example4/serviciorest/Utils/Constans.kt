package com.example4.serviciorest.Utils

class Constans {
    companion object{

        private const val URL_API_BASE="/api"
        private const val URL_API_VERSION="/v1"

        private const val URL_BASE=URL_API_BASE+URL_API_VERSION

        //base APi
        const val URL_BASE_PERSONAS="$URL_BASE/personas"
        const val URL_BASE_PERSONASI="$URL_BASE_PERSONAS/insert"
        const val URL_BASE_PERSONASII="$URL_BASE_PERSONAS/get"
        const val URL_BASE_PERSONASIII="$URL_BASE_PERSONAS/update"
    }
}