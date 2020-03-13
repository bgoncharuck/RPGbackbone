package rpgbackbone

interface Visitor {
  fun visit(rpgbbobject: RPGBBObject )
}

interface RPGBBObject {
  fun accept(visitor: Visitor)
  fun ancsestorAction()
}

abstract class Decorator(_component: RPGBBObject): RPGBBObject {
  protected val component: RPGBBObject= _component
  override fun accept(visitor: Visitor ) {
    visitor.visit(this)
  }
  override fun ancsestorAction() {
    component.ancsestorAction()
  }
  abstract fun action()
}
