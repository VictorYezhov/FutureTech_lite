package com.futureTech.service;

/**
 * Created by Victor on 09.06.2017.
 */
public interface MailSenderService {

    void  sendMail(String theme, String mailBody, String email);
    void sendMessageToAdministration(String theme, String mailBody, String email, String name);

}
