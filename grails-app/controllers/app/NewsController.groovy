package app

import grails.converters.JSON
/**
 * Created by ceny on 2016/6/4.
 */
class NewsController {

    def newsService

    def getNewsKeywords(){
        def ans = ["abc":90,"haha":65,"备胎":77]
        render ans as JSON
    }

    def getNews(){
        def tmp = ["id":1,"title":"hello","auto_abstact":"123&456&789&qwe&asd","url":"http://www.baidu.com","categoty":"橡胶","score_all":77.7,"score_category":54]
        def ans = ["newsNum":4998,"totalPage":500,"currentPage":1,"newsList":[tmp,tmp]]
        render ans as JSON
    }

    def getNewsCategory(){
        def ans = ["categoryList":["橡胶","钢铁"]]
        render ans as JSON
    }


    def createAbstract(){
        newsService.createAbstarct(12827)
        render "10 done"
    }

}
