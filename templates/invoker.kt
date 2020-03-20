package rpgbackbone.Invoker

interface EnchTemplate: rpgbackbone.Entity.Visitor {
  val toApply: List<rpgbackbone.Ench.Template>
}

class Ench(val _toApply: List<rpgbackbone.Ench.Template>): EnchTemplate {
  override val toApply: List<rpgbackbone.Ench.Template> = _toApply
  override fun visit(entity: rpgbackbone.Entity.NonEssential) {
    toApply.forEach {
      ench -> when (ench.code) {

        rpgbackbone.Ench.Code.Poison -> entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.Health }!!.value -= ench.change / (entity.attributes.find{ resistance -> resistance.code == rpgbackbone.Attribute.Code.PoisonResistance }?.value ?: 1)

        rpgbackbone.Ench.Code.Heal -> {
          val _health= entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.Health }!!.value
          val _maxhealth= entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.MaxHealth }!!.value
          if (_maxhealth >= _health + ench.change) {
            entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.Health }!!.value+= ench.change
          }
          else entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.Health }!!.value= _maxhealth
        }

        else -> {}
      }
    }
  }
  override fun visit(rpgbbobject: rpgbackbone.RPGBBObject) {return}
}