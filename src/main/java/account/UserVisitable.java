package account;

public interface UserVisitable {

    void accept(UserVisitor visitor);
}
