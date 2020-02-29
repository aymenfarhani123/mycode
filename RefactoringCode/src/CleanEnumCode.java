import static java.lang.System.*;
public class CleanEnumCode {
    enum Type {
        REGULAR, NEW_RELEASE, CHILDREN, ELDER;
    }

    private final Type type;

    public CleanEnumCode(Type type) {
        this.type = type;
    }

    public int computePrice(int days) {
        switch (type) {
            case REGULAR:
                return days + 1;
            case NEW_RELEASE:
                return days * 2;
            case CHILDREN:
                return 5;
            case ELDER:
                return 1;
            default:
                throw new IllegalArgumentException("it never happens " + type);
        }
    }

    public static void main(String[] args) {
        out.println(new CleanEnumCode(Type.REGULAR).computePrice(2));
        out.println(new CleanEnumCode(Type.NEW_RELEASE).computePrice(2));
        out.println(new CleanEnumCode(Type.CHILDREN).computePrice(2));
        out.println("commit now");
    }
}
