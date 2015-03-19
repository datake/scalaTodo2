var myApp = angular.module('myApp',['ngAnimate','ui.calendar','ui.bootstrap','ngDialog','ui.sortable']);

myApp.service('commonService').service('commonService', function() {


/* this.getMyData = function(my_number,$http,$scope) {
$http.get('/api').success(function(data) {
var data_array=angular.fromJson(data);
for(i=0;i<data_array.length;i++){ 
if(data_array[i]['user_id']==my_number){
$scope.mytasks=$scope.mytasks.concat(data_array[i]);
}
}
console.log("getMyData");
console.log($scope.mytasks);  


}).
error(function(data, status, headers, config) {
});
}*/


this.getData = function($http,$scope) {

  $http.get('/api').success(function(data) {
    $scope.tasks = data;
    var data_array=angular.fromJson(data);
    $scope.data_array=angular.fromJson(data);
    $scope.showprogress();
  }).
  error(function(data, status, headers, config) {
  });
}

this.getLogiingUserId=function($http,$scope) {

  $http.get('/logging_user_id').success(function(data) {
    var data_array=angular.fromJson(data);
    $scope.user_id=data_array['user_id'];
  }).
  error(function(data, status, headers, config) {
  });

}


});//finish commonService

myApp.controller('mainCtrl', ['$scope','$compile','$http','$modal','ngDialog', '$timeout','commonService', function($scope,$compile,$http,$modal,ngDialog,  $timeout,commonService) {


  $scope.models = [];
  $scope.tasks = [];
  $scope.gitlogs = [];
  $scope.gitlog_array=[];
  $scope.mytasks = [];
  $scope.user = [];
  $scope.user_id;
  $scope.checkedtasks=[];
  $scope.unchecktasks=[];
$scope.events=[];//calendar反映
$scope.taskDateArray=[];//chartで表示するために使う
$scope.created_today=[];
$scope.today_target=[];
$scope.TimelineChartData=[];//TimelineChart
$scope.dialogAddLabel, $scope.dialogEditLabel,$scope.dialogEditTaskId;

//calendar
var date = new Date();
var d = date.getDate();
var m = date.getMonth();
var y = date.getFullYear();

/* $scope.eventSource = {
url: "http://www.google.com/calendar/feeds/usa__en%40holiday.calendar.google.com/public/basic",
className: 'gcal-event',           // an option!
currentTimezone: 'America/Chicago' // an option!
};
*/

$scope.events = [];


$scope.eventsF = function (start, end, timezone, callback) {
  var s = new Date(start).getTime() / 1000;
  var e = new Date(end).getTime() / 1000;
  var m = new Date(start).getMonth();
  var events = [{title: 'Feed Me ' + m,start: s + (50000),end: s + (100000),allDay: false, className: ['customFeed']}];
};

$scope.calEventsExt = {
  color: '#f00',
  textColor: 'yellow',
  events: []
};

$scope.repeat_limit_uncheck=10;
$scope.repeat_limit_checked=10;

$scope.readmore_checked=$scope.checkedtasks.length-$scope.repeat_limit_checked;
$scope.readmore_uncheck=$scope.unchecktasks.length-$scope.repeat_limit_uncheck;

$scope.readmore_uncheck=function(){
  console.log("readmore_uncheck");
  if($scope.unchecktasks.length){
if($scope.unchecktasks.length>$scope.repeat_limit_uncheck+5){//13件で今5件表示
  console.log("+5");
  $scope.repeat_limit_uncheck+=5;
  $scope.readmore_uncheck=$scope.unchecktasks.length-$scope.repeat_limit_uncheck;
}else if($scope.unchecktasks.length>=$scope.repeat_limit_uncheck){//8件で今5件表示
  console.log("+1~+4");
  $scope.repeat_limit_uncheck=$scope.unchecktasks.length;
  $scope.readmore_uncheck=$scope.unchecktasks.length-$scope.repeat_limit_uncheck;
}else{//
  console.log("もうよみこむものがない");
}
}else{//.lengthがとれない
  console.log(".lengthがとれない");

}
}

$scope.readmore_checked=function(){
  console.log("readmore_checked");
  console
  if($scope.checktasks.length){
    if($scope.checkedtasks.length>$scope.repeat_limit_checked+5){
      $scope.repeat_limit_checked+=5;
      console.log("+5");
      $scope.readmore_checked=$scope.checkedtasks.length-$scope.repeat_limit_checked;

    }else if($scope.unchecktasks.length>=$scope.repeat_limit_uncheck){
      console.log("0~+4");
      $scope.repeat_limit_checked=$scope.checkedtasks.length;
      $scope.readmore_checked=$scope.checkedtasks.length-$scope.repeat_limit_checked;

    }else{
      console.log("もうよみこむものがない");
//$scope.repeat_limit_checked=$scope.checkedtasks.length-$scope.repeat_limit_checked;
}
}else{//.lengthがとれない
  console.log(".lengthがとれない");

}

}

//hint: http://fullcalendar.io/docs/mouse/dayClick/
$scope.dayClick=function(date, jsEvent, view) {
  $scope.openDialogToAdd();
  $scope.clicked_date=new Date (date.getFullYear(),(date.getMonth()),date.getDate(),12,0);
  commonService.getData($http,$scope);
// $scope.setTaskCalendar();//$scope.events[] <= api
}
//when calendar is clicked, ngdialog open 
$scope.openDialogToAdd = function () {
  console.log("openDialogToAdd");
  ngDialog.open({ 
    template: 'DialogToAdd',
    scope: $scope          
  });
commonService.getData($http,$scope);//$scope.data[] <= api 
// $scope.setTaskCalendar();//$scope.events[] <= api

};



//called from templateId(Dialog)
$scope.addNewFromCalendar=function(){
  console.log("addNewFromCalendar");
  console.log($scope.dialogAddLabel);
  $http.post('/tasks', {label:  $scope.dialogAddLabel ,target:$scope.clicked_date,user_id:"7777"})
  .success(function(data, status, headers, config) {
    $scope.tasks.push({"label":$scope.dialogAddLabel,"progress":false,"target":$scope.clicked_date,"user_id":"7777"});
    console.log("success,$http");
//$scope.tasks.push({"label":$scope.newTasklabel,"progress":false,"target":$scope.newTasktarget,"user_id":$scope.newTaskuser_id});
$scope.dialogAddLabel = '';
$scope.clicked_date = '';
//$scope.newTaskuser_id = '';
commonService.getData($http,$scope);
// $scope.setTaskCalendar();//$scope.events[] <= api
})
  .error(function(data, status, headers, config) {
    console,log("error,$http.post");
  });
}


/* alert on eventClick */
$scope.alertOnEventClick = function(date, jsEvent, view){
//console.log("alertOnEventClick,title is:"+date.title+"task_id is"+date.task_id);
console.log("alertOnEventClick");
console.log(date.start);
var eventdate=date.start;
//$scope.dialogEditLabel="aaaaaaaaaaaa";
$scope.dialogEditTaskId=date.task_id;
$scope.openDialogToEdit(date.title);
$scope.clicked_date=new Date (eventdate.getFullYear(),(eventdate.getMonth()),eventdate.getDate(),12,0);
};


//when calendar is clicked, ngdialog open 
$scope.openDialogToEdit = function (task_title) {
  console.log("openDialogToEdit");
  console.log(task_title);
  $scope.dialogEditLabel=task_title;
  ngDialog.open({ template: 'DialogToEdit',
    scope: $scope   
  });
};

$scope.editFromCalendar=function(){
  var task_id=$scope.dialogEditTaskId;
//alert(task_id);
var updateTasklabel=$scope.models[task_id];
console.log("updateTasklabel from calendar");
console.log("myscript.js/editFromCalendar");
console.log("target:"+ $scope.clicked_date);
//$httpになげるtaskformはlabel,target,user_id
$http.post('/tasks/'+task_id+'/update', {label: $scope.dialogEditLabel,target:"2015-01-01",user_id:"7777"}).
success(function(data, status, headers, config) {
// console.log("update success:"+task_id);
$scope.tasks.splice(task_id,1,{"label":$scope.dialogEditLabel,"progress":false,"id":task_id,"user_id":"12345"});
$scope.updateTasklabel = '';
//$scope.getData();
commonService.getData($http,$scope);
//$scope.setTaskCalendar();
}).
error(function(data, status, headers, config) {
  console.log("error myscript/updateTask");
});
}






/* alert on Drop */
$scope.alertOnDrop = function(event, delta, revertFunc, jsEvent, ui, view){
// $scope.alertMessage = ('Event Droped to make dayDelta ' + delta);
console.log("alertOnDrop");
console.log("title:"+event.title+",task_id:"+event.task_id+",meved to:"+event.start);
console.log("何日変化したか"+delta);
var task_id=event.task_id
//event.task_id番のタスクの日付をevent.start番に変更する

target_Dateobject=new Date(event.start);
$http.post('/tasks/'+task_id+'/changeDate', {label: "label_DUMMY",target: new Date(y, target_Dateobject.getMonth(), target_Dateobject.getDate()+1),user_id:"7777"}).
success(function(data, status, headers, config) {
  console.log("CHANGEDATE SUCCESS");
  commonService.getData($http,$scope);
// $scope.setTaskCalendar();
}).
error(function(data, status, headers, config) {
  console.log("error myscript/changeDate");
});
};


/* config object */
$scope.uiConfig = {
  calendar:{
    height: 450,
    editable: true,
    header:{
      left: 'title',
      center: '',
      right: 'today prev,next'
    },
    eventClick: $scope.alertOnEventClick,
    eventDrop: $scope.alertOnDrop,
    dayClick:$scope.dayClick
  }
};




/* event sources array*/
$scope.eventSources = [$scope.calEventsExt,$scope.events/*, $scope.eventSource, $scope.eventsF*/];
//   $scope.eventSources2 = [$scope.calEventsExt, $scope.eventsF, $scope.events];




$scope.setTaskCalendar = function() {
  $http.get('/api').success(function(data) {
    var data_array=angular.fromJson(data);

// console.log("setTaskCalendar"+data_array);
//配列を初期化しないと、addtaskしたときなどに既存のtaskが二重ではいる
$scope.events.length=0;

for(i=0;i<data_array.length;i++){ 
  target_Dateobject=new Date(data_array[i]['target']);
  $scope.events.push({title: data_array[i]['label'],start: new Date(y, target_Dateobject.getMonth(), target_Dateobject.getDate()),task_id:data_array[i]['id']});
//$scope.calEventsExt.push({title: data_array[i]['label'],start: new Date(y, target_Dateobject.getMonth(), target_Dateobject.getDate()),task_id:data_array[i]['id']});

}
//console.log("setTaskCalendar done");
}).
  error(function(data, status, headers, config) {

  });
}
$scope.setTaskCalendar();





$scope.alertEventOnClick = function(date, allDay,jsEvent, view) {
  $scope.$apply(function(){
    $scope.alertMessage = ('Day Clicked ' + date);
  });
}

$scope.alertOnEventClick = function( date, jsEvent, view){
  $scope.alertMessage = (date.title + ' was clicked ');
};

//$scope.setTaskCalendar();

commonService.getData($http,$scope);

$scope.gitrepository="agent";
$scope.gitowner="datake";

$scope.getGitLog = function() {

  var gitapi="https://api.github.com/repos/"+$scope.gitowner+"/"+$scope.gitrepository+"/commits"
  $http.get(gitapi).success(function(gitdata) {

    $scope.gitlogs = gitdata;
    $scope.gitlog_array=angular.fromJson(gitdata);
  }).
  error(function(data, status, headers, config) {
  });
}


$scope.getGitLog();
commonService.getLogiingUserId($http,$scope);

$scope.checkCommited=function() {
//console.log($scope.data_array);
for (var i = 0; i < $scope.data_array.length; i++) {
  for (var j = 0; j < $scope.gitlog_array.length; j++) {
    if($scope.gitlog_array[j]["commit"]["message"]==$scope.data_array[i]["label"]){
      $scope.checkTask($scope.data_array[i]["id"]);
    }
  };
//alert($scope.data_array[i]["label"]);
};
// gitlog.commit.message
}

$scope.addNew = function() {
// Simple POST request example (passing data) :
console.log("addNew");
$http.post('/tasks', {label:$scope.newTasklabel,target:$scope.newTasktarget,user_id:"7777"}).
success(function(data, status, headers, config) {
  console.log("addnew $http success"+$scope.newTasktarget);
//console.log($scope.newTaskuser_id);
//$scope.tasks.push({"label":$scope.newTasklabel,"progress":false,"target":$scope.newTasktarget,"user_id":$scope.newTaskuser_id});
$scope.newTasklabel = '';
$scope.newTasktarget = '';
$scope.newTaskuser_id = '';
//$scope.getData();
commonService.getData($http,$scope);
//$scope.setTaskCalendar();

}).
error(function(data, status, headers, config) {
  console.log("error:addNew");
});

}

$scope.updateTask = function(task_id,$index) {

  var updateTasklabel=$scope.models[task_id];

//$httpになげるtaskformはlabel,target,user_id
$http.post('/tasks/'+task_id+'/update', {target:"2015-01-01",label:updateTasklabel,user_id:"7777"}).
success(function(data, status, headers, config) {
// console.log("update success:"+task_id);
$scope.tasks.splice(task_id,1,{"label":updateTasklabel,"progress":false,"id":task_id,"user_id":"12345"});
$scope.updateTasklabel = '';
commonService.getData($http,$scope);
//$scope.setTaskCalendar();
}).
error(function(data, status, headers, config) {
  console.log("error myscript/updateTask");
});
}

$scope.getprogressCount = function() {
  var count = 0;
  angular.forEach($scope.tasks, function(task) {
    count += task.progress ? 1 : 0;
  });
  return count;
}

$scope.showprogress=function(){
  $http.get('/api').success(function(data) {
//  $scope.tasks = data;
var data_array=angular.fromJson(data);
//onsole.log(data_array);
$scope.checkedtasks.length=0;
$scope.unchecktasks.length=0;
for(i=0;i<data_array.length;i++){
  if(data_array[i]['progress']==1){
    $scope.checkedtasks.push(data_array[i]);
  }else if(data_array[i]['progress']==0){
    $scope.unchecktasks.push(data_array[i]);
  }
}
}).
  error(function(data, status, headers, config) {
    console.log("error:showprogress")
  });
}


$scope.deleteTask= function(task_id) {
  $http.post('/tasks/'+task_id+'/delete', {id:task_id}).
  success(function(data, status, headers, config) {
    $scope.tasks.splice(task_id,1)
    commonService.getData($http,$scope);
//$scope.setTaskCalendar()
}).
  error(function(data, status, headers, config) {
  });

}


$scope.deleteprogress = function() {//scope.tasksを一旦全てoldTasksに移し替え、progressでないものだけ再びscope.tasksに戻す
  var oldTasks = $scope.tasks;
//console.log("myscript.js/deleteprogress");

$scope.tasks = [];

angular.forEach(oldTasks, function(task) {
  if (!task.progress) {
//remain
$scope.tasks.push(task);
}else{
//delete
$http.post('/tasks/'+task.id+'/delete', {id:task.id}).
success(function(data, status, headers, config) {
  $scope.tasks.splice(task.id,1) 
  commonService.getData($http,$scope);
//console.log("delete!!!"+task.id);
}).
error(function(data, status, headers, config) {
});


}
});
}
$scope.checkUncheckTask= function(task_id,task_progress) {
  if(!task_progress){
    console.log("check");
    $http.post('/tasks/'+task_id+'/check', {id:task_id}).
    success(function(data, status, headers, config) {
      commonService.getData($http,$scope);
      $scope.showprogress();
    }).
    error(function(data, status, headers, config) {
    });
  }else{
    console.log("uncheck");
    $http.post('/tasks/'+task_id+'/uncheck', {id:task_id}).
    success(function(data, status, headers, config) {
      commonService.getData($http,$scope);
      $scope.showprogress();
    }).
    error(function(data, status, headers, config) {
    });
  }
}

$scope.checkTask= function(task_id) {

//console.log("check");
$http.post('/tasks/'+task_id+'/check', {id:task_id}).
success(function(data, status, headers, config) {
  commonService.getData($http,$scope);
}).
error(function(data, status, headers, config) {
});
}


//チャートで表示するためのタスク名と残り日が入った配列を作る
//Chartの表示
$scope.setTaskDateArray = function() {
  $http.get('/api').success(function(data) {
    var data_array=angular.fromJson(data);
    console.log("called $scope.setTaskDateArray");

    var today_Dateobject=new Date();
    var today_date=today_Dateobject.getDate();

    $scope.taskDateArray.length=0;
    $scope.created_today.length=0;
    $scope.today_target.length=0;
    $scope.TimelineChartData.length=0;

    for(i=0;i<data_array.length;i++){
      var target_Dateobject=new Date(data_array[i]['target']);
      var target_Date=target_Dateobject.getDate();
      var leftDay=today_date-target_Date;

      var created_Dateobject=new Date(data_array[i]['created']);
      var created_Date=created_Dateobject.getDate();
var passedDay=created_Date- today_date;//negative number
/*   if(leftDay>0){//timeover task
var timeover=leftDay;
}else{
var timeover=0;
}
var diff_created_today=Math.round((created_Dateobject-today)/86400000);//negative number
var diff_today_target=Math.round((target_Dateobject-today)/86400000);//positive number


if(diff_today_target<0){
diff_today_target=0;
}*/
passedMessage='作成から'+ -passedDay+'日';
leftMessage='残り'+ -leftDay+'日';
timeoverMessage= leftDay+'日前に期限切れ';
//console.log(passedMessage+leftMessage)

if(target_Dateobject<created_Dateobject){//作成日より過去に期限を設定したタスク
  console.log("error:作成日より過去に期限を設定したタスク"); 
}else{
  if(today_Dateobject<target_Dateobject){
    $scope.TimelineChartData.push([data_array[i]['label'],passedMessage,created_Dateobject,today_Dateobject]);
    $scope.TimelineChartData.push([data_array[i]['label'],leftMessage,today_Dateobject,target_Dateobject]);
  }else{
    $scope.TimelineChartData.push([data_array[i]['label'],timeoverMessage,created_Dateobject,target_Dateobject]);
// $scope.TimelineChartData.push([data_array[i]['label'],'期限をすぎています',target_Dateobject,today_Dateobject);
}
}
}
//console.log("taskDateArray from setTaskDateArray");
// console.log($scope.taskDateArray);
//APIからとってきたデータでチャートを表示する関数実行
//drawChart2();
drawTimelineChart();
}).
error(function(data, status, headers, config) {
  console.log("error setTaskDateArray");
});

}//finish $scope.settaskdate()
$scope.setTaskDateArray();



function drawTimelineChart() {
  var container = document.getElementById('timeline');
  var chart = new google.visualization.Timeline(container);
  var dataTable = new google.visualization.DataTable();
  dataTable.addColumn({ type: 'string', id: 'status' });
  dataTable.addColumn({ type: 'string', id: 'Task' });
  dataTable.addColumn({ type: 'date', id: 'created' });
  dataTable.addColumn({ type: 'date', id: 'target' });
  dataTable.addRows($scope.TimelineChartData);         
  chart.draw(dataTable);
}//finish drawTimelineChart



$scope.dragControlListeners = {

   accept: function (sourceItemHandleScope, destSortableScope) {
     return sourceItemHandleScope.itemScope.sortableScope.$id === destSortableScope.$id;},//override to determine drag is allowed or not. default is true.
    itemMoved: function (event) {
      var moveSuccess, moveFailure;
     console.log("sort");
      moveSuccess = function() {console.log("sort success");};

      moveFailure = function() {   
          console.log("sort failed");
           eventObj.dest.sortableScope.removeItem(eventObj.dest.index);
           eventObj.source.itemScope.sortableScope.insertItem(eventObj.source.index, eventObj.source.itemScope.task);
      };


    },
    orderChanged: function(event) {   console.log("sort");},
    containment: '#board'
};





}//finish controller
]);//finish of myapp.controller





