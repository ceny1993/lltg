package app

/**
 * Created by ceny on 2016/6/6.
 */
class WordVec {
    String word
    String vector

    static constraints = {
        vector (size:0..1024*1024*1024)
    }
}
