package factory;

/**
 *EXAMPLE OF SHAPE FACTORY DESIGN PATTERN : (IT IS A CREATIONAL DESIGN PATTERN)
 * It is one of the mostly used pattern to create objects.
 * we create object without exposing the creation logic
 * to the client and refer to newly created object using a common interface.
 *
 */
public class ShapeFactory {

    //use getShape method to get object of type shape
    public Shape getShape(Enum shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType == ShapeType.CIRCLE) {
            return new Circle();
        } else if (shapeType == ShapeType.RECTANGLE) {
            return new Rectangle();
        } else if (shapeType == ShapeType.SQUARE) {
            return new Square();
        } else if (shapeType == ShapeType.TRIANGLE) {
            return new Triangle();
        }
        return null;
    }
}
