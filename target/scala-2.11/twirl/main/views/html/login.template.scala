
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
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[scala.Tuple2[String, String]],Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[(String, String)])(implicit flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import views.BootstrapHelper._

Seq[Any](format.raw/*1.55*/("""

"""),format.raw/*4.1*/("""
   
    """),_display_(/*6.6*/helper/*6.12*/.form(
        routes.Application.authenticate,
        'class -> "form-horizontal"
    )/*9.6*/ {_display_(Seq[Any](format.raw/*9.8*/("""
        """),format.raw/*10.9*/("""<fieldset>
            """),_display_(/*11.14*/if(form.hasErrors)/*11.32*/ {_display_(Seq[Any](format.raw/*11.34*/("""
                """),format.raw/*12.17*/("""<div class="alert alert-block alert-error">
                    There are problems.
                </div>
            """)))}),format.raw/*15.14*/("""

            """),_display_(/*17.14*/flash/*17.19*/.get("success").map/*17.38*/ { message =>_display_(Seq[Any](format.raw/*17.51*/("""
                """),format.raw/*18.17*/("""<div class="alert alert-block alert-info">
                    """),_display_(/*19.22*/message),format.raw/*19.29*/("""
                """),format.raw/*20.17*/("""</div>
            """)))}),format.raw/*21.14*/("""

            """),_display_(/*23.14*/helper/*23.20*/.inputText(
                form("email"),
                'type -> "email",
                'placeholder -> "john@example.com",
                '_label -> "Email Address",
                '_error -> form.globalError
            )),format.raw/*29.14*/("""
            """),_display_(/*30.14*/helper/*30.20*/.inputPassword(
                form("password"),
                'placeholder -> "secret",
                '_label -> "Passowrd",
                '_error -> form.globalError
            )),format.raw/*35.14*/("""
            """),format.raw/*36.13*/("""<div class="control-group">
                <div class="controls">
                    <button type="submit" id="loginbutton" class="btn">Login</button>
                </div>
            </div>
        """)))}),format.raw/*41.10*/("""
    """),format.raw/*42.5*/("""</fieldset>

    <div class="well well-small">
        Don't you have an account? <a href=""""),_display_(/*45.46*/routes/*45.52*/.Application.signup),format.raw/*45.71*/("""">Let's sign up here</a>.
    </div>
"""))}
  }

  def render(form:Form[scala.Tuple2[String, String]],flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(form)(flash)

  def f:((Form[scala.Tuple2[String, String]]) => (Flash) => play.twirl.api.HtmlFormat.Appendable) = (form) => (flash) => apply(form)(flash)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Dec 25 14:44:15 JST 2014
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/login.scala.html
                  HASH: c806176e8c48b4a6bc3d35f8368c326154ef1ed6
                  MATRIX: 539->1|710->54|738->88|773->98|787->104|883->193|921->195|957->204|1008->228|1035->246|1075->248|1120->265|1271->385|1313->400|1327->405|1355->424|1406->437|1451->454|1542->518|1570->525|1615->542|1666->562|1708->577|1723->583|1974->813|2015->827|2030->833|2239->1021|2280->1034|2515->1238|2547->1243|2666->1335|2681->1341|2721->1360
                  LINES: 19->1|22->1|24->4|26->6|26->6|29->9|29->9|30->10|31->11|31->11|31->11|32->12|35->15|37->17|37->17|37->17|37->17|38->18|39->19|39->19|40->20|41->21|43->23|43->23|49->29|50->30|50->30|55->35|56->36|61->41|62->42|65->45|65->45|65->45
                  -- GENERATED --
              */
          