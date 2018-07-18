// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Pastor/eclipse-workspace/sports-profile-rest/conf/routes
// @DATE:Tue Jul 17 23:04:31 VET 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
