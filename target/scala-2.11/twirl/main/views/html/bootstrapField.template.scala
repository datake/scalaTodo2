
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
object bootstrapField extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[views.html.helper.FieldElements,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(elements: views.html.helper.FieldElements):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.api.i18n._
import views.html.helper._

Seq[Any](format.raw/*1.45*/("""
 
"""),format.raw/*5.1*/(""" 
"""),format.raw/*6.1*/("""<div class="control-group """),_display_(/*6.28*/elements/*6.36*/.args.get('_class)),format.raw/*6.54*/(""" """),_display_(/*6.56*/if(elements.hasErrors)/*6.78*/ {_display_(Seq[Any](format.raw/*6.80*/("""error""")))}),format.raw/*6.86*/("""" id=""""),_display_(/*6.93*/elements/*6.101*/.args.get('_id).getOrElse(elements.id + "_field")),format.raw/*6.150*/("""">
    <label class="control-label" for=""""),_display_(/*7.40*/elements/*7.48*/.id),format.raw/*7.51*/("""">"""),_display_(/*7.54*/elements/*7.62*/.label(elements.lang)),format.raw/*7.83*/("""</label>
    <div class="controls">
        """),_display_(/*9.10*/elements/*9.18*/.input),format.raw/*9.24*/("""
        """),_display_(/*10.10*/if(elements.errors.length > 0)/*10.40*/ {_display_(Seq[Any](format.raw/*10.42*/("""<span class="help-inline">"""),_display_(/*10.69*/elements/*10.77*/.errors(elements.lang).mkString(", ")),format.raw/*10.114*/("""</span>""")))}),format.raw/*10.122*/("""
        """),_display_(/*11.10*/if(elements.infos.length > 0)/*11.39*/ {_display_(Seq[Any](format.raw/*11.41*/("""<p class="help-block">"""),_display_(/*11.64*/elements/*11.72*/.infos(elements.lang).mkString(", ")),format.raw/*11.108*/("""</p>""")))}),format.raw/*11.113*/("""
    """),format.raw/*12.5*/("""</div>
</div>"""))}
  }

  def render(elements:views.html.helper.FieldElements): play.twirl.api.HtmlFormat.Appendable = apply(elements)

  def f:((views.html.helper.FieldElements) => play.twirl.api.HtmlFormat.Appendable) = (elements) => apply(elements)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Dec 25 11:22:01 JST 2014
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/bootstrapField.scala.html
                  HASH: a0a6071ec1ceee76e6d028c71c79a26e42d46542
                  MATRIX: 539->1|719->44|748->99|776->101|829->128|845->136|883->154|911->156|941->178|980->180|1016->186|1049->193|1066->201|1136->250|1204->292|1220->300|1243->303|1272->306|1288->314|1329->335|1400->380|1416->388|1442->394|1479->404|1518->434|1558->436|1612->463|1629->471|1688->508|1728->516|1765->526|1803->555|1843->557|1893->580|1910->588|1968->624|2005->629|2037->634
                  LINES: 19->1|23->1|25->5|26->6|26->6|26->6|26->6|26->6|26->6|26->6|26->6|26->6|26->6|26->6|27->7|27->7|27->7|27->7|27->7|27->7|29->9|29->9|29->9|30->10|30->10|30->10|30->10|30->10|30->10|30->10|31->11|31->11|31->11|31->11|31->11|31->11|31->11|32->12
                  -- GENERATED --
              */
          