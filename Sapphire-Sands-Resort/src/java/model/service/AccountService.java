/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.entity.Account;
import model.repository.AccountRepository;

/**
 *
 * @author Admin
 */
public class AccountService {
    public static Account login(String username, String password){
        return AccountRepository.login(username, password);
    }
    public static String generateID(){
        return AccountRepository.generateNewID();
    }
    
    public static void register(Account a){
        AccountRepository.register(a);
    }
    
    public static boolean checkUserNameExist(String Account){
        return AccountRepository.checkUserNameExist(Account);
    }
}
