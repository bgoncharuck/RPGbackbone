package rpgbackbone.Item

interface NotEquipable: Template {
  override fun isEquipable(): Boolean { return false }
}

interface Ingredient: NotEquipable, Usable {
}

interface Potion: NotEquipable, Usable {
}

interface Food: NotEquipable, Usable {
}

interface Drink: NotEquipable, Usable {
}
