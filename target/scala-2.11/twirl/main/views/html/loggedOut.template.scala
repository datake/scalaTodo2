
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
object loggedOut extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""<!-- [at](title: String)(content: Html)
     
    [at]main(title)(content) """),format.raw/*3.30*/("""{"""),format.raw/*3.31*/("""
    """),format.raw/*4.5*/("""<li><a href="/register">Register</a></li>
    <li><a href="/login">Login</a></li>
    """),format.raw/*6.5*/("""}"""),format.raw/*6.6*/("""-->"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 05 17:48:11 JST 2015
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/loggedOut.scala.html
                  HASH: d003f6d25931028fce0411a4616b44332f760f3d
                  MATRIX: 584->3|686->78|714->79|745->84|857->170|884->171
                  LINES: 22->1|24->3|24->3|25->4|27->6|27->6
                  -- GENERATED --
              */
          