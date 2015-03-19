
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
object modal extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*2.2*/main/*2.6*/{_display_(Seq[Any](format.raw/*2.7*/("""
"""),format.raw/*3.1*/("""<!--mainでの2つ目の引数-->
<div data-role="header">
 <h1>Todo List <a href=""""),_display_(/*5.26*/routes/*5.32*/.Application.logout),format.raw/*5.51*/("""">logout</a>&nbsp; <a href=""""),_display_(/*5.80*/routes/*5.86*/.Application.login),format.raw/*5.104*/("""">login</a></h1>

</div>

""")))}/*9.2*/{_display_(Seq[Any](format.raw/*9.3*/("""
  """),format.raw/*10.3*/("""<div class="modal-header">
    <div class="modal-title">モーダルダイアログ</div>
  </div>
  <form role="form" name="modalForm" novalidate>
    <div class="modal-body">
        <div class="form-group">
          <label for="input1">タスク入力欄</label>
          <input id="input1" class="form-control" type="text" ng-model="input1" placeholder="">
        </div>
      </form>
    </div>
    <div class="modal-footer">
      <button class="btn btn-primary" ng-click="ok()">OK</button>
      <button class="btn btn-default" ng-click="cancel()">キャンセル</button>
    </div>
  </form>


""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 18:50:03 JST 2015
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/modal.scala.html
                  HASH: a0ba243a9c2b8ed92d6bc6420cf64505ffc5e976
                  MATRIX: 580->2|591->6|628->7|655->8|751->78|765->84|804->103|859->132|873->138|912->156|956->183|993->184|1023->187
                  LINES: 22->2|22->2|22->2|23->3|25->5|25->5|25->5|25->5|25->5|25->5|29->9|29->9|30->10
                  -- GENERATED --
              */
          