package rpgbackbone.Item

interface Equipable: Template, rpgbackbone.Entity.Visitor {
  override fun visit(rpgbbobject: rpgbackbone.RPGBBObject) { return }
  fun equip(entity: rpgbackbone.Entity.Template)
  override fun isEquipable(): Boolean { return true }
  val isEquiped: Boolean
  val enchantment: rpgbackbone.Enchantment.Template
  val slot: rpgbackbone.Equipment.Slot
}

interface Weapon: Equipable, NotUsable {
  val type: WeaponType
  val damage: Byte
  val speed: Float
}

interface Clothing: Equipable, NotUsable {
}

interface Armor: Clothing {
  val defense: Byte
}
