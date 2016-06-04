package app

import grails.converters.JSON
import weka.classifiers.Classifier
import weka.classifiers.Evaluation
import weka.classifiers.functions.LinearRegression
import weka.core.Attribute
import weka.core.DenseInstance
import weka.core.Instance
import weka.core.Instances

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
        double[][] s = new double[4]
        s[0]=[1010882,86166,120651,149621,123146,138679,124430,114282,103184,108910,112762,112351,98449,723895]
        s[1]=[723895,120651,149621,123146,138679,124430,114282,103184,108910,112762,112351,98449,105091,1154906]
        s[2]=[434552,112351,98449,105091,113892,129608,109552,143878,121083,94656,94896,73238,88225,449279]
        s[3]=[449279,98449,105091,113892,129608,109552,143878,121083,94656,94896,73238,88225,94303,1172828]
        double[] t = [1172828,105091,113892,129608,109552,143878,121083,94656,94896,73238,88225,94303,98706,712964]
        ArrayList<Attribute> attributes = new ArrayList<Attribute>()
        14.times {
            attributes.add(new Attribute("att"+it.toString()))
        }
        Instances train = new Instances("relationname",attributes,0)
        Instances test = new Instances("relationname",attributes,0)
        train.setClassIndex(train.numAttributes()-1)
        test.setClassIndex(test.numAttributes()-1)
        4.times {
            Instance instance = new DenseInstance(1.0,s[it])
            train.add(instance)
        }
        test.add(new DenseInstance(1.0,t))
        Classifier classifier = new LinearRegression()
        classifier.buildClassifier(train)
        Evaluation evaluation = new Evaluation(train)
        evaluation.evaluateModel(classifier,test)
        println evaluation.toSummaryString()
        def ans = ["num":t[13],"predict_num":classifier.classifyInstance(test.instance(0))]
        ans.each{
            println it
        }
        render ans as JSON
    }
}
