package com.chat.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class CopyrightTag extends SimpleTagSupport {
    private String year;
    private String name;

    public void setYear(String year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String message = "© " + year + " " + name + ". All rights reserved.";
        getJspContext().getOut().write(message);
    }
}
