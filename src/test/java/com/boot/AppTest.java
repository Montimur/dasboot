package com.boot;

import com.boot.controller.HomeController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AppTest 
{
    @Test
    public void testApp() {
        var hc = new HomeController();
        var result = hc.home();
        assertEquals(result, "Das Boot, reporting for duty!");
    }
}