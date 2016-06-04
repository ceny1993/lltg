package app

import grails.converters.JSON

/**
 * Created by ceny on 2016/6/4.
 */
class DataController {

    def importFutures(){
        println params.id
        def ans = ["status":1]
        render ans as JSON
    }

    def importSales(){
        println params.id
        def ans = ["status":1]
        render ans as JSON
    }

    def importSalesOne(){
        def ans = ["status":1]
        render ans as JSON
    }

    def updateCars(){
        def ans = ["newRecordsNum":300]
        render ans as JSON
    }

    def downloadFutures(){
        def ans = ["status":1]
        render ans as JSON
    }

    def downloadCars(){
        def ans = ["status":1]
        render ans as JSON
    }
}
