package rpgbackbone

interface Visitor {
  fun visit(nonEssentialEntity: rpgbackbone.Entity.NonEssential)
  fun visit(rpgbbobject: RPGBBObject)
}

interface __rpgbbobject {
  fun accept(visitor: Visitor)
  fun ancsestorAction()
}

interface RPGBBObject: __rpgbbobject {
  override fun accept(visitor: Visitor) {
    visitor.visit(this)
  }
  override fun ancsestorAction() {
    return
  }
}

abstract class Decorator(_component: RPGBBObject): RPGBBObject {
  protected val component: RPGBBObject= _component
  override fun ancsestorAction() {
    component.ancsestorAction()
  }
  fun action() {
    component.ancsestorAction()
  }
}
