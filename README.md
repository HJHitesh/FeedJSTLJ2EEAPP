# InventoryApp_J2EE

## Table of Contents
1. [Project Overview](#project-overview)
2. [Technologies Used](#technologies-used)
3. [Running the Application](#running-the-application)
4. [Learning Objectives](#learning-objectives)
5. [Tasks](#tasks)
   - [Task 1: Implement JSTL to Display Inventory List](#task-1-implement-jstl-to-display-inventory-list)
   - [Task 2: Display Current Date and Time](#task-2-display-current-date-and-time)
   - [Task 3: Develop a Custom Tag](#task-3-develop-a-custom-tag)
6. [Code Snippets](#code-snippets)
   - [Entity Class: Item](#entity-class-item)
   - [Controller Class: ProductController](#controller-class-productcontroller)
   - [Sample JSP Page: inventory.jsp](#sample-jsp-page-inventoryjsp)
   - [Custom Tag Class](#custom-tag-class)
   - [Tag Library Descriptor (TLD) File: mytags.tld](#tag-library-descriptor-tld-file-mytags-tld)
7. [Maven Dependencies](#maven-dependencies)
8. Author
9. Screenshots for Running App

## Project Overview

The **InventoryApp_J2EE** is a web application built using JSP, JSTL, Maven, Hibernate, and MySQL. The application allows users to manage an inventory of products, displaying relevant product information in a user-friendly interface.

## Technologies Used

- **JSP / JSTL**
- **Maven**
- **Hibernate**
- **MySQL**
- **Servlet J2EE**

## Running the Application

To run the application, execute the following commands in your terminal:

```bash
mvn clean install

```

## Learning Objectives

By the end of this project, students should be able to:
1. Understand JSP and JSTL
2. Implement JSTL Tag
3. Create Custom Tags
4. Utilize Java Beans
5. Integrate MVC Pattern: 
6. Work with Databases:

## Tasks

### Task 1: Implement JSTL to Display Inventory List
In this task, we will utilize JSTL to display an inventory list on the web page.

**Code Snippet:**
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
    <thead>
        <tr>
            <th>Item ID</th>
            <th>Name</th>
            <th>Quantity</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.quantity}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
```

### Task 2: Display Current Date and Time
In this task, we will display the current date and time on the webpage.

**Code Snippet:**
```jsp
<%@ page import="java.util.Date" %>
<%
    Date date = new Date();
    out.println("Current Date and Time: " + date.toString());
%>
```

### Task 3: Develop a Custom Tag
This task involves creating a custom tag that can be used to display formatted item details.

**Code Snippet:**
```java
// Custom Tag Class
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

```
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<taglib xmlns="http://java.sun.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
        http://java.sun.com/xml/ns/javaee/web-jsptaglibrary_2_1.xsd"
        version="2.1">

    <tlib-version>1.0</tlib-version>
    <short-name>custom</short-name>
    <uri>http://hitesh/custom-tags</uri>

    <tag>
        <name>copyright</name>
        <tag-class>com.chat.tags.CopyrightTag</tag-class>
        <body-content>empty</body-content>
        <attribute>
            <name>year</name>
            <required>true</required>
            <rtexprvalue>true</rtexprvalue>
        </attribute>
        <attribute>
            <name>name</name>
            <required>true</required>
            <rtexprvalue>true</rtexprvalue>
        </attribute>
    </tag>
</taglib>

```

### Task 2: Display Current Date and Time
In this task, we will display the current date and time on the webpage.

**Code Snippet:**
```jsp
<%@ page import="java.util.Date" %>
<%
    Date date = new Date();
    out.println("Current Date and Time: " + date.toString());
%>
```

### Task 7: Maven Dependencies
This project uses Maven for dependency management. The following dependencies are included in the pom.xml file:

**Code Snippet:**
```xml
<dependencies>
    <!-- Jakarta Servlet API -->
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>6.0.0</version>
        <scope>provided</scope>
    </dependency>

    <!-- Hibernate Core -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.6.12.Final</version>
    </dependency>

    <!-- JDBC Driver (for example, MySQL) -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.30</version>
    </dependency>

    <!-- Java Validation API -->
    <dependency>
        <groupId>javax.validation</groupId>
        <artifactId>validation-api</artifactId>
        <version>2.0.1.Final</version>
    </dependency>

    <dependency>
        <groupId>jakarta.servlet.jsp</groupId>
        <artifactId>jakarta.servlet.jsp-api</artifactId>
        <version>3.0.0</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>jakarta.servlet.jsp.jstl</groupId>
        <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
        <version>3.0.0</version>
    </dependency>

    <dependency>
        <groupId>org.glassfish.web</groupId>
        <artifactId>jakarta.servlet.jsp.jstl</artifactId>
        <version>3.0.1</version>
    </dependency>

    <dependency>
        <groupId>org.hibernate.validator</groupId>
        <artifactId>hibernate-validator</artifactId>
        <version>8.0.1.Final</version>
    </dependency>
</dependencies>

```


### Task 8: Author

Name: Hitesh Jha
Email: Jhahitesh1994@gmail.com

### Task 9: Screenshots for Running App

### Inventory List
![Inventory List](screensh/inventory_list.png)





