package rpgbackbone.Invoker

interface EnchTemplate: rpgbackbone.Entity.Visitor {
  val toApply: MutableList<rpgbackbone.Ench.Template>
  fun add(ench: List<rpgbackbone.Ench.Template>)
  fun clean()
}

// TODO
// Redone for every ench
object Ench: EnchTemplate {
  override val toApply: MutableList<rpgbackbone.Ench.Template> = mutableListOf()
  override fun add(ench: List<rpgbackbone.Ench.Template>) { toApply+= ench }
  override fun clean() { toApply.clear() }
  override fun visit(entity: rpgbackbone.Entity.NonEssential) {
    toApply.forEach {
      ench -> when (ench.code) {

        rpgbackbone.Ench.Code.Fire -> entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.Health }!!.value -= ench.change / (entity.attributes.find{ resistance -> resistance.code == rpgbackbone.Attribute.Code.FireResistance }?.value ?: 1)

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
