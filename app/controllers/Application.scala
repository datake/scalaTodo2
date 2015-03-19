package controllers

import play.api._
import play.api.mvc._


// Required for form helpers
import play.api.data._
import play.api.data.Forms._

// Required to be able to import model definitions
import models._
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date

object Application extends Controller with Secured{
  val taskForm = Form (tuple(
    "label" -> nonEmptyText,
    "target"->nonEmptyText,
   "user_id"->nonEmptyText)
  )
 /* val gitlogForm = Form (tuple(
    "label" -> nonEmptyText,
    "target"->nonEmptyText,
   "user_id"->nonEmptyText)
  )*/
      def index =IsAuthenticated { email => _ =>
      Redirect(routes.Application.tasks)
    }
     def tasks =  IsAuthenticated { email => _ =>
    Ok(views.html.index(Task.all(), taskForm))
   }
    /*def gitlogs =  IsAuthenticated { email => _ =>
    Ok(views.html.index(Task.all(), taskForm))
   }*/

   def users = Action {
     Ok(views.html.debug(Task.all(),User.findAll))
   }
  def user_id_logged_in()= IsAuthenticated { email => implicit request =>
     val user_id=User.findIdByEmail(email)
     Ok
  }


  //Add new Task
  //def newTask() = Action { implicit request =>
     def newTask() = IsAuthenticated { email => implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.debug(Task.all(),User.findAll)),
     // errors => BadRequest(views.html.index(Task.all(), errors)),
      { case (label ,target,user_id)=> 
        println(target);
        //val user_id=User.getUserID(email)
       //val user_id=User.findIdByEmail(email).get
       val user_id=User.findIdByEmail(email).get
           println("email"+email);
          // val date_today=new Date(new SimpleDateFormat("yyyy-MM-dd").format(new Date) )
         //   println("date_today:"+date_today)
         //val date_today: Date = new Date()
         //val date_today_Str = date_today.toString()
         val date_today = new java.text.SimpleDateFormat("yyyy-MM-dd")
         val date_today_Str=date_today.format(new java.util.Date())

         //date_today_Strは例えば2015-01-01というstring型
        //Task.create(label,new Date(new SimpleDateFormat("yyyy-MM-dd").parse(target).getTime()),user_id,date_today)
        Task.create(label,new Date(new SimpleDateFormat("yyyy-MM-dd").parse(target).getTime()),user_id,new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date_today_Str).getTime()))
        Redirect(routes.Application.tasks)
      }
      )
  }
  //delete task
  def deleteTask(id: Long) = Action { implicit request =>
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }

  /*JSON {"label": "raberu"}*/
  /*Form <input type="text" name="label" xvalue="raberu"> */

  def updateTask(id: Long) = IsAuthenticated { email => implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest,
       {case (label,target,user_id) => //JSON
        println("Application.scala/updateTask")
         val user_id=User.findIdByEmail(email).get
       Task.update(id, label,user_id)
       Ok
     }
     )
  }

  def changeDate(id: Long) = IsAuthenticated { email => implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest,
       {case (label,target,user_id) => //JSON
        println("Application.scala/changeDate")
         val user_id=User.findIdByEmail(email).get
         val target_Date=new Date(new SimpleDateFormat("yyyy-MM-dd").parse(target).getTime())//java.util.Date
       Task.changeDate(id, target_Date,user_id)
       Ok
     }
     )
  }

  def checkTask(id: Long) = Action { implicit request =>
    Task.check(id)
    Redirect(routes.Application.tasks)
  }

  def uncheckTask(id: Long) = Action { implicit request =>
    Task.uncheck(id)
    Redirect(routes.Application.tasks)
  }

  //return json todo data
  def getjson= Action { implicit request =>
    import play.api.libs.json._
       
       // println(Task.all())
        //println(User.findAll())

        /*
         * When list of tasks coming, .map and Json.obj
         * translate Tasks to list of JSON values
         * the following jsSeq represents
         * [{
         *    "label" : t.label,
         *    "progress" : t.progress
         * }, ...]
         * but actual type of these values are List[JsValue]
         * which can be translated to JSON String by Json.toJson
         */
         val jsSeq = Json.toJson(Task.all().map(t => 
          /*
           * {
           *  "label": t.label,
           *   "progress": t.progress
           *  }
           */
           Json.obj(
            "label" -> t.label,
            "progress" -> t.progress,
            "id"->t.id,
            "target"->new SimpleDateFormat("yyyy-MM-dd").format(t.target),
            "user_id"->t.user_id,
             "created"->new SimpleDateFormat("yyyy-MM-dd").format(t.created)
            )
           ))/*(Writes.traversableWrites[JsValue])*/
       Ok(jsSeq);
     }

  def get_logging_user_id_json=IsAuthenticated { email => implicit request =>
    import play.api.libs.json._
        val user_logging_in=User.findByEmail(email)
        println(user_logging_in)
         val jsSeq = Json.toJson(user_logging_in.map(t => 
           Json.obj(//user_id:Long,email: String, name: String, password: String
            "user_id" -> t.user_id,
            "email" -> t.email,
            "name"->t.name,
            "password"->t.password
            )
           ))
       Ok(jsSeq);
     }
//login
val loginForm = Form(
  tuple(
    "email" -> nonEmptyText,
    "password" -> nonEmptyText
    ) verifying ("Invalid email or password", result => result match {
      case (email, password) => User.authenticate(email, password).isDefined
      })
    )

  // ログインページ
  def login = Action { implicit request =>
   Ok(views.html.login(loginForm))
}
   def modal = Action { implicit request =>
   Ok(views.html.modal())
}

  // ユーザ認証
  def authenticate = Action { implicit request =>
    loginForm.bindFromRequest.fold(
     formWithErrors => BadRequest(views.html.login(formWithErrors)), 
     user => Redirect(routes.Application.tasks).withSession("email" -> user._1)
     )
  }

  // ログアウト
  def logout = Action {
    Redirect(routes.Application.login).withNewSession.flashing(
      "success" -> "You've been logged out"
      )
  }

  // 登録フォーム
  val signupForm = Form(
    tuple(
      //"user_id" ,
      "email" -> nonEmptyText.verifying(
        "This email address is already registered.",
        email => User.findByEmail(email).isEmpty
        ),
      "name" -> nonEmptyText,
      "password" -> tuple(
        "main" -> nonEmptyText,
        "confirm" -> nonEmptyText
        ).verifying(
        "Password is not match.",
        password => password._1 == password._2
        )
        )
    )

  // ユーザ登録ページ
  def signup = Action {

    Ok(views.html.signup(signupForm))
  }

  // ユーザ登録
  def register = Action { implicit request =>
    //signupのフォーム
    signupForm.bindFromRequest.fold(
      errors => BadRequest(views.html.signup(errors)),
      form => {
        val user = User(999,form._1, form._2,form._3._1)
        User.create(user)
        println("user created")
        Ok(views.html.registered(user))

      }
      )
  }



}