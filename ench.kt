package rpgbackbone.Ench

interface Template: rpgbackbone.RPGBBObject {
  val code: Code
  val change: Int
}

abstract class Default(val _code: Code, val _change: Int): Template {
  override val code: Code= _code
  override val change: Int= _change
}

interface EnchInvokerTemplate: rpgbackbone.Entity.Visitor {
  val effects: List<Template>
}

class EnchInvoker(val _effects: List<Template>): EnchInvokerTemplate {
  override val effects: List<Template> = _effects
  override fun visit(entity: rpgbackbone.Entity.NonEssential) {
    effects.forEach {
      ench -> when (ench) {
        is PoisonDamage -> {

        }
        else -> {

        }
      }
    }
  }
  override fun visit(rpgbbobject: rpgbackbone.RPGBBObject) {return}
}
