import app.WordVec

/**
 * Created by ceny on 2016/6/6.
 */
class WordService {

    def similar(x,y){
        //这几行代码写了一个小时。。。。
        //不要再一次HTTP连接中对一个表执行多个查询
        //第一次查询之后unsaved
        //第二次查询似乎直接引用了第一次的结果导致相似性总是为1
        //应该是跟数据库的事务提交相关
        //具体的不知道
        //Google没有查到原因
        def tmp = WordVec.executeQuery("select vector from WordVec where word= ? or word=?",[x,y])
        return similarCalculate(tmp[0],tmp[1])
    }

    def similarCalculate(vx,vy){
        String[] dx = vx.split("&")
        String[] dy = vy.split("&")
        double a=0,b=0,c=0
        for(int i=0;i<dx.size();i++){
            //println dx[i]+" "+dy[i]
            a = a + dx[i].toDouble()*dy[i].toDouble()
            b = b + dx[i].toDouble()*dx[i].toDouble()
            c = c + dy[i].toDouble()*dy[i].toDouble()
        }

        println a+" "+b+" "+c
        return a/Math.sqrt(b*c)
    }
}
