package app

/**
 * Created by ceny on 2016/6/5.
 */
class News {
    Date publishTime
    String siteName
    String siteType
    String newsUrl
    String newsTitle
    String newsContent
    String autoAbstract
    String vector
    Double scoreAll
    Double scoreCategory
    String keyWords

    static constraints = {
        newsContent (size:0..1024*1024*1024)
        autoAbstract (size:0..1024*1024*1024)
        vector (size:0..1024*1024*1024)
    }
}
