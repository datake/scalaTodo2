var myApp = angular.module('myApp',['ngAnimate','ui.calendar','ui.bootstrap','ngDialog']);

myApp.service('mathService').service('mathService', function() {
    this.add = function(a, b) {
        return a + b;
    };

    this.pow = function(a, b) {
        var result = 1
      for (var i = 0; i < b; i++) {
        result *= a
      };

      return result
    }
});

myApp.service('commonService').service('commonService', function() {
    
/*
   $scope.getMyData = function(my_number) {
    $http.get('/api').success(function(data) {
      var data_array=angular.fromJson(data);

    //console.log(data_array);
    //console.log("length"+data_array.length);

    for(i=0;i<data_array.length;i++){ 
      if(data_array[i]['user_id']==my_number){
       //console.log(data_array[i]);
       $scope.mytasks=$scope.mytasks.concat(data_array[i]);
     }
   }
   //console.log($scope.mytasks);
 }).
    error(function(data, status, headers, config) {
    });
  }*/

  this.getMyData = function(my_number,$http,$scope) {
    $http.get('/api').success(function(data) {
      var data_array=angular.fromJson(data);

    //console.log(data_array);
    //console.log("length"+data_array.length);

    for(i=0;i<data_array.length;i++){ 
      if(data_array[i]['user_id']==my_number){
       //console.log(data_array[i]);
       $scope.mytasks=$scope.mytasks.concat(data_array[i]);
     }
   }
   //console.log($scope.mytasks);
 }).
    error(function(data, status, headers, config) {
    });
  }


  this.getData = function($http,$scope) {

    $http.get('/api').success(function(data) {
      $scope.tasks = data;
      //getMyData(1,$http,$scope);
      var data_array=angular.fromJson(data);
    }).
    error(function(data, status, headers, config) {
    });
  }

   this.getLogiingUserId=function($http,$scope) {

    $http.get('/logging_user_id').success(function(data) {
    //console.log("$scope.getLogiingUserId:");
   // console.log(data);
   var data_array=angular.fromJson(data);
   $scope.user_id=data_array['user_id'];
 }).
    error(function(data, status, headers, config) {
    });

  }



   this.addNew = function($http,$scope) {
      // Simple POST request example (passing data) :
      console.log("addNew");
      $http.post('/tasks', {label:$scope.newTasklabel,target:$scope.newTasktarget,user_id:"7777"}).
      success(function(data, status, headers, config) {

        console.log("addnew $http success"+$scope.newTasktarget);
        //console.log($scope.newTaskuser_id);
        $scope.tasks.push({"label":$scope.newTasklabel,"progress":false,"target":$scope.newTasktarget,"user_id":$scope.newTaskuser_id});
        $scope.newTasklabel = '';
        $scope.newTasktarget = '';
        $scope.newTaskuser_id = '';
        //$scope.getData();
         commonService.getData($http,$scope);
        $scope.setTaskCalendar();
      }).
      error(function(data, status, headers, config) {
        console.log("error:addNew");
      });
    }



});//finish commonService

myApp.controller('mainCtrl', ['$scope','$compile','$http','$modal','ngDialog', 'commonService', function($scope,$compile,$http,$modal,ngDialog, commonService) {
  //console.log(mathService.add(1,2));
  //console.log(mathService.add(2,10));

  $scope.models = [];
  $scope.tasks = [];
  $scope.mytasks = [];
  $scope.user = [];
  $scope.user_id;
  $scope.progressTasks=[];
  $scope.events=[];//calendar反映
  $scope.dialogAddLabel, $scope.dialogEditLabel,$scope.dialogEditTaskId;

  //calendar
  var date = new Date();
  var d = date.getDate();
  var m = date.getMonth();
  var y = date.getFullYear();

  $scope.eventSource = {
    url: "http://www.google.com/calendar/feeds/usa__en%40holiday.calendar.google.com/public/basic",
              className: 'gcal-event',           // an option!
              currentTimezone: 'America/Chicago' // an option!
            };


            $scope.events = [
  /*  {title: 'All Day Event',start: new Date(y, m, 1)},
    {title: 'Long Event',start: new Date(y, m, d - 5),end: new Date(y, m, d - 2)},
    {id: 999,title: 'Repeating Event',start: new Date(y, m, d - 3, 16, 0),allDay: false},
    {id: 999,title: 'Repeating Event',start: new Date(y, m, d + 4, 16, 0),allDay: false},
    {title: 'Birthday Party',start: new Date(y, m, d + 1, 19, 0),end: new Date(y, m, d + 1, 22, 30),allDay: false},
    {title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'}*/
    ];


    $scope.eventsF = function (start, end, timezone, callback) {
      var s = new Date(start).getTime() / 1000;
      var e = new Date(end).getTime() / 1000;
      var m = new Date(start).getMonth();
      var events = [{title: 'Feed Me ' + m,start: s + (50000),end: s + (100000),allDay: false, className: ['customFeed']}];
    // callback(events);
    // return events;
  };

  $scope.calEventsExt = {
    color: '#f00',
    textColor: 'yellow',
    events: []
  };

  



  //hint: http://fullcalendar.io/docs/mouse/dayClick/
  $scope.dayClick=function(date, jsEvent, view) {
    $scope.openDialogToAdd();
    $scope.clicked_date=new Date (date.getFullYear(),(date.getMonth()),date.getDate(),12,0);
        //$scope.getData();//$scope.data[] <= api 

      //$scope.setTaskCalendar();//$scope.events[] <= api

    }
//when calendar is clicked, ngdialog open 
$scope.openDialogToAdd = function () {
 console.log("openDialogToAdd");
 ngDialog.open({ 
  template: 'DialogToAdd',
  scope: $scope          
});
      commonService.getData($http,$scope);//$scope.data[] <= api 
      $scope.setTaskCalendar();//$scope.events[] <= api

    };



//called from templateId(Dialog)
$scope.addNewFromCalendar=function(){
  console.log("addNewFromCalendar");
  console.log($scope.dialogAddLabel);
  $http.post('/tasks', {label:  $scope.dialogAddLabel ,target:$scope.clicked_date,user_id:"7777"})
  .success(function(data, status, headers, config) {
    $scope.tasks.push({"label":$scope.dialogAddLabel,"progress":false,"target":$scope.clicked_date,"user_id":"7777"});
    console.log("success,$http");
     // $scope.getData();//$scope.data[] <= api 
      commonService.getData($http,$scope);
      $scope.setTaskCalendar();//$scope.events[] <= api

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
     $scope.setTaskCalendar();
   }).
     error(function(data, status, headers, config) {
      console.log("error myscript/updateTask");
    });




   }

   /* alert on Drop */
   $scope.alertOnDrop = function(event, delta, revertFunc, jsEvent, ui, view){
     $scope.alertMessage = ('Event Droped to make dayDelta ' + delta);
     alert("alertOnDrop");
   };
   /* alert on Resize */
   $scope.alertOnResize = function(event, delta, revertFunc, jsEvent, ui, view ){
     $scope.alertMessage = ('Event Resized to make dayDelta ' + delta);
     alert("alertOnResize");
   };
   /* add and removes an event source of choice */
   $scope.addRemoveEventSource = function(sources,source) {
    var canAdd = 0;
    angular.forEach(sources,function(value, key){
      console.log("addRemoveEventSource");
      if(sources[key] === source){
        sources.splice(key,1);
        canAdd = 1;
      }
    });
    if(canAdd === 0){
      sources.push(source);
    }
  };
  /* add custom event*/
  $scope.addEvent = function() {
  //  console.log("addEvent");
  $scope.events.push({
    title: 'Open Sesame',
    start: new Date(y, m, 28),
    end: new Date(y, m, 29),
    className: ['openSesame']
  });
};
/* remove event */
$scope.remove = function(index) {
      //console.log("remove");
      $scope.events.splice(index,1);
    };
    /* Change View */
    $scope.changeView = function(view,calendar) {
   // console.log("changeView");
   uiCalendarConfig.calendars[calendar].fullCalendar('changeView',view);
 };
 /* Change View */
 $scope.renderCalender = function(calendar) {
  if(uiCalendarConfig.calendars[calendar]){
    uiCalendarConfig.calendars[calendar].fullCalendar('render');
  }
};
/* Render Tooltip */
$scope.eventRender = function( event, element, view ) { 
  element.attr({'tooltip': event.title,
   'tooltip-append-to-body': true});
  $compile(element)($scope);
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
    eventResize: $scope.alertOnResize,
    eventRender: $scope.eventRender,

    dayClick:$scope.dayClick
  }
};




/* event sources array*/
$scope.eventSources = [$scope.events, $scope.eventSource, $scope.eventsF];
  // $scope.eventSources2 = [$scope.calEventsExt, $scope.eventsF, $scope.events];




  $scope.setTaskCalendar = function() {
    $http.get('/api').success(function(data) {
      var data_array=angular.fromJson(data);

   // console.log("setTaskCalendar"+data_array);
    //配列を初期化しないと、addtaskしたときなどに既存のtaskが二重ではいる
    $scope.events.length=0;

    for(i=0;i<data_array.length;i++){ 
     target_Dateobject=new Date(data_array[i]['target']);
     $scope.events.push({title: data_array[i]['label'],start: new Date(y, target_Dateobject.getMonth(), target_Dateobject.getDate()),task_id:data_array[i]['id']});

   }
   //console.log($scope.mytasks);
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

  $scope.setTaskCalendar();





















/*


  $scope.getData = function() {

    $http.get('/api').success(function(data) {
      $scope.tasks = data;
      $scope.getMyData(1);
      var data_array=angular.fromJson(data);
    }).
    error(function(data, status, headers, config) {
    });
  }*/
  //$scope.getData();
   commonService.getData($http,$scope);
 /* $scope.getLogiingUserId=function() {

    $http.get('/logging_user_id').success(function(data) {
    //console.log("$scope.getLogiingUserId:");
   // console.log(data);
   var data_array=angular.fromJson(data);
   $scope.user_id=data_array['user_id'];
 }).
    error(function(data, status, headers, config) {
    });

  }*/
  //$scope.getLogiingUserId();
  commonService.getLogiingUserId($http,$scope);
/*
  $scope.getMyData = function(my_number) {
    $http.get('/api').success(function(data) {
      var data_array=angular.fromJson(data);

    //console.log(data_array);
    //console.log("length"+data_array.length);

    for(i=0;i<data_array.length;i++){ 
      if(data_array[i]['user_id']==my_number){
       //console.log(data_array[i]);
       $scope.mytasks=$scope.mytasks.concat(data_array[i]);
     }
   }
   //console.log($scope.mytasks);
 }).
    error(function(data, status, headers, config) {
    });
  }

*/


/*
  $scope.addNew = function() {
      // Simple POST request example (passing data) :
      console.log("addNew");



      $http.post('/tasks', {label:$scope.newTasklabel,target:$scope.newTasktarget,user_id:"7777"}).
      success(function(data, status, headers, config) {

        console.log("addnew $http success"+$scope.newTasktarget);
        //console.log($scope.newTaskuser_id);
        $scope.tasks.push({"label":$scope.newTasklabel,"progress":false,"target":$scope.newTasktarget,"user_id":$scope.newTaskuser_id});
        $scope.newTasklabel = '';
        $scope.newTasktarget = '';
        $scope.newTaskuser_id = '';
        //$scope.getData();
         commonService.getData($http,$scope);
        $scope.setTaskCalendar();

      }).
      error(function(data, status, headers, config) {
        console.log("error:addNew");
      });

    }*/

    $scope.updateTask = function(task_id,$index) {

     var updateTasklabel=$scope.models[task_id];

     //console.log(updateTasklabel);
     //console.log("myscript.js/updateTask");
     //$httpになげるtaskformはlabel,target,user_id
     $http.post('/tasks/'+task_id+'/update', {target:"2015-01-01",label:updateTasklabel,user_id:"7777"}).
     success(function(data, status, headers, config) {
     // console.log("update success:"+task_id);
     $scope.tasks.splice(task_id,1,{"label":updateTasklabel,"progress":false,"id":task_id,"user_id":"12345"});
     $scope.updateTasklabel = '';
     //$scope.getData();
      commonService.getData($http,$scope);
     $scope.setTaskCalendar();
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

    var onlyprogressTasks=[];
    angular.forEach($scope.tasks,function(task){
     if(task.progress) onlyprogressTasks.push(task);
   });
    		//console.log(onlyprogressTasks);
    		$scope.progressTasks=onlyprogressTasks

      }

      $scope.deleteTask= function(task_id) {

       // console.log("myscript.js/deleteTask");
          // Simple POST request example (passing data) :
          $http.post('/tasks/'+task_id+'/delete', {id:task_id}).
          success(function(data, status, headers, config) {
           // console.log("delete success:$index:"+task_id);
           $scope.tasks.splice(task_id,1)
           //$scope.getData()
            commonService.getData($http,$scope);
           $scope.setTaskCalendar()
         }).
          error(function(data, status, headers, config) {
          });

        }


        $scope.deleteprogress = function() {
    		//scope.tasksを一旦全てoldTasksに移し替え、progressでないものだけ再びscope.tasksに戻す
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
              //console.log("delete success:$index:"+task.id);
              $scope.tasks.splice(task.id,1)
              //$scope.getData()
               commonService.getData($http,$scope);
              //console.log("delete!!!"+task.id);
            }).
            error(function(data, status, headers, config) {
            });


          }
        });
      }
      $scope.checkUncheckTask= function(task_id,task_progress) {

       // console.log("myscript.js/check or uncheck");
          // Simple POST request example (passing data) :
          if(task_progress){
            $http.post('/tasks/'+task_id+'/check', {id:task_id}).
            success(function(data, status, headers, config) {
            //  console.log("check success:$index:"+task_id);
              // $scope.tasks.splice(task_id,1)
              //$scope.getData();
               commonService.getData($http,$scope);
            }).
            error(function(data, status, headers, config) {
            });
          }else{
            $http.post('/tasks/'+task_id+'/uncheck', {id:task_id}).
            success(function(data, status, headers, config) {
              //console.log("uncheck success:$index:"+task_id);
              // $scope.tasks.splice(task_id,1)
              //$scope.getData();
               commonService.getData($http,$scope);
            }).
            error(function(data, status, headers, config) {
            });

          }

        }







      }
      ]);//finish of myapp.controller





