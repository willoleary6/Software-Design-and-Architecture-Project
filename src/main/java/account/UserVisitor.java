package account;

public interface UserVisitor {

    void visit(AirlineEmployee user);
    void visit(Customer user);
}
