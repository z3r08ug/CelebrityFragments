package dev.uublabs.celebrityfragments;

import java.io.Serializable;

/**
 * Created by Admin on 11/15/2017.
 */

public class Celebrity implements Serializable {
    String name;
    String description;

    public Celebrity(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
