package com.company;

public class    Main {
    public static void main(String[] args) {

        String hexColor = "0x1FF0FF";

        MyColor c = MyColor.decode(hexColor);

        float[] hslValues = new float[3];
        float[] cmykValues = new float[4];

        hslValues = MyColor.RGBtoHSL(c.getRed(), c.getGreen(), c.getBlue());
        cmykValues = MyColor.RGBtoCMYK(c.getRed(), c.getGreen(), c.getBlue());

        System.out.println("Hue: " + (int) (hslValues[0] * 360) + "° , Saturation: " + hslValues[1] * 100 + "%, Lightness: " + hslValues[2] * 100 + "%");

        System.out.println("Cyan: " + Math.round(cmykValues[0] * 100) + "% , Magenta: " + Math.round(cmykValues[1] * 100) + "%, Yellow: " + Math.round(cmykValues[2] * 100) + "%, Black: " + Math.round(cmykValues[3] * 100) + "%");
    }
}
