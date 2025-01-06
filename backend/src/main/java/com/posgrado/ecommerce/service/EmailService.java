package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.EmailNotification;

public interface EmailService {

  String send(EmailNotification email);
}
