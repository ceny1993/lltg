package app

import grails.converters.JSON

/**
 * Created by ceny on 2016/6/4.
 */
class SalesController {
    def getCompany(){
        def ans = [123:"Agongsi",456:"Bgongsi"]
        render ans as JSON
    }

    def getProvince(){
        def ans = [provinceList:["湖北","广西","浙江"]]
        render ans as JSON
    }

    def predict(){
        def data  = request.JSON
        data.each{
            println it
        }
        def ans = ["num":9999,"predict_num":10000]
        render ans as JSON
    }
}
