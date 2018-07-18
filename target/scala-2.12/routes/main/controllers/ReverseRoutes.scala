// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Pastor/eclipse-workspace/sports-profile-rest/conf/routes
// @DATE:Tue Jul 17 23:04:31 VET 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:11
  class ReverseClientController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def update(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "clientes/update")
    }
  
    // @LINE:13
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "clientes/create")
    }
  
    // @LINE:12
    def findById(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "clientes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:11
    def findAll(nombre:java.util.Optional[String], apellido:java.util.Optional[String], telefono:java.util.Optional[String], email:java.util.Optional[String]): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "clientes" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[java.util.Optional[String]]].unbind("nombre", nombre)), Some(implicitly[play.api.mvc.QueryStringBindable[java.util.Optional[String]]].unbind("apellido", apellido)), Some(implicitly[play.api.mvc.QueryStringBindable[java.util.Optional[String]]].unbind("telefono", telefono)), Some(implicitly[play.api.mvc.QueryStringBindable[java.util.Optional[String]]].unbind("email", email)))))
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
