package rpgbackbone.Ench

// TODO
interface Template: rpgbackbone.RPGBBObject {
  val code: Code
  val change: Int
}

abstract class Default(val _code: Code, val _change: Int): Template {
  override val code: Code= _code
  override val change: Int= _change
}

interface Visitor: Template, rpgbackbone.Entity.Visitor {
  override fun visit(rpgbbobject: rpgbackbone.RPGBBObject) { return }
}
