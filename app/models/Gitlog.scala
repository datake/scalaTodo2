package models

// Required for Anorm mapping capability
import anorm._
import anorm.SqlParser._

// Required for the Play db functionality
import play.api.db._
import play.api.Play.current
import java.util.Date

case class Gitlog(id: Long,label: String,progress:Long,target:Date,user_id:Long)
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




object Gitlog{
val gitlog = {
		//id,label,progressというデータをつなげる。上に解説
		get[Long]("id") ~
		get[String]("label") ~
		get[Long]("progress") ~ 
		get[Date]("target") ~
		get[Long]("user_id") map {
			case id ~ label ~progress ~target ~user_id=> Gitlog(id, label,progress,target,user_id)
		}
		
	}


}
/*

	object JsonFormats {
		import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  
  implicit val gitlogFormat = Json.format[Gitlog]
}*/