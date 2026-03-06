package ru.tequila.lab.domain;

    public final class Coordinates {
        private float x;
        private Long y;

        public Coordinates(float x, Long y) {
            this.x = x;
            this.y = y;
        }

        public float getX() { return x; }
        public void setX(float x) { this.x = x; }
        public Long getY() { return y; }
        public void setY(Long y) { this.y = y; }

        @Override
        public String toString() {
            return String.format("Coordinates{x=%.2f, y=%d}", x, y);
        }
    }


