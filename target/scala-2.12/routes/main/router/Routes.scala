// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Pastor/eclipse-workspace/sports-profile-rest/conf/routes
// @DATE:Tue Jul 17 23:04:31 VET 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:9
  Assets_2: controllers.Assets,
  // @LINE:11
  ClientController_0: controllers.ClientController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:9
    Assets_2: controllers.Assets,
    // @LINE:11
    ClientController_0: controllers.ClientController
  ) = this(errorHandler, HomeController_1, Assets_2, ClientController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_2, ClientController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """clientes""", """controllers.ClientController.findAll(nombre:java.util.Optional[String], apellido:java.util.Optional[String], telefono:java.util.Optional[String], email:java.util.Optional[String])"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """clientes/""" + "$" + """id<[^/]+>""", """controllers.ClientController.findById(id:Integer)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """clientes/create""", """controllers.ClientController.create"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """clientes/update""", """controllers.ClientController.update"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_ClientController_findAll2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clientes")))
  )
  private[this] lazy val controllers_ClientController_findAll2_invoker = createInvoker(
    ClientController_0.findAll(fakeValue[java.util.Optional[String]], fakeValue[java.util.Optional[String]], fakeValue[java.util.Optional[String]], fakeValue[java.util.Optional[String]]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClientController",
      "findAll",
      Seq(classOf[java.util.Optional[String]], classOf[java.util.Optional[String]], classOf[java.util.Optional[String]], classOf[java.util.Optional[String]]),
      "GET",
      this.prefix + """clientes""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_ClientController_findById3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clientes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ClientController_findById3_invoker = createInvoker(
    ClientController_0.findById(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClientController",
      "findById",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """clientes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_ClientController_create4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clientes/create")))
  )
  private[this] lazy val controllers_ClientController_create4_invoker = createInvoker(
    ClientController_0.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClientController",
      "create",
      Nil,
      "POST",
      this.prefix + """clientes/create""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_ClientController_update5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clientes/update")))
  )
  private[this] lazy val controllers_ClientController_update5_invoker = createInvoker(
    ClientController_0.update,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClientController",
      "update",
      Nil,
      "PUT",
      this.prefix + """clientes/update""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_2.versioned(path, file))
      }
  
    // @LINE:11
    case controllers_ClientController_findAll2_route(params@_) =>
      call(params.fromQuery[java.util.Optional[String]]("nombre", None), params.fromQuery[java.util.Optional[String]]("apellido", None), params.fromQuery[java.util.Optional[String]]("telefono", None), params.fromQuery[java.util.Optional[String]]("email", None)) { (nombre, apellido, telefono, email) =>
        controllers_ClientController_findAll2_invoker.call(ClientController_0.findAll(nombre, apellido, telefono, email))
      }
  
    // @LINE:12
    case controllers_ClientController_findById3_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_ClientController_findById3_invoker.call(ClientController_0.findById(id))
      }
  
    // @LINE:13
    case controllers_ClientController_create4_route(params@_) =>
      call { 
        controllers_ClientController_create4_invoker.call(ClientController_0.create)
      }
  
    // @LINE:14
    case controllers_ClientController_update5_route(params@_) =>
      call { 
        controllers_ClientController_update5_invoker.call(ClientController_0.update)
      }
  }
}
