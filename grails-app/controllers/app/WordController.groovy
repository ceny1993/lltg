package app

/**
 * Created by ceny on 2016/6/6.
 */
class WordController {

    def wordService

    def similar(){
        render wordService.similar(params["aword"],params["bword"])
    }
}
