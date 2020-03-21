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
}

interface NotEquipable: Template {
  override fun isEquipable(): Boolean { return false }
}

interface Equipable: Template {
  override fun isEquipable(): Boolean { return true }
  val enchantment: rpgbackbone.Enchantment.Template
}

interface Ingredient: NotEquipable, Usable {
}

interface Potion: NotEquipable, Usable {
}

interface Food: NotEquipable, Usable {
}

interface Drink: NotEquipable, Usable {
}

interface Weapon: Equipable, Usable {
  val type: WeaponType
  val damage: Byte
  val speed: Float
}

interface Clothing: Equipable, Usable {
  val slot: EquipmentSlot
}

interface Armor: Clothing {
  val defense: Byte
}
