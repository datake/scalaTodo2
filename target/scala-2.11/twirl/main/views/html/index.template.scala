
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[Task],Form[scala.Tuple3[String, String, String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tasks: List[Task], taskForm: Form[(String,String,String)]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._

Seq[Any](format.raw/*1.61*/("""
"""),format.raw/*2.1*/("""<!--[at](gitlogs: List[Gitlog], gitLogForm: Form[(String,String,String)])-->
"""),_display_(/*4.2*/main/*4.6*/{_display_(Seq[Any](format.raw/*4.7*/("""
"""),format.raw/*5.1*/("""<!--mainでの2つ目の引数-->
<div data-role="header">
  <nav class="navbar navbar-default ">
    <div class="navbar-header">
      <button class="navbar-toggle" data-toggle="collapse" data-target=".target">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href=""><h1>Todoリスト<h1></a>
    </div>
    <div class="collapse navbar-collapse target">
      <ul class="nav navbar-nav">
        <li ><a href="#calendar">カレンダー</a></li>
        <li ><a href="#tasklist">タスク一覧</a></li>
        <li><a href="#git">git連携</a></li>
        <li><a href="#chart">ガントチャート</a></li>
        <li><a href=""""),_display_(/*25.23*/routes/*25.29*/.Application.logout),format.raw/*25.48*/("""">logout</a></li>
        <li><a href=""""),_display_(/*26.23*/routes/*26.29*/.Application.login),format.raw/*26.47*/("""">login</a></li>
      </ul>
    </div>

  </nav>

</div>

""")))}/*34.2*/{_display_(Seq[Any](format.raw/*34.3*/("""
"""),format.raw/*35.1*/("""<div data-role="content">

  <div ng-controller="mainCtrl">
    <div class="span12" id="calendar">
      <div ui-calendar="uiConfig.calendar"  ng-model="eventSources"></div> 

    </div><!--finish span12-->

    <div class="span4">

      <form  ng-submit="addNew()" ng-controller="mainCtrl">

        <input type="text" ng-model="newTasklabel"  class="input-small" nc-init-focus>
        <input type="date" ng-model="newTasktarget"   class="input-small">

        <button type="submit"  class="btn btn-primary btn-sm">add task<i class="fa fa-plus"></i></button>
      </form>
    </div><!--finish span4-->
    <div class="span4">
      <!--progressの一括削除-->
      <button ng-click="deleteprogress()"  class="btn btn-primary btn-sm">完了したタスクの削除<i class="fa fa-times"></i></button>


    </div><!--finish span4-->

    <div class="span8">
    </div>

    <br><br><br><br><br>
    <br><br><br><br><br>
    <div class="span12" id="tasklist">
      <div class="progress_tasks">
        <h2>するべきタスクと期日</h2>
      </div>

      <div class="row">
        <div class="span4">
          <ul data-role="listview"  style="list-style:none;">
            <!--要素の一覧-->
            <li ng-repeat="task in unchecktasks| orderBy:'target'|limitTo:repeat_limit_uncheck"><!--tasksからひとつずつtaskとしてとりだして繰り返し-->


              <div class="wrapper">
                <div ng-hide="showme" >
                  <input type="checkbox" ng-model="task.label" ng-change="checkUncheckTask(task.id,task.progress)" ng-checked="task.progress">
                  <span class="progress-"""),format.raw/*80.41*/("""{"""),format.raw/*80.42*/("""{"""),format.raw/*80.43*/("""task.progress"""),format.raw/*80.56*/("""}"""),format.raw/*80.57*/("""}"""),format.raw/*80.58*/("""">"""),format.raw/*80.60*/("""{"""),format.raw/*80.61*/("""{"""),format.raw/*80.62*/("""task.label"""),format.raw/*80.72*/("""}"""),format.raw/*80.73*/("""}"""),format.raw/*80.74*/("""&nbsp;&nbsp;"""),format.raw/*80.86*/("""{"""),format.raw/*80.87*/("""{"""),format.raw/*80.88*/("""task.target"""),format.raw/*80.99*/("""}"""),format.raw/*80.100*/("""}"""),format.raw/*80.101*/("""&nbsp;&nbsp;by"""),format.raw/*80.115*/("""{"""),format.raw/*80.116*/("""{"""),format.raw/*80.117*/("""task.user_id"""),format.raw/*80.129*/("""}"""),format.raw/*80.130*/("""}"""),format.raw/*80.131*/("""</span>
                  <!--$index番目から1つ削除-->
                  <a href ng-click="deleteTask(task.id)"  ><i class="fa fa-times"></i></a>
                  <a href="" ng-click="showme=true"><i class="fa fa-pencil"></i></a>

                </div>

                <!--editボタンがクリックされたらupdateボタン表示-->
                <div ng-show="showme">
                  <!--updateボタン-->
                  <!--task.modelsはeditを押したときに操作する文字列-->
                  <form ng-submit="updateTask(task.id,$index)">
                    <input type="text" ng-model="models[task.id]" ng-init="models[task.id]='"""),format.raw/*92.93*/("""{"""),format.raw/*92.94*/("""{"""),format.raw/*92.95*/("""task.label"""),format.raw/*92.105*/("""}"""),format.raw/*92.106*/("""}"""),format.raw/*92.107*/("""'" class="input-small"> 

                    <input type="submit" value="update" class="btn btn-primary btn-sm">
                  </form>
                </div>
              </div>
            </li>
          </ul>
          <!--<button ng-click="readmore_uncheck()"  class="btn btn-primary btn-sm">"""),format.raw/*100.85*/("""{"""),format.raw/*100.86*/("""{"""),format.raw/*100.87*/("""unchecktasks.length"""),format.raw/*100.106*/("""}"""),format.raw/*100.107*/("""}"""),format.raw/*100.108*/("""もっとよむ:"""),format.raw/*100.114*/("""{"""),format.raw/*100.115*/("""{"""),format.raw/*100.116*/("""repeat_limit_uncheck"""),format.raw/*100.136*/("""}"""),format.raw/*100.137*/("""}"""),format.raw/*100.138*/(""","""),format.raw/*100.139*/("""{"""),format.raw/*100.140*/("""{"""),format.raw/*100.141*/("""readmore_uncheck"""),format.raw/*100.157*/("""}"""),format.raw/*100.158*/("""}"""),format.raw/*100.159*/("""</button>-->
          <button ng-click="readmore_uncheck()"  class="btn btn-primary btn-sm">もっとよむ</button>
        </div><!--frinish div class="span4-->


        <div class="span4">
          <ul data-role="listview"  style="list-style:none;">
            <!--要素の一覧-->

            <li ng-repeat="task in checkedtasks| orderBy:'target'|limitTo:repeat_limit_checked"><!--tasksからひとつずつtaskとしてとりだして繰り返し-->


              <div class="wrapper">
                <div ng-hide="showme" >
                  <input type="checkbox" ng-model="task.label" ng-change="checkUncheckTask(task.id,task.progress)" ng-checked="task.progress">
                  <span class="progress-"""),format.raw/*115.41*/("""{"""),format.raw/*115.42*/("""{"""),format.raw/*115.43*/("""task.progress"""),format.raw/*115.56*/("""}"""),format.raw/*115.57*/("""}"""),format.raw/*115.58*/("""">"""),format.raw/*115.60*/("""{"""),format.raw/*115.61*/("""{"""),format.raw/*115.62*/("""task.label"""),format.raw/*115.72*/("""}"""),format.raw/*115.73*/("""}"""),format.raw/*115.74*/("""&nbsp;&nbsp;"""),format.raw/*115.86*/("""{"""),format.raw/*115.87*/("""{"""),format.raw/*115.88*/("""task.target"""),format.raw/*115.99*/("""}"""),format.raw/*115.100*/("""}"""),format.raw/*115.101*/("""&nbsp;&nbsp;by"""),format.raw/*115.115*/("""{"""),format.raw/*115.116*/("""{"""),format.raw/*115.117*/("""task.user_id"""),format.raw/*115.129*/("""}"""),format.raw/*115.130*/("""}"""),format.raw/*115.131*/("""</span>
                  <!--$index番目から1つ削除-->
                  <a href ng-click="deleteTask(task.id)"  ><i class="fa fa-times"></i></a>
                  <a href="" ng-click="showme=true"><i class="fa fa-pencil"></i></a>

                </div>

                <!--editボタンがクリックされたらupdateボタン表示-->
                <div ng-show="showme">
                  <!--updateボタン-->
                  <!--task.modelsはeditを押したときに操作する文字列-->
                  <form ng-submit="updateTask(task.id,$index)">
                    <input type="text" ng-model="models[task.id]" ng-init="models[task.id]='"""),format.raw/*127.93*/("""{"""),format.raw/*127.94*/("""{"""),format.raw/*127.95*/("""task.label"""),format.raw/*127.105*/("""}"""),format.raw/*127.106*/("""}"""),format.raw/*127.107*/("""'" class="input-small"> 

                    <input type="submit" value="update" class="btn btn-primary btn-sm">
                  </form>
                </div>
              </div>
            </li>
          </ul>

          <button ng-click="readmore_checked()"  class="btn btn-primary btn-sm">もっとよむ</button>


          <br>
          <br>

        </div><!--frinish div class="span8-->
        <div class="span4">
        </div>
      </div>
      <br>
      <br>
      <br><br><br><br><br>
      <div class="span12" id="git">
        <div class="progress_tasks">
          <h2 > gitのコミットログ&nbsp;&nbsp;
            &nbsp;&nbsp;
            <button class="btn btn-primary btn-sm" ng-click="checkCommited()">コミット済みのタスクをチェック</button>
          </h2>
        </div>
        <ul>

          <li ng-repeat="gitlog in gitlogs|limitTo:5">

            """),format.raw/*160.13*/("""{"""),format.raw/*160.14*/("""{"""),format.raw/*160.15*/("""gitlog.commit.committer.name"""),format.raw/*160.43*/("""}"""),format.raw/*160.44*/("""}"""),format.raw/*160.45*/("""&nbsp;&nbsp;"""),format.raw/*160.57*/("""{"""),format.raw/*160.58*/("""{"""),format.raw/*160.59*/("""gitlog.commit.message"""),format.raw/*160.80*/("""}"""),format.raw/*160.81*/("""}"""),format.raw/*160.82*/("""&nbsp;&nbsp;"""),format.raw/*160.94*/("""{"""),format.raw/*160.95*/("""{"""),format.raw/*160.96*/("""gitlog.commit.committer.date"""),format.raw/*160.124*/("""}"""),format.raw/*160.125*/("""}"""),format.raw/*160.126*/("""

          """),format.raw/*162.11*/("""</li>
        </ul>

        <form novalidate  ng-submit="getGitLog()" >
          repository:<input type="text" ng-model="gitrepository"  class="input-small" ng-init="gitrepository">
          owner:<input type="text" ng-model="gitowner"   class="input-small" ng-init="owner">
          <button class="btn btn-primary btn-sm" ng-click="addGit()">gitの情報を更新</button>
        </form>


<!--not display mytask
<div class="progress_tasks">
<ul data-role="listview"  style="list-style:none;">

<h2>MyTask(user_id:"""),format.raw/*176.20*/("""{"""),format.raw/*176.21*/("""{"""),format.raw/*176.22*/("""user_id"""),format.raw/*176.29*/("""}"""),format.raw/*176.30*/("""}"""),format.raw/*176.31*/(""")</h2>
<li ng-repeat="task in mytasks">

<div class="wrapper">
<div ng-hide="showme" >
<input type="checkbox" ng-model="task.progress" ng-change="checkUncheckTask(task.id,task.progress)" ng-checked="task.progress">
<span class="progress-"""),format.raw/*182.23*/("""{"""),format.raw/*182.24*/("""{"""),format.raw/*182.25*/("""task.progress"""),format.raw/*182.38*/("""}"""),format.raw/*182.39*/("""}"""),format.raw/*182.40*/("""">"""),format.raw/*182.42*/("""{"""),format.raw/*182.43*/("""{"""),format.raw/*182.44*/("""task.label"""),format.raw/*182.54*/("""}"""),format.raw/*182.55*/("""}"""),format.raw/*182.56*/("""&nbsp;&nbsp;"""),format.raw/*182.68*/("""{"""),format.raw/*182.69*/("""{"""),format.raw/*182.70*/("""task.target"""),format.raw/*182.81*/("""}"""),format.raw/*182.82*/("""}"""),format.raw/*182.83*/("""&nbsp;&nbsp;by"""),format.raw/*182.97*/("""{"""),format.raw/*182.98*/("""{"""),format.raw/*182.99*/("""task.user_id"""),format.raw/*182.111*/("""}"""),format.raw/*182.112*/("""}"""),format.raw/*182.113*/("""</span>

<a href ng-click="deleteTask(task.id)"  ><i class="fa fa-times"></i></a>
<a href="" ng-click="showme=true"><i class="fa fa-pencil"></i></a>

</div>

<div ng-show="showme">

<form ng-submit="updateTask(task.id,$index)">
<input type="text" ng-model="models[task.id]" ng-init="models[task.id]='"""),format.raw/*192.73*/("""{"""),format.raw/*192.74*/("""{"""),format.raw/*192.75*/("""task.label"""),format.raw/*192.85*/("""}"""),format.raw/*192.86*/("""}"""),format.raw/*192.87*/("""'" class="input-small"> 
"""),format.raw/*193.1*/("""{"""),format.raw/*193.2*/("""{"""),format.raw/*193.3*/("""task.label"""),format.raw/*193.13*/("""}"""),format.raw/*193.14*/("""}"""),format.raw/*193.15*/("""
"""),format.raw/*194.1*/("""<input type="submit" value="update" class="btn btn-primary btn-sm">
</form>
</div>
</div>

</li>
</ul>
</div>
-->
<div data-role="footer">
<br><br><br><br><br>
<div ng-init="checked=true" id="chart">
  <label>
    <input type="checkbox" ng-model="checked" style="float:left; margin-right:10px;" > check me!
  </label>
  <div class="check-element animate-show-hide" ng-show="checked" style="clear:both;">
    <div id="chart"></div><!--チャートを表示-->
    <div id="timeline" style="width: 900px; height: 1000px;"></div><!--チャートを表示-->
   <!-- <div class="progress_tasks">
      <h2>Finished Tasks</h2>


      """),format.raw/*216.7*/("""{"""),format.raw/*216.8*/("""{"""),format.raw/*216.9*/("""progressTasks.label"""),format.raw/*216.28*/("""}"""),format.raw/*216.29*/("""}"""),format.raw/*216.30*/("""

      """),format.raw/*218.7*/("""<ul data-role="listview"  style="list-style:none;">
        <li ng-repeat="task in checkedtasks">
          """),format.raw/*220.11*/("""{"""),format.raw/*220.12*/("""{"""),format.raw/*220.13*/("""task.label"""),format.raw/*220.23*/("""}"""),format.raw/*220.24*/("""}"""),format.raw/*220.25*/("""
        """),format.raw/*221.9*/("""</li>
      </ul>
    </div>-->
  </div>
ui-sortable test
<ul data-as-sortable="board.dragControlListeners" data-ng-model="items">
   <li data-ng-repeat="task in unchecktasks" data-as-sortable-item>
      <div data-as-sortable-item-handle>"""),format.raw/*228.41*/("""{"""),format.raw/*228.42*/("""{"""),format.raw/*228.43*/("""task.label"""),format.raw/*228.53*/("""}"""),format.raw/*228.54*/("""}"""),format.raw/*228.55*/("""</div>
   </li>
</ul>



</div><!-- finish div class="span12-->
</div><!--finish controller-->
</div><!--finish content-->




<script type="text/ng-template" id="DialogToAdd">

<form ng-submit="addNewFromCalendar()" ng-controller="mainCtrl">
<input type="text" ng-model="dialogAddLabel"  class="input-small">

<button class="btn btn-primary btn-sm" ng-click="closeThisDialog() ">add task<i class="fa fa-plus"></i></button>
</form>
</script>
<!--
<form ng-submit="updateTask(task.id,$index)">
<input type="text" ng-model="models[task.id]" ng-init="models[task.id]='"""),format.raw/*251.73*/("""{"""),format.raw/*251.74*/("""{"""),format.raw/*251.75*/("""task.label"""),format.raw/*251.85*/("""}"""),format.raw/*251.86*/("""}"""),format.raw/*251.87*/("""'" class="input-small"> 

<input type="submit" value="update" class="btn btn-primary btn-sm">
</form>
-->
<script type="text/ng-template" id="DialogToEdit">
<form ng-submit="editFromCalendar()" ng-controller="mainCtrl">
<input type="text" ng-model="dialogEditLabel" class="input-small">
<button class="btn btn-primary btn-sm"  ng-click="closeThisDialog() ">update task<i class="fa fa-plus"></i></button>
</form>
</script>


""")))}))}
  }

  def render(tasks:List[Task],taskForm:Form[scala.Tuple3[String, String, String]]): play.twirl.api.HtmlFormat.Appendable = apply(tasks,taskForm)

  def f:((List[Task],Form[scala.Tuple3[String, String, String]]) => play.twirl.api.HtmlFormat.Appendable) = (tasks,taskForm) => apply(tasks,taskForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Jan 24 19:24:02 JST 2015
                  SOURCE: /home/takedahajime/workspace/todo_Angular_folder/todolist_Angular2/app/views/index.scala.html
                  HASH: 3135c8a0e020931331b6e864f8f2017aef33eae0
                  MATRIX: 552->1|714->60|741->61|844->156|855->160|892->161|919->162|1753->969|1768->975|1808->994|1875->1034|1890->1040|1929->1058|2007->1118|2045->1119|2073->1120|3647->2666|3676->2667|3705->2668|3746->2681|3775->2682|3804->2683|3834->2685|3863->2686|3892->2687|3930->2697|3959->2698|3988->2699|4028->2711|4057->2712|4086->2713|4125->2724|4155->2725|4185->2726|4228->2740|4258->2741|4288->2742|4329->2754|4359->2755|4389->2756|5003->3342|5032->3343|5061->3344|5100->3354|5130->3355|5160->3356|5491->3658|5521->3659|5551->3660|5600->3679|5631->3680|5662->3681|5698->3687|5729->3688|5760->3689|5810->3709|5841->3710|5872->3711|5903->3712|5934->3713|5965->3714|6011->3730|6042->3731|6073->3732|6767->4397|6797->4398|6827->4399|6869->4412|6899->4413|6929->4414|6960->4416|6990->4417|7020->4418|7059->4428|7089->4429|7119->4430|7160->4442|7190->4443|7220->4444|7260->4455|7291->4456|7322->4457|7366->4471|7397->4472|7428->4473|7470->4485|7501->4486|7532->4487|8147->5073|8177->5074|8207->5075|8247->5085|8278->5086|8309->5087|9189->5938|9219->5939|9249->5940|9306->5968|9336->5969|9366->5970|9407->5982|9437->5983|9467->5984|9517->6005|9547->6006|9577->6007|9618->6019|9648->6020|9678->6021|9736->6049|9767->6050|9798->6051|9839->6063|10376->6571|10406->6572|10436->6573|10472->6580|10502->6581|10532->6582|10798->6819|10828->6820|10858->6821|10900->6834|10930->6835|10960->6836|10991->6838|11021->6839|11051->6840|11090->6850|11120->6851|11150->6852|11191->6864|11221->6865|11251->6866|11291->6877|11321->6878|11351->6879|11394->6893|11424->6894|11454->6895|11496->6907|11527->6908|11558->6909|11887->7209|11917->7210|11947->7211|11986->7221|12016->7222|12046->7223|12099->7248|12128->7249|12157->7250|12196->7260|12226->7261|12256->7262|12285->7263|12915->7865|12944->7866|12973->7867|13021->7886|13051->7887|13081->7888|13117->7896|13254->8004|13284->8005|13314->8006|13353->8016|13383->8017|13413->8018|13450->8027|13718->8266|13748->8267|13778->8268|13817->8278|13847->8279|13877->8280|14471->8845|14501->8846|14531->8847|14570->8857|14600->8858|14630->8859
                  LINES: 19->1|22->1|23->2|24->4|24->4|24->4|25->5|45->25|45->25|45->25|46->26|46->26|46->26|54->34|54->34|55->35|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|100->80|112->92|112->92|112->92|112->92|112->92|112->92|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|120->100|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|135->115|147->127|147->127|147->127|147->127|147->127|147->127|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|180->160|182->162|196->176|196->176|196->176|196->176|196->176|196->176|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|202->182|212->192|212->192|212->192|212->192|212->192|212->192|213->193|213->193|213->193|213->193|213->193|213->193|214->194|236->216|236->216|236->216|236->216|236->216|236->216|238->218|240->220|240->220|240->220|240->220|240->220|240->220|241->221|248->228|248->228|248->228|248->228|248->228|248->228|271->251|271->251|271->251|271->251|271->251|271->251
                  -- GENERATED --
              */
          