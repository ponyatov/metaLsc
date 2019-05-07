package metal

import frame.{Frame, Lang, Meta, Scala, Strinq, Version}

object metaL extends App {

  println( new Frame("hello","world")
    \\ ( new Lang(V="metaL")
      \\ new Strinq(V="homoiconic")
      \\ new Meta(V="programming")
    )
    << ( Scala("version") = new Version(V="2.12.8")) )

}
