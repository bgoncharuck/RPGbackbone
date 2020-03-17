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
    effects.forEach {
      ench -> when (ench) {
        is rpgbackbone.Ench.DamageWithResistanceCheck -> when (ench.code) {
          rpgbackbone.Ench.Code.Poison -> {
            /* ench.prepare(entity.health, entity.__overralDamageResist().toInt()) */
          }
          else -> {}
        }
      }
    }
  }
  override fun visit(rpgbbobject: rpgbackbone.RPGBBObject) {return}
}
