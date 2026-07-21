Gallery Design Questions

1.Which class is abstract, and why nobody may construct it.

Ans: I left Shape class abstract. It would never be constructed
as it cannot define itself how much area it should take.
Again in canvas there are no methods to draw "Shape".

2.Which parent class you left concrete, and why.

Ans: I left ShapeException and Rectangle concrete.
In Main, I need to construct Rectangle.
That's why it had been left concrete.
Again in render() method of Gallery I
need to call ShapeException which is better
than calling both its child class using pipe operator(it is a bit redundant).

3.One method you overrode even though the parent implemented it, and why.

Ans: I overrode setwidth() method in Square even though Rectangle implemented it.
Because when changing width in square I also need to change height as height = width,
whereas in Rectangle I need to change its width only

4.One method you deliberately did not override, and why.

Ans: I did not override in area() in Square as we can already implement it correctly
in parent class Rectangle.
