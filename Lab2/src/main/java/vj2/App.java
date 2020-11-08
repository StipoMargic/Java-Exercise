package vj2;


import vj2.classes.Watermeter;

public class App
{
    public static void main (String args[])
    {
        Watermeter watermeter = new Watermeter();
        watermeter.publish();
    }
}
