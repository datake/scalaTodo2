// @SOURCE:/home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/conf/routes
// @HASH:1832fdc2fd4feac8b2f31c14d29ee307008f4122
// @DATE:Sat Jan 17 13:14:51 JST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:10
private[this] lazy val controllers_Application_tasks1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks"))))
private[this] lazy val controllers_Application_tasks1_invoker = createInvoker(
controllers.Application.tasks,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "tasks", Nil,"GET", """ Tasks""", Routes.prefix + """tasks"""))
        

// @LINE:11
private[this] lazy val controllers_Application_modal2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("modal"))))
private[this] lazy val controllers_Application_modal2_invoker = createInvoker(
controllers.Application.modal,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "modal", Nil,"GET", """""", Routes.prefix + """modal"""))
        

// @LINE:12
private[this] lazy val controllers_Application_newTask3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks"))))
private[this] lazy val controllers_Application_newTask3_invoker = createInvoker(
controllers.Application.newTask(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "newTask", Nil,"POST", """""", Routes.prefix + """tasks"""))
        

// @LINE:14
private[this] lazy val controllers_Application_login4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registered"))))
private[this] lazy val controllers_Application_login4_invoker = createInvoker(
controllers.Application.login,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """registered"""))
        

// @LINE:17
private[this] lazy val controllers_Application_deleteTask5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Application_deleteTask5_invoker = createInvoker(
controllers.Application.deleteTask(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteTask", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tasks/$id<[^/]+>/delete"""))
        

// @LINE:19
private[this] lazy val controllers_Application_updateTask6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks/"),DynamicPart("id", """[^/]+""",true),StaticPart("/update"))))
private[this] lazy val controllers_Application_updateTask6_invoker = createInvoker(
controllers.Application.updateTask(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "updateTask", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tasks/$id<[^/]+>/update"""))
        

// @LINE:21
private[this] lazy val controllers_Application_changeDate7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks/"),DynamicPart("id", """[^/]+""",true),StaticPart("/changeDate"))))
private[this] lazy val controllers_Application_changeDate7_invoker = createInvoker(
controllers.Application.changeDate(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "changeDate", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tasks/$id<[^/]+>/changeDate"""))
        

// @LINE:24
private[this] lazy val controllers_Application_checkTask8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks/"),DynamicPart("id", """[^/]+""",true),StaticPart("/check"))))
private[this] lazy val controllers_Application_checkTask8_invoker = createInvoker(
controllers.Application.checkTask(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "checkTask", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tasks/$id<[^/]+>/check"""))
        

// @LINE:26
private[this] lazy val controllers_Application_uncheckTask9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tasks/"),DynamicPart("id", """[^/]+""",true),StaticPart("/uncheck"))))
private[this] lazy val controllers_Application_uncheckTask9_invoker = createInvoker(
controllers.Application.uncheckTask(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "uncheckTask", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tasks/$id<[^/]+>/uncheck"""))
        

// @LINE:31
private[this] lazy val controllers_Application_getjson10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api"))))
private[this] lazy val controllers_Application_getjson10_invoker = createInvoker(
controllers.Application.getjson,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getjson", Nil,"GET", """""", Routes.prefix + """api"""))
        

// @LINE:32
private[this] lazy val controllers_Application_get_logging_user_id_json11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logging_user_id"))))
private[this] lazy val controllers_Application_get_logging_user_id_json11_invoker = createInvoker(
controllers.Application.get_logging_user_id_json,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "get_logging_user_id_json", Nil,"GET", """""", Routes.prefix + """logging_user_id"""))
        

// @LINE:35
private[this] lazy val controllers_Application_login12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_login12_invoker = createInvoker(
controllers.Application.login,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Nil,"GET", """ Authentication""", Routes.prefix + """login"""))
        

// @LINE:36
private[this] lazy val controllers_Application_authenticate13_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_authenticate13_invoker = createInvoker(
controllers.Application.authenticate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
        

// @LINE:37
private[this] lazy val controllers_Application_logout14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_Application_logout14_invoker = createInvoker(
controllers.Application.logout,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:38
private[this] lazy val controllers_Application_signup15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
private[this] lazy val controllers_Application_signup15_invoker = createInvoker(
controllers.Application.signup,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "signup", Nil,"GET", """""", Routes.prefix + """signup"""))
        

// @LINE:39
private[this] lazy val controllers_Application_register16_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
private[this] lazy val controllers_Application_register16_invoker = createInvoker(
controllers.Application.register,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "register", Nil,"POST", """""", Routes.prefix + """signup"""))
        

// @LINE:41
private[this] lazy val controllers_Application_users17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("debug"))))
private[this] lazy val controllers_Application_users17_invoker = createInvoker(
controllers.Application.users,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "users", Nil,"GET", """""", Routes.prefix + """debug"""))
        

// @LINE:47
private[this] lazy val controllers_Assets_at18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at18_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks""","""controllers.Application.tasks"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """modal""","""controllers.Application.modal"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks""","""controllers.Application.newTask()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registered""","""controllers.Application.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks/$id<[^/]+>/delete""","""controllers.Application.deleteTask(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks/$id<[^/]+>/update""","""controllers.Application.updateTask(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks/$id<[^/]+>/changeDate""","""controllers.Application.changeDate(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks/$id<[^/]+>/check""","""controllers.Application.checkTask(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tasks/$id<[^/]+>/uncheck""","""controllers.Application.uncheckTask(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api""","""controllers.Application.getjson"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logging_user_id""","""controllers.Application.get_logging_user_id_json"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Application.signup"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Application.register"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """debug""","""controllers.Application.users"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:10
case controllers_Application_tasks1_route(params) => {
   call { 
        controllers_Application_tasks1_invoker.call(controllers.Application.tasks)
   }
}
        

// @LINE:11
case controllers_Application_modal2_route(params) => {
   call { 
        controllers_Application_modal2_invoker.call(controllers.Application.modal)
   }
}
        

// @LINE:12
case controllers_Application_newTask3_route(params) => {
   call { 
        controllers_Application_newTask3_invoker.call(controllers.Application.newTask())
   }
}
        

// @LINE:14
case controllers_Application_login4_route(params) => {
   call { 
        controllers_Application_login4_invoker.call(controllers.Application.login)
   }
}
        

// @LINE:17
case controllers_Application_deleteTask5_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_deleteTask5_invoker.call(controllers.Application.deleteTask(id))
   }
}
        

// @LINE:19
case controllers_Application_updateTask6_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_updateTask6_invoker.call(controllers.Application.updateTask(id))
   }
}
        

// @LINE:21
case controllers_Application_changeDate7_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_changeDate7_invoker.call(controllers.Application.changeDate(id))
   }
}
        

// @LINE:24
case controllers_Application_checkTask8_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_checkTask8_invoker.call(controllers.Application.checkTask(id))
   }
}
        

// @LINE:26
case controllers_Application_uncheckTask9_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_uncheckTask9_invoker.call(controllers.Application.uncheckTask(id))
   }
}
        

// @LINE:31
case controllers_Application_getjson10_route(params) => {
   call { 
        controllers_Application_getjson10_invoker.call(controllers.Application.getjson)
   }
}
        

// @LINE:32
case controllers_Application_get_logging_user_id_json11_route(params) => {
   call { 
        controllers_Application_get_logging_user_id_json11_invoker.call(controllers.Application.get_logging_user_id_json)
   }
}
        

// @LINE:35
case controllers_Application_login12_route(params) => {
   call { 
        controllers_Application_login12_invoker.call(controllers.Application.login)
   }
}
        

// @LINE:36
case controllers_Application_authenticate13_route(params) => {
   call { 
        controllers_Application_authenticate13_invoker.call(controllers.Application.authenticate)
   }
}
        

// @LINE:37
case controllers_Application_logout14_route(params) => {
   call { 
        controllers_Application_logout14_invoker.call(controllers.Application.logout)
   }
}
        

// @LINE:38
case controllers_Application_signup15_route(params) => {
   call { 
        controllers_Application_signup15_invoker.call(controllers.Application.signup)
   }
}
        

// @LINE:39
case controllers_Application_register16_route(params) => {
   call { 
        controllers_Application_register16_invoker.call(controllers.Application.register)
   }
}
        

// @LINE:41
case controllers_Application_users17_route(params) => {
   call { 
        controllers_Application_users17_invoker.call(controllers.Application.users)
   }
}
        

// @LINE:47
case controllers_Assets_at18_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at18_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     