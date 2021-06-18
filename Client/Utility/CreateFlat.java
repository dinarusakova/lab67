package Utility;

import FlatStuff.Coordinates;
import FlatStuff.Flat;
import FlatStuff.Furnish;
import FlatStuff.House;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateFlat {

        private final static Scanner scanner = new Scanner(System.in);

        public Flat create(Object id) {
            Flat flat = new Flat();
            Coordinates coordinates =new Coordinates();
            House house = new House();
                if(id.equals("free")) {
                   flat.setId(FlatCollection.generateId());
                }
                else {
                    flat.setId((Integer)id);
                }
                this.setName(flat);
                this.setCoordinateX(coordinates);
                this.setCoordinateY(coordinates);
                flat.setCoordinates(coordinates);
                this.setArea(flat);
                this.setNumberOfRooms(flat);
                this.setPrice(flat);
                this.setFurnish(flat);
                this.setName(house);
                this.setHouseYear(house);
                flat.setHouse(house);
            flat.setCreationDate(Timestamp.from(Instant.now()));
            return flat;

        }


        public void setName(Flat flat) {
            System.out.println("Введите название квартиры.");
            System.out.print("~ ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                this.setName(flat);
            } else flat.setName(name);
        }

        public void setCoordinateX(Coordinates coords) {
            try {
                System.out.println("Введите координату x:");
                System.out.print("~ ");
                String x = scanner.nextLine();
                if (x.equals("") || x.equals(null)) this.setCoordinateX(coords);
                else {
                    long xn = Long.parseLong(x);
                    if (xn > -161) {
                        coords.setX(xn);
                    } else {
                        System.out.println("Значение должно быть больше -161");
                        this.setCoordinateX(coords);
                    }
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Значение должно быть типа:\"long\".");
                this.setCoordinateX(coords);
            }
        }

        public void setCoordinateY(Coordinates coords) {
            try {
                System.out.println("Введите координату y:");
                System.out.print("~ ");
                String y = scanner.nextLine();
                if (y.equals("") || y.equals(null)) this.setCoordinateY(coords);
                else {
                    float xn = Float.parseFloat(y);
                    coords.setY(xn);
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Значение должно быть типа:\"float\".");
                this.setCoordinateY(coords);
            }
        }


        public void setArea(Flat flat) {
            try {
                System.out.println("Введите площадь квартиры:");
                System.out.print("~ ");
                String x = scanner.nextLine();
                double xn = Double.parseDouble(x);
                if (xn<=0 || xn>843) {
                    System.out.println("Значение поля должно быть больше 0 и меньше 843,попробуйте ещё раз.");
                    this.setArea(flat);
                }
                else flat.setArea(xn);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Значение должно быть типа:\"double\".");
                this.setArea(flat);
            }
        }

    public void setNumberOfRooms(Flat flat) {
        try {
            System.out.println("Введите количество комнат в квартире:");
            System.out.print("~ ");
            String x = scanner.nextLine();
            Long xn = Long.parseLong(x);
            if (xn<=0) {
                System.out.println("Значение поля должно быть больше 0,попробуйте ещё раз.");
                this.setNumberOfRooms(flat);
            }
            else flat.setNumberOfRooms(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\".");
            this.setNumberOfRooms(flat);
        }
    }

    public void setPrice(Flat flat) {
        try {
            System.out.println("Введите цену квартиры:");
            System.out.print("~ ");
            String x = scanner.nextLine();
            Integer xn = Integer.parseInt(x);
            if (xn<=0 || xn>=1819374195) {
                System.out.println("Значение поля должно быть больше 0 и меньше 1819374195,попробуйте ещё раз.");
                this.setPrice(flat);
            }
            else flat.setPrice(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"int\".");
            this.setPrice(flat);
        }
    }

        public void setFurnish(Flat flat) {
            System.out.println("Введите тип мебели,регистр не важен.(DESIGNER,NONE,BAD,LITTLE):");
            System.out.print("~ ");
            String dif = scanner.nextLine().toUpperCase();
            try {
                flat.setFurnish(Furnish.valueOf(dif));
            } catch (Exception e) {
                System.out.println("Значение должно соответствовать перечислинным типам. Введите значение:");
                this.setFurnish(flat);
            }
        }


    public void setName(House house) {
        System.out.println("Введите название дома.");
        System.out.print("~ ");
        String name = scanner.nextLine();
        if (name.equals("")) {
            this.setName(house);
        } else house.setName(name);
    }

    public void setHouseYear(House house) {
        try {
            System.out.println("Введите год постройки дома:");
            System.out.print("~ ");
            String x = scanner.nextLine();
            long xn = Long.parseLong(x);
            if (xn<=0) {
                System.out.println("Значение поля должно быть больше 0,попробуйте ещё раз.");
                this.setHouseYear(house);
            }
            else house.setYear(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"long\".");
            this.setHouseYear(house);
        }
    }

}
