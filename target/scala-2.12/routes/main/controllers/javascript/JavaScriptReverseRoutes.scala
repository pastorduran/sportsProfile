// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Pastor/eclipse-workspace/sports-profile-rest/conf/routes
// @DATE:Tue Jul 17 23:04:31 VET 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:11
  class ReverseClientController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClientController.update",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "clientes/update"})
        }
      """
    )
  
    // @LINE:13
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClientController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "clientes/create"})
        }
      """
    )
  
    // @LINE:12
    def findById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClientController.findById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "clientes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:11
    def findAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClientController.findAll",
      """
        function(nombre0,apellido1,telefono2,email3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "clientes" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[java.util.Optional[String]]].javascriptUnbind + """)("nombre", nombre0), (""" + implicitly[play.api.mvc.QueryStringBindable[java.util.Optional[String]]].javascriptUnbind + """)("apellido", apellido1), (""" + implicitly[play.api.mvc.QueryStringBindable[java.util.Optional[String]]].javascriptUnbind + """)("telefono", telefono2), (""" + implicitly[play.api.mvc.QueryStringBindable[java.util.Optional[String]]].javascriptUnbind + """)("email", email3)])})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
