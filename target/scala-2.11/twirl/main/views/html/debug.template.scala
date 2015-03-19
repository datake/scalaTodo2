
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
import models._
/**/
object debug extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[Task],Seq[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(tasks: List[Task],users: Seq[User]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*3.38*/("""

 
   """),format.raw/*6.4*/("""<h1>debug</h1>


 
  <h2>Users</h2>
  """),_display_(/*11.4*/users/*11.9*/.map/*11.13*/ { u =>_display_(Seq[Any](format.raw/*11.20*/("""
     """),_display_(/*12.7*/u/*12.8*/.email),format.raw/*12.14*/("""<br>"""),_display_(/*12.19*/u/*12.20*/.name),format.raw/*12.25*/("""<br>"""),_display_(/*12.30*/u/*12.31*/.password),format.raw/*12.40*/("""<br>users<br>
    """)))}),format.raw/*13.6*/("""

"""),format.raw/*15.1*/("""<h2>Tasks</h2>
"""),_display_(/*16.2*/tasks/*16.7*/.map/*16.11*/ { t =>_display_(Seq[Any](format.raw/*16.18*/("""
     """),_display_(/*17.7*/t/*17.8*/.id),format.raw/*17.11*/(""":"""),_display_(/*17.13*/t/*17.14*/.label),format.raw/*17.20*/(""":"""),_display_(/*17.22*/t/*17.23*/.progress),format.raw/*17.32*/(""":"""),_display_(/*17.34*/t/*17.35*/.target),format.raw/*17.42*/("""<br>
    """)))}),format.raw/*18.6*/("""
"""))}
  }

  def render(tasks:List[Task],users:Seq[User]): play.twirl.api.HtmlFormat.Appendable = apply(tasks,users)

  def f:((List[Task],Seq[User]) => play.twirl.api.HtmlFormat.Appendable) = (tasks,users) => apply(tasks,users)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 05 19:59:02 JST 2015
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/debug.scala.html
                  HASH: 6473de70ff437cbbf5dc666de538e11c969869b5
                  MATRIX: 534->20|658->56|691->63|756->102|769->107|782->111|827->118|860->125|869->126|896->132|928->137|938->138|964->143|996->148|1006->149|1036->158|1085->177|1114->179|1156->195|1169->200|1182->204|1227->211|1260->218|1269->219|1293->222|1322->224|1332->225|1359->231|1388->233|1398->234|1428->243|1457->245|1467->246|1495->253|1535->263
                  LINES: 19->3|22->3|25->6|30->11|30->11|30->11|30->11|31->12|31->12|31->12|31->12|31->12|31->12|31->12|31->12|31->12|32->13|34->15|35->16|35->16|35->16|35->16|36->17|36->17|36->17|36->17|36->17|36->17|36->17|36->17|36->17|36->17|36->17|36->17|37->18
                  -- GENERATED --
              */
          