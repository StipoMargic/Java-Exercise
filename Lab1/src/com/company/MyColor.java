package com.company;

public class MyColor {

    int color;

    public MyColor(int r, int g, int b) {
        color = ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8) |
                ((b & 0xFF) << 0);
    }

    public float getRed() {
        return (color >> 16) & 0xFF;
    }

    public float getGreen() {
        return (color >> 8) & 0xFF;
    }

    public float getBlue() {
        return (color >> 0) & 0xFF;
    }

    public static MyColor decode(String color) {
        Integer intval = Integer.decode(color);
        int i = intval.intValue();
        return new MyColor((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }

    public static float max(float n1, float n2, float n3) {
        if ((n1 > n2) && (n1 > n3))
            return n1;
        else {
            if (n2 > n3)
                return n2;
            else
                return n3;
        }
    }

    public static float min(float n1, float n2, float n3) {
        if ((n1 < n2) && (n1 < n3))
            return n1;
        else {
            if (n2 < n3)
                return n2;
            else
                return n3;
        }
    }


    public static float[] RGBtoHSL(float R, float G, float B) {
        float[] hslValue = new float[3];

        float r = R / 255f;
        float g = G / 255f;
        float b = B / 255f;

        float max = max(r, g, b);
        float min = min(r, g, b);

        float h, s, l;
        l = (max + min) / 2.0f;

        if (max == min) {
            h = s = 0.0f;
        } else {
            float delta = max - min;
            s = l > 0.5 ? delta / (2.0f - max - min) : delta / (max + min);

            if (r > g && r > b)
                h = (g - b) / delta + (g < b ? 6.0f : 0.0f);

            else if (g > b)
                h = (b - r) / delta + 2.0f;

            else
                h = (r - g) / delta + 4.0f;

            h /= 6.0f;
        }

        return new float[]{h, s, l};
    }

    public static float[] RGBtoCMYK(float R, float G, float B) {
        float[] cmykValues = new float[4];

        float r = R / 255f;
        float g = G / 255f;
        float b = B / 255f;

        float k = 1 - max(r, g, b);
        float c = (1 - r - k) / (1 - k);
        float m = (1 - g - k) / (1 - k);
        float y = (1 - b - k) / (1 - k);

        return new float[]{c, m, y, k};
    }
}
