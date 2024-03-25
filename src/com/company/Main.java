package com.company;

// принцип не изменяемости родительского класса
// вот пример кода, котороый будет полным говно-кодом (так делать нельзя!)
// Всё потому что квадрат наследуется от прямоугольника и при вызове берет его параметры
// но вот незадача, у квадрата все стороны равны и у нас главная ошибка мы вводили 2 значения причем разные
// поэтому у родительского класа поменялось поведение

/*
public class Main {

    // вместо прямоугольника вызвали квадрат
    static Rectangl getRect(){
        return new Square();
    }

    public static void main(String[] args) {
	    Rectangl rectangl = getRect();
	    rectangl.setHeight(10);
	    rectangl.setWidth(5);
        System.out.println(rectangl.getSquare());
    }
}

// прямоугольник
class Rectangl{
    int width;
    int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSquare(){
        return width * height;
    }
}

// квадрат
class Square extends Rectangl{
    public void setWidth(int width) {
        this.width = width;
        height = width;
    }

    public void setHeight(int height) {
        this.height = height;
        width = height;
    }
}

 */

// --------------------------------------------------------- как исправить
// сделать другое наследование (независимое),
// где не будет изменяться поведение родительского класса

public class Main {

    static Rectangl getRect(){
        return new Rectangl();
    }

    public static void main(String[] args) {
	    Rectangl rectangl = getRect();
	    rectangl.setHeight(10);
	    rectangl.setWidth(5);
        System.out.println(rectangl.getSquare());
    }
}

// для этого и создадим интерфес
interface Shape{
    int getSquare();
}

// прямоугольник
class Rectangl implements  Shape{
    int width;
    int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getSquare() {
        return width * height;
    }
}

// квадрат
class Square implements Shape{
    int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getSquare() {
        return width * width;
    }
}
