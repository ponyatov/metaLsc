package frame

import scala.collection.mutable.Map
import scala.collection.mutable.ArrayBuffer
import scala.ref.WeakReference

class Frame(val T:String,var V:String) {

  var slot = Map[String,Frame]()
  var nest = ArrayBuffer[Frame]()

  val id = WeakReference(this).hashCode()

  override def toString = dump()
  def head(prefix:String = ""):String = s"$prefix<$T:$V> @$id"
  def dump(depth:Int =0,prefix:String = ""): String = {
    var tree:String = pad(depth) + head(prefix)
    for ((k,v) <- slot) tree += v.dump(depth+1, prefix = s"$k = ")
    for ( i <- nest) tree += i.dump(depth+1)
    tree
  }
  def pad(N:Int) = "\n" + "\t" * N

  def <<(that:Frame) = { slot(that.V) = that ; this }
  def \\(that:Frame) = { nest.append(that)   ; this }
  def update(key:String,that:Frame) = { slot(key) = that ; this }

}
