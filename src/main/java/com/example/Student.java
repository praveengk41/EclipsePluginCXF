package com.example;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement(name = "Student")
public class Student {
	
  private String name;

	
  public String getName() {
    return name;
  }

  
  public void setName(String name) {
    this.name = name;
  }

}