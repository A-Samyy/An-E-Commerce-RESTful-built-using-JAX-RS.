package gov.iti.jets.domain.enums;

public enum Category {
    WHITE_CHOCOLATE(0),
    DARK_CHOCOLATE(1),
    DRINKS(2);
    final public int number;

    Category(int number){
        this.number=number;
    }
    public static Category getCategoryFromNumber(int num) {
        for (Category e : Category.values()) {
            if (e.number==num) {
                return e;
            }
        }
        return null;
    }
}
