package app

import grails.converters.JSON

/**
 * Created by ceny on 2016/6/4.
 */
class NewsController {

    def getKeywords(){
        def ans = ["abc":90,"haha":65,"备胎":77]
        render ans as JSON
    }
}
