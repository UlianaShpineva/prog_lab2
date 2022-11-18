package lab3;
public abstract class Creature {
    private final String name;
    public String getName() {
        return name;
    }
    public Creature(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Creature creature = (Creature) o;
        return getName().equals(creature.getName());
    }
}
