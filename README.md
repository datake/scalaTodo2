This is your new Play application
=================================

This file will be packaged with your application, when using `activator dist`.

playframeworkのチュートリアルのTodolistを元にカレンダーで日付管理、ユーザー認証機能,タスクのグラフ機能を追加。
カレンダーをクリック、ドロップでタスクの追加、編集ができ、githubAPIを利用してコミットログから自分が終了したタスクをチェックすることができる.
Angular-UI-Calendar(https://github.com/angular-ui/ui-calendar)など
bowerでバージョンや関係を設定した。
public/bower.jsonに依存関係とバージョンがかいてある。


 "dependencies": {
    "angular-ui-calendar": "0.8.1",
    "angular-animate": "1.2.0",
    "jquery": "~2.1.3",
    "angular-bootstrap": "~0.12.0",
    "bootstrap": "3.1.1",
    "bootstrap-datetimepicker": "~0.0.11",
    "angular": "1.2.0",
    "ngDialog": "~0.3.9",
    "angular-chart.js": "~0.3.14"
  }