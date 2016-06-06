package lltg

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/index"(controller:"test",method:"GET")

        "/file/upload"(controller:"common",action:"upload",method:"POST")

        "/sales/company"(controller:"sales",action:"getCompany",method:"GET")
        "/sales/province"(controller:"sales",action:"getProvince",method:"GET")
        "/sales/predict"(controller:"sales",action:"predict",method:"POST")

        "/news"(controller:"news",action:"getNews",method:"GET")
        "/news/keywords"(controller:"news",action:"getNewsKeywords",method:"GET")
        "/news/category"(controller:"news",action:"getNewsCategory",method:"GET")
        "/news/abstract"(controller:"news",action:"createAbstract",method:"POST")

        "/word/sim"(controller:"word",action:"similar",method:"GET")

        "/data/import/futures/$id"(controller:"data",action:"importFutures",method:"POST")
        "/data/import/sales/$id"(controller:"data",action:"importSales",method:"POST")
        "/data/import/sales"(controller:"data",action:"importSalesOne",method:"POST")
        "/data/update/cars"(controller:"data",action:"updateCars",method:"POST")
        "/data/download/futures"(controller:"data",action:"downloadFutures",method:"GET")
        "/data/download/cars"(controller:"data",action:"downloadCars",method:"GET")

    }
}
