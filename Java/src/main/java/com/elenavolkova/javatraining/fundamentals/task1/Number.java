package com.elenavolkova.javatraining.fundamentals.task1;

class Number implements Comparable<Number>
{
    private String value;
    private int length;

    Number(String intValue)
    {
        value = intValue;
        length = value.length();
    }

    public String getValue()
    {
        return value;
    }

    public int getLength()
    {
        return length;
    }

    @Override
    public int compareTo(Number o)
    {
        return length - o.length;
    }
}
