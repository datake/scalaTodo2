
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
object registered extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.BootstrapHelper._

Seq[Any](format.raw/*1.14*/("""

"""),format.raw/*4.1*/("""<!--mainはcontent,headerから構成.以下header部分-->
    <legend>"Registration complete!"</legend>

    <dl class="dl-horizontal">
      <dt>Email Address</dt>
      <dd>"""),_display_(/*9.12*/user/*9.16*/.email),format.raw/*9.22*/("""</dd>
    </dl>
    <dl class="dl-horizontal">
      <dt>Your name</dt>
      <dd>"""),_display_(/*13.12*/user/*13.16*/.name),format.raw/*13.21*/("""</dd>
    </dl>

    <div class="well well-small">
         <a href=""""),_display_(/*17.20*/routes/*17.26*/.Application.login),format.raw/*17.44*/("""">login</a>
         <a href=""""),_display_(/*18.20*/routes/*18.26*/.Application.tasks),format.raw/*18.44*/("""">HOME</a>
        <a href=""""),_display_(/*19.19*/routes/*19.25*/.Application.logout),format.raw/*19.44*/("""">logout</a>
    </div>
"""))}
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jan 06 16:34:35 JST 2015
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/registered.scala.html
                  HASH: 66a84654ffde95cb845fec4a4b7fd4faf9167310
                  MATRIX: 508->1|638->13|666->47|852->207|864->211|890->217|1000->300|1013->304|1039->309|1136->379|1151->385|1190->403|1248->434|1263->440|1302->458|1358->487|1373->493|1413->512
                  LINES: 19->1|22->1|24->4|29->9|29->9|29->9|33->13|33->13|33->13|37->17|37->17|37->17|38->18|38->18|38->18|39->19|39->19|39->19
                  -- GENERATED --
              */
          