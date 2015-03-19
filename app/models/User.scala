package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._
//id scalaの方ではautoincrementできない。インクリメントはsqlにまかす
case class User(user_id:Long,email: String, name: String, password: String)

object User {
  val simple = {
    get[Long]("user.user_id") ~
    get[String]("user.email") ~
    get[String]("user.name") ~
    get[String]("user.password") map {
      case user_id ~ email ~ name ~ password => User(user_id ,email, name, password)
    }
  }

  def findById(id: Long): Option[User] = {
    DB.withConnection { implicit c =>
      SQL("select * from user where user_id = {id}").on(
        'id -> id
        ).as(User.simple.singleOpt)
    }
  }


//うえでUserと定義したものしか認識しない
  def findByEmail(email: String): Option[User] = {
    DB.withConnection { implicit c =>
      SQL("select * from user where email = {email}").on(
        'email -> email
        ).as(User.simple.singleOpt)
    }
  }

  //option User型から  User型がとれる。  nulに注意 
  def findIdByEmail(email: String): Option[Long] =
    findByEmail(email).map(_.user_id)
    /*findByEmail(email) match{
      case Some(f) => f  //emailをuserモデルとして定義していないのでemailはとれない
      case None  => None
  }*/
/*
  def getUserID(email: String) :Int={
    DB.withConnection { implicit c =>
      SQL("select user_id from user  where email = {email}").on(
        'email -> email
        )
    }
  }
 */
  def findAll: Seq[User] = {
    DB.withConnection { implicit c =>
      SQL("select * from user").as(User.simple *)
    }
  }

  def authenticate(email: String, password: String): Option[User] = {
    DB.withConnection { implicit c =>
      SQL(
        """
        select * from user where
        email = {email} and password = {password}
        """
        ).on(
        'email -> email,
        'password -> password
        ).as(User.simple.singleOpt)
      }
    }

    def create(user: User): User = {
      DB.withConnection { implicit c =>
        SQL(
          """
          insert into user (
           email, name, password
           )
        values (
         {email}, {name}, {password}
         )
        """
        ).on(
        'email -> user.email,
        'name -> user.name,
        'password -> user.password
        ).executeUpdate()

        user
      }
    }
  }