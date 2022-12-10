

package Management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Class.*;

public class RelationshipManagement {
    private List<InsurancePolicy> arrRelative = new ArrayList<>();

    public List< InsurancePolicy > getArrRelative() {
        return arrRelative;
    }

    public RelationshipManagement() {
    }

    public void setArrRelative(List< InsurancePolicy> arrRelative) {
        this.arrRelative = arrRelative;
    }

    public RelationshipManagement(List< InsurancePolicy> arrRelative) {
        this.arrRelative = arrRelative;
    }

    public void add(InsurancePolicy... insurance) {
        this.arrRelative.addAll(Arrays.asList(insurance));
    }

    public void remove(InsurancePolicy... insurance) {
        this.arrRelative.removeAll(Arrays.asList(insurance));
    }

    public List<InsurancePolicy> search(Employee employee) {
        return this.arrRelative.stream().filter(r -> r.getEmployee().equals(employee)).collect(Collectors.toList());
    }

    public void showInfor() {
        this.arrRelative.forEach(r -> r.showInfor());
    }
}
