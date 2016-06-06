package app

import grails.converters.JSON
/**
 * Created by ceny on 2016/6/4.
 */
class NewsController {

    def newsService

    def getNewsKeywords(){
        def wordCount = [:]
        def keywords = News.executeQuery("select keyWords from News")//以domain里面的为准，驼峰命名风格
        keywords.each{
            def tmp = it.split("&")
            tmp.each {
                if(wordCount[it]){
                    wordCount[it]++
                }
                else{
                    wordCount[it]=1
                }
            }
        }
        def ans = wordCount.sort {a,b->
            return b.value-a.value//降序，返回int类型而不是bool
        }
//        截取MAP前一部分，但是没有现成的API，要么获取那个临界点的value然后findall
//        sub=myMap.findAll{entry ->
//            entry.value<3
//        }
//      要么按如下方法

        int returnNum=20//返回个数
        ans.each {
            if(returnNum--<=0){
                it.remove()
            }
        }
//        =============OR==============
//        sub=myMap.findAll{entry ->
//            entry.value<3
//        }
//        def iterator = ans.entrySet().iterator()
//        int num=10
//        while (iterator.hasNext()){
//            iterator.next()
//            println num
//            if(num<=0){
//                iterator.remove()
//            }
//            else{
//                num--
//            }
//
//        }
        render ans as JSON
    }

    def getNews(){
        params.each{
            println it
        }
        def currentPage = params["page"].toString().toInteger()
        //这里莫名其妙，BUG很多，强制类型转换出来一个49
        //还有2222222 333333之类的
        //不知道什么原因
        //TODO 鲁棒性有待增加
        println currentPage
        if(currentPage<1)
            currentPage=1

        def bdate = params["bdate"]
        def edate = params["edate"]
        //null也可以 不返回数据
        println "select count(*) from News WHERE publishTime BETWEEN $bdate AND $edate"
        def newsNum = News.executeQuery("select count(*) from News WHERE publishTime BETWEEN $bdate AND $edate")[0]
        def newsList = News.executeQuery("select newsTitle,newsUrl,autoAbstract,siteName,scoreAll,scoreCategory,publishTime from News WHERE publishTime BETWEEN $bdate AND $edate",[max:10,offset:(currentPage-1)*10])
        def ans = ["currentPage":currentPage,"totalPage":Math.ceil((double)newsNum/10),"newsNum":newsNum,"newsList":newsList]
        render ans as JSON
    }

    def getNewsCategory(){
        def ans = ["categoryList":["橡胶","钢铁"]]
        render ans as JSON
    }


    def createAbstract(){
        newsService.createAbstarct()
        render "10 done"
    }

}
