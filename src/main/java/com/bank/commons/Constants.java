package com.bank.commons;

public class Constants {
    //Datos creación de la tarjeta en la BD
    public static final int YEARS_VALIDITY_CARD = 3;  //Años de vigencia de la tarjeta
    public static final String DEFAULT_STATUS_CARD = "Inactiva";  //Estado por defecto de la trajeta
    public static final String ACTIVE_STATUS_CARD = "Activa";  //Estado de activación de la trajeta
    public static final String BLOCK_STATUS_CARD = "Bloqueada";  //Estado de bloqueo de la tarjeta
    public static final Double DEFALUT_BALANCE_CARD = 0.0;  //Valor inicial saldo de la tarjeta


    //Mensaje respuesta métodos http
    public static final String CREATE_CARD = "Tarjeta creada de forma exitosa";  //Mensaje exitoso creación de tarjeta
    public static final String ACTIVE_CARD = "Tarjeta activada de forma exitosa";  //Mensaje exitoso activación de tarjeta
    public static final String LOCK_CARD = "Tarjeta bloqueada de forma exitosa";  //Mensaje exitoso bloqueo de tarjeta
    public static final String BALANCE_RECHARGE = "Recarga de saldo exitosa";  //Mensaje exitoso recarga de saldo
    public static final String CREATE_TRANSACTION = "La transaccion fue exitosa"; //Mensaje de transacción exitosa

    //Mensaje respuesta excepciones
    public static final String CAR_EXPIRY = "Fecha de tarjeta vencida"; // Fecha de vencimiento de la tarjeta
    public static final String NO_ACTIVE_STATUS_CARD = "Estado de la tarjeta diferente a activa";  //Estado diferente a activa
    public static final String INSUFFICIENT_BALANCE = "Saldo insuficiente";  //Saldo de la tarjeta menor al de la transacción
    public static final String RECORD_NOT_FOUND = "Registro no encontrado";  //No se encontró el registro buscado

    //Datos de la transacción
    public static final String SUCCESFUL_TRANSACTION = "Exitosa";  //Estado de la transacción exitosa
    public static final String VOIDED_TRANSACTION = "Anulada";  //Estado de la transacción anulada

}
