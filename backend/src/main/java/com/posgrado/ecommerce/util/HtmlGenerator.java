package com.posgrado.ecommerce.util;

public class HtmlGenerator {

  public static String generateConfirmationTemplate(String name, String url) {
    return "<html>" +
        "<body>" +
        "<h1> Hello " + name + ",</h1>" +
        "<p>Please click the button below to confirm your account:</p>" +
        "<a href='" + url + "'>" +
        "<button>Confirm Account</button>" +
        "</a>" +
        "</body>" +
        "</html>";
  }

}
