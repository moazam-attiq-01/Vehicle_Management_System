import java.util.Comparator;
class SortByYear implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return (int) (v1.year - v2.year);
    }
}