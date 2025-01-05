package com.educandoweb.course.util;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;

public class BcryptHashPassword {
  public static String hashPassword(String password) {
    String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

    return hashedPassword;
  }

  public static boolean verifyPassword(String password, String passwordToCompare) {
    Result passwordVerification = BCrypt.verifyer().verify(password.toCharArray(), passwordToCompare);

    return passwordVerification.verified;
  }
}
