
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object signup extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[scala.Tuple3[String, String, scala.Tuple2[String, String]]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[(String, String, (String, String))]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.BootstrapHelper._

Seq[Any](format.raw/*1.50*/("""

"""),format.raw/*4.1*/("""
    """),format.raw/*5.5*/("""<legend>Sign up</legend>
    """),_display_(/*6.6*/helper/*6.12*/.form(
        routes.Application.register,
        'class -> "form-horizontal"
    )/*9.6*/ {_display_(Seq[Any](format.raw/*9.8*/("""
        """),format.raw/*10.9*/("""<fieldset>
            """),_display_(/*11.14*/if(form.hasErrors)/*11.32*/ {_display_(Seq[Any](format.raw/*11.34*/("""
                """),format.raw/*12.17*/("""<div class="alert alert-block alert-error">
                    There are problems.
                </div>
            """)))}),format.raw/*15.14*/("""

            """),_display_(/*17.14*/helper/*17.20*/.inputText(
                form("email"),
                'type -> "email",
                'placeholder -> "john@example.com",
                '_label -> "Email Address",
                '_help -> "This is used for your login.",
                '_error -> form.error("email")
            )),format.raw/*24.14*/("""
            """),_display_(/*25.14*/helper/*25.20*/.inputText(
                form("name"),
                'placeholder -> "John Smith",
                '_label -> "Your name"
            )),format.raw/*29.14*/("""
            """),_display_(/*30.14*/helper/*30.20*/.inputPassword(
                form("password.main"),
                'placeholder -> "secret",
                '_label -> "Passowrd",
                '_error -> form.error("password")
            )),format.raw/*35.14*/("""
            """),_display_(/*36.14*/helper/*36.20*/.inputPassword(
                form("password.confirm"),
                'placeholder -> "secret",
                '_label -> "Confirm password",
                '_help -> "Input password again."
            )),format.raw/*41.14*/("""
            """),format.raw/*42.13*/("""<div class="control-group">
                <div class="controls">
                    <button type="submit" id="signupbutton" class="btn">Create an account</button>
                </div>
            </div>
        </fieldset>
    """)))}),format.raw/*48.6*/("""
"""))}
  }

  def render(form:Form[scala.Tuple3[String, String, scala.Tuple2[String, String]]]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[scala.Tuple3[String, String, scala.Tuple2[String, String]]]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 05 21:36:53 JST 2015
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/signup.scala.html
                  HASH: 9beb44aafcc957dbcc69f5c03443f81f46dceb83
                  MATRIX: 564->1|730->49|758->83|789->88|844->118|858->124|950->209|988->211|1024->220|1075->244|1102->262|1142->264|1187->281|1338->401|1380->416|1395->422|1707->713|1748->727|1763->733|1924->873|1965->887|1980->893|2200->1092|2241->1106|2256->1112|2487->1322|2528->1335|2791->1568
                  LINES: 19->1|22->1|24->4|25->5|26->6|26->6|29->9|29->9|30->10|31->11|31->11|31->11|32->12|35->15|37->17|37->17|44->24|45->25|45->25|49->29|50->30|50->30|55->35|56->36|56->36|61->41|62->42|68->48
                  -- GENERATED --
              */
          