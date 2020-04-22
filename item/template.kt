package rpgbackbone.Item

interface Template: rpgbackbone.RPGBBObject {
  val code: Code
  fun isUsable(): Boolean
  fun isEquipable(): Boolean
}

interface NotUsable: Template {
  override fun isUsable():Boolean { return false }
}

interface Usable: Template {
  override fun isUsable():Boolean { return true }
  val visitor: rpgbackbone.Entity.Visitor
}
