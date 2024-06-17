/**
 * C = {OPEN, SC, ST, OBC, EWS} denote the set of all position categories
 */
public enum PositionCategory {
    OPEN(Category.OPEN),
    SC(Category.SC),
    ST(Category.ST),
    OBC(Category.OBC),
    EWS(Category.EWS);

    private final Category category;
    PositionCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
