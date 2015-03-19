package models

// Required for Anorm mapping capability
import anorm._
import anorm.SqlParser._

// Required for the Play db functionality
import play.api.db._
import play.api.Play.current
import java.util.Date

case class Task(id: Long,label: String,progress:Long,target:Date,user_id:Long,created:Date)

//case class Gitlog(id: Long,label: String,progress:Long,target:Date,user_id:Long)
/* message from saitoh about ~
case class ~(a: String, b: Long)

object TestObj {
	val joined = "a" ~ 123

	joined match {
		case a ~ b => println(a, b)
		//case ~ a b=>println(a,b)
	}
}
*/



/*
object Gitlog{
val gitLog = {
		//id,label,progressというデータをつなげる。上に解説
		get[Long]("id") ~
		get[String]("label") ~
		get[Long]("progress") ~ 
		get[Date]("target") ~
		get[Long]("user_id") map {
			case id ~ label ~progress ~target ~user_id=> Gitlog(id, label,progress,target,user_id)
		}	
	}
}*/
object Task {
	// Parser for mapping JDBC ResultSet to a single entity of Task model
	val task = {
		//id,label,progressというデータをつなげる。上に解説
		get[Long]("id") ~
		get[String]("label") ~
		get[Long]("progress") ~ 
		get[Date]("target") ~
		get[Long]("user_id") ~
		get[Date]("created")  map {
			case id ~ label ~progress ~target ~user_id ~ created=> Task(id, label,progress,target,user_id,created)
		}
		
	}


	def all(): List[Task] = DB.withConnection { implicit c =>
		SQL("select * from task").as(task *)
	}

	def create(label: String,target: Date,user_id:Long,created:Date) {
		DB.withConnection { implicit c =>
			SQL("insert into task (label,target,user_id,created) values ({label},{target},{user_id},{created})").on(
				'label -> label,
				'target->target,
				'user_id->user_id,
				'created->created
				).executeUpdate()
		}
	}

	def delete(id: Long) {
		DB.withConnection { implicit c =>
			SQL("delete from task where id = {id}").on(
				'id -> id
				).executeUpdate()
		}
	}	
	//called Task.update(id, label,user_id)
	def update(id: Long,label:String,user_id:Long) {
		DB.withConnection { implicit c =>
			SQL("update task set label={label} where id = {id}").on(
				'id -> id,
				'label -> label
				).executeUpdate()
		}
	}
	def check(id: Long) {
		DB.withConnection { implicit c =>
			//SQL("update task set progress = if(progress=1, 0, 1) where id = {id}").on(
				SQL("update task set progress = 1  where id = {id}").on(
					'id -> id
					).executeUpdate()
			}
	}
	def uncheck(id: Long) {
		DB.withConnection { implicit c =>
			SQL("update task set progress = 0  where id = {id}").on(
				'id -> id
				).executeUpdate()
		}
	}	

	def changeDate(id: Long,target:Date,user_id:Long){
		DB.withConnection { implicit c =>
			SQL("update task set target={target} where id = {id}").on(
				'id -> id,
				'target -> target
				).executeUpdate()
		}
	}
}

	object JsonFormats {
		import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val taskFormat = Json.format[Task]
  //implicit val gitLogFormat = Json.format[Gitlog]
}