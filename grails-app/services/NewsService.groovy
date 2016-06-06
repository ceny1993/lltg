import app.News
import com.hankcs.hanlp.HanLP

/**
 * Created by ceny on 2016/6/5.
 */
class NewsService {

    def createAbstarct(){
        def news = News.findAll(){ autoAbstract == "" }
        println news.size()
        int k=0
        news.each {
            if(k<10) {
                def tmpAutoAbstract = ""
                def tmpKeyWords = ""
                println it["newsTitle"]
                def sentenceList = HanLP.extractSummary(it["newsContent"], 3)
                sentenceList.each {
                    tmpAutoAbstract = tmpAutoAbstract + it + "&"
                }
                def keywordList = HanLP.extractKeyword(it["newsContent"], 5)
                keywordList.each {
                    tmpKeyWords = tmpKeyWords + it + "&"
                }
                it["autoAbstract"] = tmpAutoAbstract
                it["keyWords"] = tmpKeyWords
                it.save()
                k++
            }

        }
        return "ok"
    }

}
