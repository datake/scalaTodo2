
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(header: Html)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.31*/("""

"""),format.raw/*3.1*/("""<html lang="ja" ng-app="myApp">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Angularの練習</title>


  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>-->
  <!--load jquery before load bootstrap-->


  <script type="text/javascript" src=""""),_display_(/*14.40*/routes/*14.46*/.Assets.at("bower_components/jquery/dist/jquery.js")),format.raw/*14.98*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*15.40*/routes/*15.46*/.Assets.at("bower_components/jquery-ui/ui/jquery-ui.js")),format.raw/*15.102*/(""""></script>

  <!--bootstrap,bootstrap-datetimepicker-->
  <script src=""""),_display_(/*18.17*/routes/*18.23*/.Assets.at("bower_components/bootstrap/docs/assets/js/bootstrap.js")),format.raw/*18.91*/(""""></script>
  <script src=""""),_display_(/*19.17*/routes/*19.23*/.Assets.at("bower_components/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js")),format.raw/*19.119*/(""""></script>
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
  <link href=""""),_display_(/*21.16*/routes/*21.22*/.Assets.at("bower_components/bootstrap/docs/assets/css/bootstrap.css")),format.raw/*21.92*/("""" rel="stylesheet" media="screen" >
  <link href=""""),_display_(/*22.16*/routes/*22.22*/.Assets.at("bower_components/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css")),format.raw/*22.120*/("""" rel="stylesheet" media="screen" >

  <!--angular,angular-ui-calendar,fullcalendar,angular-animate,calendar-->
  <script type="text/javascript" src=""""),_display_(/*25.40*/routes/*25.46*/.Assets.at("bower_components/angular/angular.js")),format.raw/*25.95*/(""""></script>
  <script type="text/javascript"src=""""),_display_(/*26.39*/routes/*26.45*/.Assets.at("bower_components/angular-bootstrap/ui-bootstrap-tpls.js")),format.raw/*26.114*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*27.40*/routes/*27.46*/.Assets.at("bower_components/angular-ui-calendar/src/calendar.js")),format.raw/*27.112*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*28.40*/routes/*28.46*/.Assets.at("bower_components/fullcalendar/fullcalendar.js")),format.raw/*28.105*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*29.40*/routes/*29.46*/.Assets.at("bower_components/fullcalendar/gcal.js")),format.raw/*29.97*/(""""></script>
  <script type="text/javascript" src=""""),_display_(/*30.40*/routes/*30.46*/.Assets.at("bower_components/angular-animate/angular-animate.js")),format.raw/*30.111*/(""""></script>

  <!--ngDialog-->
  <script type="text/javascript" src=""""),_display_(/*33.40*/routes/*33.46*/.Assets.at("bower_components/ngDialog/js/ngDialog.js")),format.raw/*33.100*/(""""></script>
<link href=""""),_display_(/*34.14*/routes/*34.20*/.Assets.at("bower_components/ngDialog/css/ngDialog.css")),format.raw/*34.76*/("""" rel="stylesheet" media="screen" >
<link href=""""),_display_(/*35.14*/routes/*35.20*/.Assets.at("bower_components/ngDialog/css/ngDialog-theme-default.css")),format.raw/*35.90*/("""" rel="stylesheet" media="screen" >

<!--Angular charts-->
<!--<script type='text/javascript' src=""""),_display_(/*38.42*/routes/*38.48*/.Assets.at("bower_components/angular/angular.min.js")),format.raw/*38.101*/(""""></script>
<script type='text/javascript' src=""""),_display_(/*39.38*/routes/*39.44*/.Assets.at("bower_components/d3/d3.min.js")),format.raw/*39.87*/(""""></script> 
<script type='text/javascript' src=""""),_display_(/*40.38*/routes/*40.44*/.Assets.at("bower_components/angular-charts/dist/angular-charts.js")),format.raw/*40.112*/(""""></script>-->

<!--angular-chart.js-->
<!--
<script src=""""),_display_(/*44.15*/routes/*44.21*/.Assets.at("bower_components/Chart.js/Chart.min.js")),format.raw/*44.73*/(""""></script>
<script src=""""),_display_(/*45.15*/routes/*45.21*/.Assets.at("bower_components/angular-chart.js/dist/angular-chart.js")),format.raw/*45.90*/(""""></script>
<link rel="stylesheet" href=""""),_display_(/*46.31*/routes/*46.37*/.Assets.at("bower_components/angular-chart.js/dist/angular-chart.css")),format.raw/*46.107*/("""">
 -->
 <!--angular google chart-->
 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
 <!--angular-google-hcart-->
 <script src=""""),_display_(/*51.16*/routes/*51.22*/.Assets.at("bower_components/angular-google-chart/ng-google-chart.js")),format.raw/*51.92*/(""""></script>
 
<!--ng-sortable-->
 
   
<script src=""""),_display_(/*56.15*/routes/*56.21*/.Assets.at("bower_components/ng-sortable/dist/ng-sortable.js")),format.raw/*56.83*/(""""></script>
<link rel="stylesheet" href=""""),_display_(/*57.31*/routes/*57.37*/.Assets.at("bower_components/ng-sortable/dist/ng-sortable.css")),format.raw/*57.100*/("""" media="screen" />


  <script src=""""),_display_(/*60.17*/routes/*60.23*/.Assets.at("javascripts/app/myscript.js")),format.raw/*60.64*/("""">  </script>
   <script src=""""),_display_(/*61.18*/routes/*61.24*/.Assets.at("javascripts/app/mychart.js")),format.raw/*61.64*/("""">  </script>


  <!--
  <script src=""""),_display_(/*65.17*/routes/*65.23*/.Assets.at("javascripts/app/factory.js")),format.raw/*65.63*/("""">  </script>
   <script src=""""),_display_(/*66.18*/routes/*66.24*/.Assets.at("javascripts/app/mainCtrl.js")),format.raw/*66.65*/("""">  </script>
   <script src=""""),_display_(/*67.18*/routes/*67.24*/.Assets.at("javascripts/app/calendarCtrl.js")),format.raw/*67.69*/("""">  </script>
  -->
  
  <link rel="stylesheet" href=""""),_display_(/*70.33*/routes/*70.39*/.Assets.at("bower_components/fullcalendar/fullcalendar.css")),format.raw/*70.99*/("""" media="screen" />


  <style>
  h2 """),format.raw/*74.6*/("""{"""),format.raw/*74.7*/("""
    """),format.raw/*75.5*/("""background-color: #D3EDFB;
  """),format.raw/*76.3*/("""}"""),format.raw/*76.4*/("""

  """),format.raw/*78.3*/(""".progress-true,.progress-1 """),format.raw/*78.30*/("""{"""),format.raw/*78.31*/("""
    """),format.raw/*79.5*/("""color:gray;
    text-decoration:line-through;
  """),format.raw/*81.3*/("""}"""),format.raw/*81.4*/("""

  """),format.raw/*83.3*/(""".progress_tasks h2 """),format.raw/*83.22*/("""{"""),format.raw/*83.23*/("""
    """),format.raw/*84.5*/("""margin: 20px 0 0 0;
    background: #D3EDFB;
    font-size: 14px;
    padding: 5px 0 5px 7px;
    border-radius:5px 5px 0 0; 
  """),format.raw/*89.3*/("""}"""),format.raw/*89.4*/("""

  """),format.raw/*91.3*/(""".progress_tasks ul """),format.raw/*91.22*/("""{"""),format.raw/*91.23*/("""
    """),format.raw/*92.5*/("""list-style: none;
    margin: 0;
    padding: 3px 0 3px 5px;
    font-size: 12px;
    border: #ddd solid 1px;
  """),format.raw/*97.3*/("""}"""),format.raw/*97.4*/("""



  """),format.raw/*101.3*/(""".check-element """),format.raw/*101.18*/("""{"""),format.raw/*101.19*/("""
    """),format.raw/*102.5*/("""style="clear:both;"
  """),format.raw/*103.3*/("""}"""),format.raw/*103.4*/("""

  """),format.raw/*105.3*/(""".animate-show-hide """),format.raw/*105.22*/("""{"""),format.raw/*105.23*/("""
    """),format.raw/*106.5*/("""padding:10px;

    background:white;
  """),format.raw/*109.3*/("""}"""),format.raw/*109.4*/("""
  """),format.raw/*110.3*/(""".animate-show-hide.ng-hide-add, .animate-show-hide.ng-hide-remove """),format.raw/*110.69*/("""{"""),format.raw/*110.70*/("""
    """),format.raw/*111.5*/("""-webkit-transition:all linear 0.5s;
    -moz-transition:all linear 0.5s;
    -o-transition:all linear 0.5s;
    transition:all linear 0.5s;
    display:block!important;
  """),format.raw/*116.3*/("""}"""),format.raw/*116.4*/("""


  """),format.raw/*119.3*/(""".animate-show-hide.ng-hide-add.ng-hide-add-active,
  .animate-show-hide.ng-hide-remove """),format.raw/*120.37*/("""{"""),format.raw/*120.38*/("""
    """),format.raw/*121.5*/("""opacity:0;
  """),format.raw/*122.3*/("""}"""),format.raw/*122.4*/("""
  """),format.raw/*123.3*/(""".animate-show-hide.ng-hide-add,
  .animate-show-hide.ng-hide-remove.ng-hide-remove-active """),format.raw/*124.59*/("""{"""),format.raw/*124.60*/("""
    """),format.raw/*125.5*/("""opacity:1;
  """),format.raw/*126.3*/("""}"""),format.raw/*126.4*/("""













  """),format.raw/*140.3*/("""</style>
</head>
<body>
  <div data-role="page" id="home">

    """),_display_(/*145.6*/header),format.raw/*145.12*/("""
    """),_display_(/*146.6*/content),format.raw/*146.13*/("""


  """),format.raw/*149.3*/("""</div>
</body>
</html>"""))}
  }

  def render(header:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(header)(content)

  def f:((Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (header) => (content) => apply(header)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Jan 24 19:05:11 JST 2015
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/main.scala.html
                  HASH: d08e511b6486d4fd04955d4f055e772ae5bfdf2c
                  MATRIX: 507->1|624->30|652->32|1028->381|1043->387|1116->439|1194->490|1209->496|1287->552|1387->625|1402->631|1491->699|1546->727|1561->733|1679->829|1832->955|1847->961|1938->1031|2016->1082|2031->1088|2151->1186|2329->1337|2344->1343|2414->1392|2491->1442|2506->1448|2597->1517|2675->1568|2690->1574|2778->1640|2856->1691|2871->1697|2952->1756|3030->1807|3045->1813|3117->1864|3195->1915|3210->1921|3297->1986|3394->2056|3409->2062|3485->2116|3537->2141|3552->2147|3629->2203|3705->2252|3720->2258|3811->2328|3938->2428|3953->2434|4028->2487|4104->2536|4119->2542|4183->2585|4260->2635|4275->2641|4365->2709|4451->2768|4466->2774|4539->2826|4592->2852|4607->2858|4697->2927|4766->2969|4781->2975|4873->3045|5058->3203|5073->3209|5164->3279|5244->3332|5259->3338|5342->3400|5411->3442|5426->3448|5511->3511|5576->3549|5591->3555|5653->3596|5711->3627|5726->3633|5787->3673|5853->3712|5868->3718|5929->3758|5987->3789|6002->3795|6064->3836|6122->3867|6137->3873|6203->3918|6285->3973|6300->3979|6381->4039|6445->4076|6473->4077|6505->4082|6561->4111|6589->4112|6620->4116|6675->4143|6704->4144|6736->4149|6811->4197|6839->4198|6870->4202|6917->4221|6946->4222|6978->4227|7133->4355|7161->4356|7192->4360|7239->4379|7268->4380|7300->4385|7439->4497|7467->4498|7501->4504|7545->4519|7575->4520|7608->4525|7658->4547|7687->4548|7719->4552|7767->4571|7797->4572|7830->4577|7897->4616|7926->4617|7957->4620|8052->4686|8082->4687|8115->4692|8314->4863|8343->4864|8376->4869|8492->4956|8522->4957|8555->4962|8596->4975|8625->4976|8656->4979|8775->5069|8805->5070|8838->5075|8879->5088|8908->5089|8952->5105|9044->5170|9072->5176|9105->5182|9134->5189|9167->5194
                  LINES: 19->1|22->1|24->3|35->14|35->14|35->14|36->15|36->15|36->15|39->18|39->18|39->18|40->19|40->19|40->19|42->21|42->21|42->21|43->22|43->22|43->22|46->25|46->25|46->25|47->26|47->26|47->26|48->27|48->27|48->27|49->28|49->28|49->28|50->29|50->29|50->29|51->30|51->30|51->30|54->33|54->33|54->33|55->34|55->34|55->34|56->35|56->35|56->35|59->38|59->38|59->38|60->39|60->39|60->39|61->40|61->40|61->40|65->44|65->44|65->44|66->45|66->45|66->45|67->46|67->46|67->46|72->51|72->51|72->51|77->56|77->56|77->56|78->57|78->57|78->57|81->60|81->60|81->60|82->61|82->61|82->61|86->65|86->65|86->65|87->66|87->66|87->66|88->67|88->67|88->67|91->70|91->70|91->70|95->74|95->74|96->75|97->76|97->76|99->78|99->78|99->78|100->79|102->81|102->81|104->83|104->83|104->83|105->84|110->89|110->89|112->91|112->91|112->91|113->92|118->97|118->97|122->101|122->101|122->101|123->102|124->103|124->103|126->105|126->105|126->105|127->106|130->109|130->109|131->110|131->110|131->110|132->111|137->116|137->116|140->119|141->120|141->120|142->121|143->122|143->122|144->123|145->124|145->124|146->125|147->126|147->126|161->140|166->145|166->145|167->146|167->146|170->149
                  -- GENERATED --
              */
          