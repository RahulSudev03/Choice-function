/**
 * R = {SC, ST, OBC, EW S} denote the set of reserved categories. Students who do not belong
 * to any reserved category are in the General Category (GC).
 */
public enum StudentCategory{
    GC(Category.GC),
    SC(Category.SC),
    ST(Category.ST),
    OBC(Category.OBC),
    EWS(Category.EWS);

    private Category category;
    private StudentCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
