package rpgbackbone.Ench

class PoisonDamage(val amount: Int): Visitor, Default(Code.Poison, amount) {
  override fun visit(entity: rpgbackbone.Entity.NonEssential) {
    entity.attributes.find {
      health -> health.code == rpgbackbone.Attribute.Code.Health
    }!!.value -= change / (
      entity.attributes.find {
        resistance -> resistance.code == rpgbackbone.Attribute.Code.PoisonResistance
      }?.value ?: 1
    )
  }
}

class FireDamage(val amount: Int): Visitor, Default(Code.Fire, amount) {
  override fun visit(entity: rpgbackbone.Entity.NonEssential) {
  entity.attributes.find {
    health -> health.code == rpgbackbone.Attribute.Code.Health
  }!!.value -= change / (
      entity.attributes.find {
        resistance -> resistance.code == rpgbackbone.Attribute.Code.FireResistance
      }?.value ?: 1
    )
  }
}

class Healing(val amount: Int): Visitor, Default(Code.Heal, amount) {
  override fun visit(entity: rpgbackbone.Entity.NonEssential) {
    val _health= entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.Health }!!.value
    val _maxhealth= entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.MaxHealth }!!.value
    if (_maxhealth >= _health + change) {
      entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.Health }!!.value+= change
    }
    else entity.attributes.find{ health -> health.code == rpgbackbone.Attribute.Code.Health }!!.value= _maxhealth
  }
}
