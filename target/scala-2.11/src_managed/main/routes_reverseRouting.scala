// @SOURCE:/home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/conf/routes
// @HASH:1832fdc2fd4feac8b2f31c14d29ee307008f4122
// @DATE:Sat Jan 17 13:14:51 JST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:47
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:24
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers {

// @LINE:47
class ReverseAssets {


// @LINE:47
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:24
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {


// @LINE:26
def uncheckTask(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tasks/" + implicitly[PathBindable[Long]].unbind("id", id) + "/uncheck")
}
                        

// @LINE:10
def tasks(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tasks")
}
                        

// @LINE:31
def getjson(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api")
}
                        

// @LINE:17
def deleteTask(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tasks/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                        

// @LINE:38
def signup(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "signup")
}
                        

// @LINE:11
def modal(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "modal")
}
                        

// @LINE:19
def updateTask(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tasks/" + implicitly[PathBindable[Long]].unbind("id", id) + "/update")
}
                        

// @LINE:21
def changeDate(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tasks/" + implicitly[PathBindable[Long]].unbind("id", id) + "/changeDate")
}
                        

// @LINE:24
def checkTask(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tasks/" + implicitly[PathBindable[Long]].unbind("id", id) + "/check")
}
                        

// @LINE:41
def users(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "debug")
}
                        

// @LINE:37
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:39
def register(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                        

// @LINE:12
def newTask(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tasks")
}
                        

// @LINE:36
def authenticate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:32
def get_logging_user_id_json(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logging_user_id")
}
                        

// @LINE:35
// @LINE:14
def login(): Call = {
   () match {
// @LINE:14
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "registered")
                                         
   }
}
                                                

}
                          
}
                  


// @LINE:47
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:24
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:47
class ReverseAssets {


// @LINE:47
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:24
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {


// @LINE:26
def uncheckTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.uncheckTask",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/uncheck"})
      }
   """
)
                        

// @LINE:10
def tasks : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.tasks",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks"})
      }
   """
)
                        

// @LINE:31
def getjson : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getjson",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api"})
      }
   """
)
                        

// @LINE:17
def deleteTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteTask",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:38
def signup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.signup",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:11
def modal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.modal",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "modal"})
      }
   """
)
                        

// @LINE:19
def updateTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.updateTask",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/update"})
      }
   """
)
                        

// @LINE:21
def changeDate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.changeDate",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/changeDate"})
      }
   """
)
                        

// @LINE:24
def checkTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.checkTask",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/check"})
      }
   """
)
                        

// @LINE:41
def users : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.users",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "debug"})
      }
   """
)
                        

// @LINE:37
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:39
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:12
def newTask : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newTask",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks"})
      }
   """
)
                        

// @LINE:36
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:32
def get_logging_user_id_json : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.get_logging_user_id_json",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logging_user_id"})
      }
   """
)
                        

// @LINE:35
// @LINE:14
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registered"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
      }
   """
)
                        

}
              
}
        


// @LINE:47
// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:24
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.ref {


// @LINE:47
class ReverseAssets {


// @LINE:47
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:41
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:24
// @LINE:21
// @LINE:19
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {


// @LINE:26
def uncheckTask(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.uncheckTask(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "uncheckTask", Seq(classOf[Long]), "POST", """""", _prefix + """tasks/$id<[^/]+>/uncheck""")
)
                      

// @LINE:10
def tasks(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.tasks(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "tasks", Seq(), "GET", """ Tasks""", _prefix + """tasks""")
)
                      

// @LINE:31
def getjson(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getjson(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getjson", Seq(), "GET", """""", _prefix + """api""")
)
                      

// @LINE:17
def deleteTask(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteTask(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteTask", Seq(classOf[Long]), "POST", """""", _prefix + """tasks/$id<[^/]+>/delete""")
)
                      

// @LINE:38
def signup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.signup(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "signup", Seq(), "GET", """""", _prefix + """signup""")
)
                      

// @LINE:11
def modal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.modal(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "modal", Seq(), "GET", """""", _prefix + """modal""")
)
                      

// @LINE:19
def updateTask(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.updateTask(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "updateTask", Seq(classOf[Long]), "POST", """""", _prefix + """tasks/$id<[^/]+>/update""")
)
                      

// @LINE:21
def changeDate(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.changeDate(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "changeDate", Seq(classOf[Long]), "POST", """""", _prefix + """tasks/$id<[^/]+>/changeDate""")
)
                      

// @LINE:24
def checkTask(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.checkTask(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "checkTask", Seq(classOf[Long]), "POST", """""", _prefix + """tasks/$id<[^/]+>/check""")
)
                      

// @LINE:41
def users(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.users(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "users", Seq(), "GET", """""", _prefix + """debug""")
)
                      

// @LINE:37
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:39
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.register(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "register", Seq(), "POST", """""", _prefix + """signup""")
)
                      

// @LINE:12
def newTask(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newTask(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "newTask", Seq(), "POST", """""", _prefix + """tasks""")
)
                      

// @LINE:36
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:32
def get_logging_user_id_json(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.get_logging_user_id_json(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "get_logging_user_id_json", Seq(), "GET", """""", _prefix + """logging_user_id""")
)
                      

// @LINE:14
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Seq(), "GET", """""", _prefix + """registered""")
)
                      

}
                          
}
        
    