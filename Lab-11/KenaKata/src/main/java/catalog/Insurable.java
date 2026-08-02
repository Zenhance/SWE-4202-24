package kenakata.catalog;

/**
 * A marker capability: a line that the customer may choose to insure. It carries no data of its
 * own -- the insurable value of a line (unit price times quantity) is a property of the order
 * line, not of the item, since it depends on how many units were ordered.
 */
public interface Insurable {
}
