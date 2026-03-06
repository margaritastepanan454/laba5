package ru.tequila.lab.domain;
import java.time.LocalDateTime;
import java.util.Objects;

    public final class Dragon implements Comparable<Dragon> {
        private Integer id;
        private String name;
        private Coordinates coordinates;
        private LocalDateTime creationDate;
        private long age;
        private double weight;
        private DragonType type;
        private DragonCharacter character;
        private DragonHead head;

        public Dragon(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate,
                      long age, double weight, DragonType type, DragonCharacter character, DragonHead head) {
            this.id = id;
            this.name = name;
            this.coordinates = coordinates;
            this.creationDate = creationDate;
            this.age = age;
            this.weight = weight;
            this.type = type;
            this.character = character;
            this.head = head;
        }

        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public Coordinates getCoordinates() { return coordinates; }
        public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }
        public LocalDateTime getCreationDate() { return creationDate; }
        public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
        public long getAge() { return age; }
        public void setAge(long age) { this.age = age; }
        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }
        public DragonType getType() { return type; }
        public void setType(DragonType type) { this.type = type; }
        public DragonCharacter getCharacter() { return character; }
        public void setCharacter(DragonCharacter character) { this.character = character; }
        public DragonHead getHead() { return head; }
        public void setHead(DragonHead head) { this.head = head; }

        @Override
        public int compareTo(Dragon o) {
            int cmpName = name.compareTo(o.name);
            return cmpName != 0 ? cmpName : id.compareTo(o.id);
        }

        @Override
        public String toString() {
            return String.format("Dragon{id=%d, name='%s', age=%d, weight=%.2f, type=%s}",
                    id, name, age, weight, type);
        }
    }

