package rpgbackbone.Entity

interface Template: rpgbackbone.RPGBBObject {
  val attributes: List<rpgbackbone.RPGBBObject>
  fun isEssential(): Boolean
}

// needs less memory
interface Essential: Template {
  override val attributes: List<rpgbackbone.Attribute.Constant>
  override fun isEssential(): Boolean {return true}
}

interface Visitor: rpgbackbone.Visitor {
  fun visit(entity: rpgbackbone.Entity.NonEssential)
}

interface NonEssential: Template {
  fun accept(visitor: Visitor) {
    visitor.visit(this)
  }
  override val attributes: List<rpgbackbone.Attribute.Changeable>
  override fun isEssential(): Boolean {return false}
}
