package rpgbackbone.Invoker

interface EntityVisitor: rpgbackbone.Visitor {
  fun visit(entity: rpgbackbone.Entity.NonEssential)
}

interface EffectsInvokerTemplate: EntityVisitor {
  val effects: List<rpgbackbone.Ench.CommandTemplate>
}

class DefaultEffectsInvoker(val _effects: List<rpgbackbone.Ench.CommandTemplate>): EffectsInvokerTemplate {
  override val effects: List<rpgbackbone.Ench.CommandTemplate> = _effects
  override fun visit(entity: rpgbackbone.Entity.NonEssential) {
    return
  }
  override fun visit(rpgbbobject: rpgbackbone.RPGBBObject) {return}
}
