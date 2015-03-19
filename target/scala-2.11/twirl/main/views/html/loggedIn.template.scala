
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
object loggedIn extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""<!-- [at](title: String)(content: Html)
     
    [at]main(title)(content) """),format.raw/*3.30*/("""{"""),format.raw/*3.31*/("""
    """),format.raw/*4.5*/("""<li class="current"><a href="/logout">Logout</a></li>
    """),format.raw/*5.5*/("""}"""),format.raw/*5.6*/("""-->"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 05 17:48:42 JST 2015
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/loggedIn.scala.html
                  HASH: 392805e870dc0cfd7e980c04619978d973d78e88
                  MATRIX: 583->3|685->78|713->79|744->84|828->142|855->143
                  LINES: 22->1|24->3|24->3|25->4|26->5|26->5
                  -- GENERATED --
              */
          