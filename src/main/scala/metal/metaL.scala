package metal

import frame.{Frame, Lang, Strinq}

object metaL extends App {

  println( new Frame("hello","world") \\ new Strinq(V="homoiconic") << new Lang(V="language") )

}
