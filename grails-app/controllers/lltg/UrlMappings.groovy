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

        "/sales/company"(controller:"sales",action:"getCompanyList",method:"GET")
        "/sales/province"(controller:"sales",action:"getProvinceList",method:"GET")
        "/sales/predict"(controller:"sales",action:"predict",method:"POST")

        "/news/keywords"(controller:"news",action:"getKeywords",method:"GET")
    }
}
