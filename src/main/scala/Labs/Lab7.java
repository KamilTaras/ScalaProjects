package Labs;

public class Lab7 {

    interface shape {
        public double field();
    }

    static class square implements shape {
        public double getSide() {
            return side;
        }
        private double side;

        public void setSide(double side) {
            this.side = side;
        }
        public square(double side) {
            this.side = side;
        }

        @Override
        public double field() {
            return side * side;
        }

        static class triangle implements shape {
            private double base;
            private double height;

            public triangle(double base, double height) {
                this.base = base;
                this.height = height;
            }


            @Override
            public double field() {
                return base * height;
            }
        }

        static class rectangle implements shape {
            private double side1;
            private double side2;

            public rectangle(double side1, double side2) {
            }

            @Override
            public double field() {
                return side1*side2;
            }
        }

        static class circle implements shape {
            private double radius;
            @Override
            public double field() {
                return Math.PI*radius*radius;
            }
        }

        //task 4

        static class Car {

            private String brand;
            private String color;

            public Car(String brand, String color) {
                this.brand = brand;
                this.color = color;
            }

            void honk() {
                System.out.println("Honk, honk");
            }
        }

        static class SportCar extends Car {
            public SportCar(String brand, String color) {
                super(brand, color);
            }

            void loudHonk(){
                System.out.println("");
            }
        }

        static class SuperCar extends SportCar {
//        Every super car is red. But every red car is super car.

            public SuperCar(String brand) {
                super(brand, "Red");
            }


        }


        public static void main(String[] args) {
            Car regularCar = new Car("Mercedes", "Blue");
            System.out.println(regularCar.color);

            Car superCar = new SuperCar("BMW");
            System.out.println(superCar.color);
            superCar.honk();

        }

    }
}





