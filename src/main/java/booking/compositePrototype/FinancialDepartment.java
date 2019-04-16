package booking.compositePrototype;

public class FinancialDepartment implements Department {

    private Integer id;
    private String name;

    public FinancialDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

    // standard constructor, getters, setters

}